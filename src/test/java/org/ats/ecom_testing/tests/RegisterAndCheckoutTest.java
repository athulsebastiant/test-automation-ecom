package org.ats.ecom_testing.tests;


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



public class RegisterAndCheckoutTest extends org.ats.ecom_testing.base.BaseTest{
	
	
	
	
	@Test (groups={"smoke","checkout"})
	@Description("Firstly signup by creating an account, then add products to cart and then and finally checkout fully.")
	@Severity(SeverityLevel.CRITICAL)
	public void registerThenPlaceOrderTest() {
		HomePage home = new HomePage();
		Assert.assertTrue(home.isHomePageVisible(),"Home page is not visible");
		
		home.clickSignupLoginBtn();
		SignupUtil.signup(driver);
		Assert.assertTrue(home.isLoggedInUserNameVisible(), "Logged in Username not visible");
		
		home.clickAddToCart(1);
		home.clickViewCart();
		CartPage cartPage = new CartPage();
		Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/view_cart","User not redirected to cart page");
		cartPage.clickProceedToCheckoutBtn();
		
		CheckoutUtil.checkout(driver, null);
		Assert.assertTrue(home.isHomePageVisible(),"Home page is not visible");
		
		home.clickDeleteAccountBtn();
		DeleteAccountUtil.deleteAccount(driver);
	}
	
	
}	
