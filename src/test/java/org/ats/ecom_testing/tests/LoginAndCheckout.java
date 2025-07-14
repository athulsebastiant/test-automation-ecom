package org.ats.ecom_testing.tests;

import java.util.Arrays;
import java.util.List;

import org.ats.ecom_testing.pages.CartPage;
import org.ats.ecom_testing.pages.DeletedAccountPage;
import org.ats.ecom_testing.pages.HomePage;
import org.ats.ecom_testing.pages.OrderPlacedPage;
import org.ats.ecom_testing.pages.PaymentPage;
import org.ats.ecom_testing.pages.PlaceOrderPage;
import org.ats.ecom_testing.pages.SignupLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;



public class LoginAndCheckout extends org.ats.ecom_testing.base.BaseTest {
	final String name = "TestMan";
	final String email = "asas1@mail.com";
	final String pswd = "1234567";
	final String title = "Mr."; 
	final String fName = "TestMan";
	final String LName =  "ManTest";
	final String add1= "Sample Address 1";
	final String add2 = "Sample Address 2";
	final String country = "India";
	final String state = "Kerala";
	final String city = "Thodupuzha";
	final String zip = "685587";
	final String mob = "1234567891";
	
	final String nameOnCard = fName+" "+LName;
	final String cardNo = "4546546546";
	final int cvc = 521;
	final int expMonth = 11;
	final int expYear = 2001;
	List<String> expectedAddress = Arrays.asList(title + " "+fName+" "+LName,add1,add2,city+" "+state+" "+zip,country,mob);
	
	@Test (groups = {"smoke","checkout"})
	@Description("Login to the website with existing credentials, add products to cart and then checkout fully.")
	@Severity(SeverityLevel.CRITICAL)
	public void loginAndCheckoutTest() {
		HomePage home = new HomePage();
		Assert.assertTrue(home.isHomePageVisible(),"Home page is not visible");
		home.clickSignupLoginBtn();
		SignupLoginPage signupPage = new SignupLoginPage();
		Assert.assertTrue(signupPage.isLoginHeaderVisible(), "Login header isn't visible");
		signupPage.enterLoginEmail(email);
		signupPage.enterLoginPassword(pswd);
		signupPage.clickLoginBtn();
		Assert.assertTrue(home.isLoggedInUserNameVisible(), "Logged in Username not visible");
		home.clickAddToCart(1);
		home.clickViewCart();
		CartPage cartPage = new CartPage();
		Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/view_cart","User not redirected to cart page");
		cartPage.clickProceedToCheckoutBtn();
		PlaceOrderPage placeOrderPage = new PlaceOrderPage();
		Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/checkout");
		List<String> actualDeliveryAddress = placeOrderPage.getDeliveryAddressLines();
		List<String> actualBillingAddress = placeOrderPage.getBillingAddressLines();
		Assert.assertEquals(actualDeliveryAddress, expectedAddress, "Delivery address does not match expected.");
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
		//Assert.assertTrue(paymentPage.isPaymentSuccessMessageDisplayed(),"Payment Success mesage not displayed");
		
		OrderPlacedPage orderPlacedPage = new OrderPlacedPage();
		Assert.assertTrue(
				orderPlacedPage.isOrderPlaceHeaderDisplyed() ,
			    "Unexpected URL: Payment not completed as expected"
			);
		
		orderPlacedPage.clickContinueBtn();
		Assert.assertTrue(home.isHomePageVisible(),"Home page is not visible");
		
	}
}
