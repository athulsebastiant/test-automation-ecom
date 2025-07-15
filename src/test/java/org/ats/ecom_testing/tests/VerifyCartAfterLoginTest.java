package org.ats.ecom_testing.tests;

import java.util.HashSet;
import java.util.Set;

import org.ats.ecom_testing.pages.AllProductsPage;
import org.ats.ecom_testing.pages.CartPage;
import org.ats.ecom_testing.pages.HomePage;

import org.ats.ecom_testing.utils.LoginUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;



public class VerifyCartAfterLoginTest extends org.ats.ecom_testing.base.BaseTest{
	
	final String keyword = "Cotton";
	Set<String> productsAdded = new HashSet<String>();
	Set<String> cartProducts;
	int i;
	@Test (groups = {"cart"})
	@Description("Test to check if the cart products are still present correctly after the user adds them to the cart, then returns to the cart after login.")
	@Severity(SeverityLevel.NORMAL)
	public void verifyCartAfterLogin() {
		SoftAssert softAssert = new SoftAssert();
		HomePage home = new HomePage();
		Assert.assertTrue(home.isHomePageVisible(),"Home page is not visible");
		
		home.clickProductsBtn();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/products");
		AllProductsPage allProducts = new AllProductsPage();
		allProducts.search(keyword);
		softAssert.assertTrue(allProducts.isSearchedProductsHeadervisible(),"Searched products header is not visible");
		softAssert.assertTrue(allProducts.areAllSearchedProductsRelevant(keyword));
		int noOfProdsDisplayed = allProducts.getNumberOfDisplayedProducts();
		for (i=1;i<noOfProdsDisplayed;i++) {
			productsAdded.add(allProducts.clickAddToCart(i));
			allProducts.clickContinueShopping();
		}
		productsAdded.add(allProducts.clickAddToCart(i));
		allProducts.clickViewCart();
		
		CartPage cartPage = new CartPage();
		Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/view_cart");
		cartProducts= cartPage.getAllProductsinCart();
		for (String expected : productsAdded) {
		    Assert.assertTrue(cartProducts.contains(expected),
		        "Cart does not contain expected product: " + expected);
		}
		cartPage.clickSignupLogin();
		
		LoginUtil.login(driver);
		Assert.assertTrue(home.isLoggedInUserNameVisible(), "Logged in Username not visible");
		
		home.clickCartBtn();
		Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/view_cart");
		for (String expected : productsAdded) {
		    Assert.assertTrue(cartProducts.contains(expected),
		        "Cart does not contain expected product: " + expected);
		}
		softAssert.assertAll();
	}
}
