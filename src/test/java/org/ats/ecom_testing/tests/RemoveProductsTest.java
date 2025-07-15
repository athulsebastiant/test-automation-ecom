package org.ats.ecom_testing.tests;


import java.util.HashSet;

import java.util.Set;

import org.ats.ecom_testing.pages.AllProductsPage;
import org.ats.ecom_testing.pages.CartPage;
import org.ats.ecom_testing.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class RemoveProductsTest extends org.ats.ecom_testing.base.BaseTest {
	Set <String> products = new HashSet<String>();
	Set<String> cartProducts;
	@Test (groups = {"smoke"})
	@Description("Test to check whether the user can remove products from the cart page successfully.")
	@Severity(SeverityLevel.CRITICAL)
	public void removeProductFromCartTest() {
		HomePage home = new HomePage();
		Assert.assertTrue(home.isHomePageVisible(),"Home page is not visible");
		
		home.clickProductsBtn();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/products");
		AllProductsPage allProducts = new AllProductsPage();
		Assert.assertTrue(allProducts.isAllProductsHeaderVisible(),"All Products Header is not visible");
		products.add(allProducts.clickAddToCart(1));
		allProducts.clickContinueShopping();
		products.add(allProducts.clickAddToCart(2));
		allProducts.clickViewCart();
		
		CartPage cartPage = new CartPage();
		Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/view_cart");
		cartProducts= cartPage.getAllProductsinCart();
		for (String expected : products) {
		    Assert.assertTrue(cartProducts.contains(expected),
		        "Cart does not contain expected product: " + expected);
		}
		String productToRemove = cartPage.getProductNameAtIndex(2);
		cartPage.clickRemoveProduct(2);
		cartPage.waitUntilProductRemoved(productToRemove);
		Set<String> updatedCartProducts = cartPage.getAllProductsinCart();
		Assert.assertFalse(
		        updatedCartProducts.contains(productToRemove),
		        "Removed product is still present in the cart: " + productToRemove
		    );
	}
}
