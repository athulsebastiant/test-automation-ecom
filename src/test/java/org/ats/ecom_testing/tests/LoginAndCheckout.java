package org.ats.ecom_testing.tests;

import java.util.Arrays;
import java.util.List;

import org.ats.ecom_testing.pages.CartPage;

import org.ats.ecom_testing.pages.HomePage;

import org.ats.ecom_testing.utils.CheckoutUtil;
import org.ats.ecom_testing.utils.LoginUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;



public class LoginAndCheckout extends org.ats.ecom_testing.base.BaseTest {
	
	
	

	List<String> expectedAddress = Arrays.asList(LoginUtil.title + " "+LoginUtil.fName+" "+LoginUtil.LName,LoginUtil.add1,LoginUtil.add2,LoginUtil.city+" "+LoginUtil.state+" "+LoginUtil.zip,LoginUtil.country,LoginUtil.mob);
	
	@Test (groups = {"smoke","checkout"})
	@Description("Login to the website with existing credentials, add products to cart and then checkout fully.")
	@Severity(SeverityLevel.CRITICAL)
	public void loginAndCheckoutTest() {
		HomePage home = new HomePage();
		Assert.assertTrue(home.isHomePageVisible(),"Home page is not visible");
		
		home.clickSignupLoginBtn();
		LoginUtil.login(driver);
		Assert.assertTrue(home.isLoggedInUserNameVisible(), "Logged in Username not visible");
		
		home.clickAddToCart(1);
		home.clickViewCart();
		CartPage cartPage = new CartPage();
		Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/view_cart","User not redirected to cart page");
		cartPage.clickProceedToCheckoutBtn();
		
		CheckoutUtil.checkout(driver, expectedAddress);
		Assert.assertTrue(home.isHomePageVisible(),"Home page is not visible");
		
	}
}
