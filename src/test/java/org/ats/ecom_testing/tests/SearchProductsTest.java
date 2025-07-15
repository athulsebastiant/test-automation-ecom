package org.ats.ecom_testing.tests;

import org.ats.ecom_testing.pages.AllProductsPage;
import org.ats.ecom_testing.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;



public class SearchProductsTest extends org.ats.ecom_testing.base.BaseTest {
	final String keyword = "tshirt";
	@Test (groups = {"smoke","product"})
	@Description("Test to check whether the user can search for products successfully.")
	@Severity(SeverityLevel.CRITICAL)
	public void searchProductsTest() {
		HomePage home = new HomePage();
		Assert.assertTrue(home.isHomePageVisible(),"Home page is not visible");
		
		home.clickProductsBtn();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/products");
		AllProductsPage allProducts = new AllProductsPage();
		Assert.assertTrue(allProducts.isAllProductsHeaderVisible(),"All Products Header is not visible");
		allProducts.search(keyword);
		Assert.assertTrue(allProducts.isSearchedProductsHeadervisible(), "Searched Products header is not visible");
		Assert.assertTrue(allProducts.areAllSearchedProductsRelevant(keyword),"All products are not relevant");
	}

}
