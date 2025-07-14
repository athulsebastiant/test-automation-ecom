package org.ats.ecom_testing.tests;

import java.util.Set;

import org.ats.ecom_testing.pages.CartPage;
import org.ats.ecom_testing.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class AddRecommendedProducts extends org.ats.ecom_testing.base.BaseTest {
	final String productName = "Blue Top";
	Set<String> cartProducts;
	@Test (groups = {"cart"})
	@Description("Add the recommended products from the home page to cart and then check whether all the products are added successfully.")
	@Severity(SeverityLevel.MINOR)
	public void addRecommendedProducts() {
		HomePage home = new HomePage();
		Assert.assertTrue(home.isHomePageVisible(),"Home page is not visible");
		home.scrollToRecommendedSection();
		Assert.assertTrue(home.isRecommendedItemsDisplayed(), "Recommended items header not found ");
		home.clickAddToCartForRecommendedProduct(productName);
		home.clickViewCart();
		CartPage cartPage = new CartPage();
		Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/view_cart");
		cartProducts= cartPage.getAllProductsinCart();
		Assert.assertTrue(cartProducts.contains(productName), 
			    "Expected product '" + productName + "' was not found in the cart.");
	}
}
