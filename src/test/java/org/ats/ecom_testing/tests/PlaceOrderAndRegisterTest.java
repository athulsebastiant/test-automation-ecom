package org.ats.ecom_testing.tests;

import java.util.Arrays;
import java.util.List;

import org.ats.ecom_testing.pages.AccountCreatedPage;
import org.ats.ecom_testing.pages.CartPage;
import org.ats.ecom_testing.pages.DeletedAccountPage;
import org.ats.ecom_testing.pages.HomePage;
import org.ats.ecom_testing.pages.OrderPlacedPage;
import org.ats.ecom_testing.pages.PaymentPage;
import org.ats.ecom_testing.pages.PlaceOrderPage;
import org.ats.ecom_testing.pages.SignupDataEntryPage;
import org.ats.ecom_testing.pages.SignupLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class PlaceOrderAndRegisterTest extends org.ats.ecom_testing.base.BaseTest {
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
	
	@Test (groups = {"checkout"})
	@Description("Firstly Add products to cart and then signup by creating an account, and finally checkout fully.")
	@Severity(SeverityLevel.NORMAL)
	public void placeOrderAndRegisterTest() {
		HomePage home = new HomePage();
		Assert.assertTrue(home.isHomePageVisible(),"Home page is not visible");
		home.clickAddToCart(1);
		home.clickViewCart();
		CartPage cartPage = new CartPage();
		Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/view_cart","User not redirected to cart page");
		cartPage.clickProceedToCheckoutBtn();
		cartPage.clickRegisterLoginBtn();
		SignupLoginPage signupLoginPage = new SignupLoginPage();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login");
		signupLoginPage.enterName("TestMan");
		signupLoginPage.enterSignupEmail("testuser"+System.currentTimeMillis()+"@mail.com");
		signupLoginPage.clickSignupBtn();
		SignupDataEntryPage signUpData = new SignupDataEntryPage();
		Assert.assertTrue(signUpData.isEnterAccountInfoVisible());
		signUpData.selectTitleMr();
		signUpData.typePswd("testPass123");
		signUpData.chooseDay("5");
		signUpData.chooseMonth("June");
		signUpData.chooseYear("2002");
		signUpData.optNewsLetter(true);
		signUpData.optSpOffer(true);
		signUpData.typeFirstname(fName);
		signUpData.typeLastname(LName);
		signUpData.typeAddress1(add1);
		signUpData.typeAddress2(add2);
		signUpData.chooseCountry(country);
		signUpData.typeState(state);
		signUpData.typeCity(city);
		signUpData.typeZip(zip);
		signUpData.typeMob(mob);
		signUpData.clickCreateAccount();
		
		AccountCreatedPage accountCreatedPage = new AccountCreatedPage();
		Assert.assertTrue(accountCreatedPage.isAccountCreatedHeaderVisible(),"Account Created Header not found"); 
		accountCreatedPage.clickContinueBtn();
		
		Assert.assertTrue(home.isLoggedInUserNameVisible(), "Logged in Username not visible");
		home.clickCartBtn();
		
		
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
		orderPlacedPage.isOrderPlaceHeaderDisplyed();
		
		orderPlacedPage.clickContinueBtn();
		Assert.assertTrue(home.isHomePageVisible(),"Home page is not visible");
		home.clickDeleteAccountBtn();
		
		DeletedAccountPage deletedAccountPage = new DeletedAccountPage();
		Assert.assertTrue(deletedAccountPage.isAccountDeletedHeaderVisible(),"Account Deleted Header not visble");
		deletedAccountPage.clickContinueBtn();
	}
}
