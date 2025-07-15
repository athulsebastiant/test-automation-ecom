package org.ats.ecom_testing.utils;

import java.util.Arrays;
import java.util.List;

import org.ats.ecom_testing.pages.OrderPlacedPage;
import org.ats.ecom_testing.pages.PaymentPage;
import org.ats.ecom_testing.pages.PlaceOrderPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutUtil {
	static List<String> expectedAddress = Arrays.asList(SignupUtil.title + " "+SignupUtil.fName+" "+SignupUtil.LName,SignupUtil.add1,SignupUtil.add2,SignupUtil.city+" "+SignupUtil.state+" "+SignupUtil.zip,SignupUtil.country,SignupUtil.mob);
	final static String nameOnCard = SignupUtil.fName+" "+SignupUtil.LName;
	final static String cardNo = "4546546546";
	final static int cvc = 521;
	final static int expMonth = 11;
	final static int expYear = 2001;
	public static void checkout(WebDriver driver, List<String>expAddress) {
		PlaceOrderPage placeOrderPage = new PlaceOrderPage();
		Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/checkout");
		List<String> actualDeliveryAddress = placeOrderPage.getDeliveryAddressLines();
		List<String> actualBillingAddress = placeOrderPage.getBillingAddressLines();
		if(expAddress == null || expAddress.isEmpty()) {
			Assert.assertEquals(actualDeliveryAddress, expectedAddress, "Delivery address does not match expected.");
		}
		else {
			Assert.assertEquals(actualDeliveryAddress, expAddress, "Delivery address does not match expected.");
		}
		Assert.assertEquals(actualBillingAddress, actualDeliveryAddress, "Billing address does not match delivery address.");
		placeOrderPage.typeDescription("Sample Description");
		placeOrderPage.clickplaceOrderBtn();
		PaymentPage paymentPage = new PaymentPage();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/payment");
		paymentPage.fillNameOnCard(nameOnCard);
		paymentPage.fillCardNumber(cardNo);
		paymentPage.fillcvc(cvc);
		paymentPage.fillExpMonth(expMonth);
		paymentPage.fillExpYear(expYear);
		paymentPage.clickPayandConfirmBtn();
     	OrderPlacedPage orderPlacedPage = new OrderPlacedPage();
		Assert.assertTrue(
				orderPlacedPage.isOrderPlaceHeaderDisplyed() ,
			    "Unexpected URL: Payment not completed as expected"
			);
		orderPlacedPage.isOrderPlaceHeaderDisplyed();
		
		orderPlacedPage.clickContinueBtn();
	}
}
