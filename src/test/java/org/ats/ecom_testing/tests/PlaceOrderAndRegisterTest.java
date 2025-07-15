package org.ats.ecom_testing.tests;


import java.util.Collections;

import org.ats.ecom_testing.pages.CartPage;

import org.ats.ecom_testing.pages.HomePage;

import org.ats.ecom_testing.utils.CheckoutUtil;
import org.ats.ecom_testing.utils.DeleteAccountUtil;
import org.ats.ecom_testing.utils.SignupUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class PlaceOrderAndRegisterTest extends org.ats.ecom_testing.base.BaseTest {
	
	
	
	
	
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
		
		SignupUtil.signup(driver); //sign up
		Assert.assertTrue(home.isLoggedInUserNameVisible(), "Logged in Username not visible");
		home.clickCartBtn();
		
		cartPage.clickProceedToCheckoutBtn();
		CheckoutUtil.checkout(driver,Collections.emptyList()); //checkout
		Assert.assertTrue(home.isHomePageVisible(),"Home page is not visible");
		home.clickDeleteAccountBtn();
		
		DeleteAccountUtil.deleteAccount(driver);
	}
}
