package org.ats.ecom_testing.tests;

import org.ats.ecom_testing.pages.CartPage;
import org.ats.ecom_testing.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;



public class SubscriptionTestInCart extends org.ats.ecom_testing.base.BaseTest {
	@Test (groups = {"non_critical"})
	@Description("Test to check whether the user can subscribe to the email service from the cart page successfully.")
	@Severity(SeverityLevel.MINOR)
	public void subscriptionTest(){
		HomePage home = new HomePage();
		Assert.assertTrue(home.isHomePageVisible(),"Home page is not visible");
		
		CartPage cart = new CartPage();
		cart.subscribe("asa1@mail.com");
		Assert.assertTrue(cart.subConfirmation(),"Subscription confirmation not visible");
	}
	
}
