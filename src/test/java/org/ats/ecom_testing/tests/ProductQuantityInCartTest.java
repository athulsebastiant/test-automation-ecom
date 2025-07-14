package org.ats.ecom_testing.tests;

import org.ats.ecom_testing.pages.CartPage;
import org.ats.ecom_testing.pages.HomePage;
import org.ats.ecom_testing.pages.ProductDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;



public class ProductQuantityInCartTest extends org.ats.ecom_testing.base.BaseTest {
	final int productNo = 1;
	final int qty = 4;
	@Test (groups={"smoke","cart"})
	@Description("Test to check whether the user entered product quantites reflect in the cart")
	@Severity(SeverityLevel.CRITICAL)
	public void productQuantityTest() {
		HomePage home = new HomePage();
		Assert.assertTrue(home.isHomePageVisible(),"Home page is not visible");
		home.clickProductView(productNo);
		ProductDetailsPage productDetails = new ProductDetailsPage();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/product_details/"+productNo,"User was not lead to product details page");
		productDetails.ChangeQuantity(qty);
		productDetails.clickAddToCart();
		productDetails.clickViewCart();
		CartPage cartPage = new CartPage();
		Assert.assertEquals(cartPage.getQuantity(1), qty,"Quantities do not match");
		
	}
}
