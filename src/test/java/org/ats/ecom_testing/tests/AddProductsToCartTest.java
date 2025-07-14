package org.ats.ecom_testing.tests;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.ats.ecom_testing.pages.AllProductsPage;
import org.ats.ecom_testing.pages.CartPage;
import org.ats.ecom_testing.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class AddProductsToCartTest extends org.ats.ecom_testing.base.BaseTest{
	Set <String> products = new HashSet();
			
	Set<String> cartProducts;
	@Test (groups = {"smoke","cart"})
	@Description("Add products to cart and then check whether the cart contains all added products")
	@Severity(SeverityLevel.CRITICAL)
	public void addProductsToCartTest() {
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
		//Assert.assertEquals(cartProducts, products,"Cart product list does not match added products");
		for (String expected : products) {
		    Assert.assertTrue(cartProducts.contains(expected),
		        "Cart does not contain expected product: " + expected);
		}
	}
}
