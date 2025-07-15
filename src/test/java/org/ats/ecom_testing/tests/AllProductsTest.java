package org.ats.ecom_testing.tests;

import org.ats.ecom_testing.pages.AllProductsPage;
import org.ats.ecom_testing.pages.HomePage;
import org.ats.ecom_testing.pages.ProductDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class AllProductsTest extends org.ats.ecom_testing.base.BaseTest {
	
	@Test (groups = {"smoke","product"})
	@Description("Test to check whether the all products page has all products visible. Also whether the product details are visible.")
	@Severity(SeverityLevel.CRITICAL)
	public void allProductsTest() {
		HomePage home = new HomePage();
		Assert.assertTrue(home.isHomePageVisible(),"Home page is not visible");
		
		home.clickProductsBtn();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/products");
		AllProductsPage allProducts = new AllProductsPage();
		Assert.assertTrue(allProducts.isAllProductsHeaderVisible(),"All Products Header is visible");
		Assert.assertTrue(allProducts.isAllProductsListVisible(),"All Products list is not visible");
		allProducts.clickFirstProductView();
		
		ProductDetailsPage productDetailsPage = new ProductDetailsPage();
		Assert.assertTrue(productDetailsPage.isProductNameVisible(),"Product Name is not visible");
		Assert.assertTrue(productDetailsPage.isProductCategoryVisible(),"Product category is not visible");
		Assert.assertTrue(productDetailsPage.isProductPriceVisible(),"Product price is not visible");
		Assert.assertTrue(productDetailsPage.isAvailabiltyVisible(),"Product availabilty is not visible");
		Assert.assertTrue(productDetailsPage.isConditionVisible(),"Product condition is not visible");
		Assert.assertTrue(productDetailsPage.isBrandVisible(),"Product brand is not visible");
		
	}
	
	}
