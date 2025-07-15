package org.ats.ecom_testing.tests;

import org.ats.ecom_testing.pages.AllProductsPage;
import org.ats.ecom_testing.pages.BrandProductsPage;
import org.ats.ecom_testing.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class ProductBrandTest extends org.ats.ecom_testing.base.BaseTest {
	@Test (groups = {"product"})
	@Description("Test to check whether the user can filter products by brand successfully.")
	@Severity(SeverityLevel.NORMAL)
	public void productBrandTest() {
		HomePage home = new HomePage();
		Assert.assertTrue(home.isHomePageVisible(),"Home page is not visible");
		
		home.clickProductsBtn();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/products");
		AllProductsPage allProducts = new AllProductsPage();
		Assert.assertTrue(allProducts.isAllProductsHeaderVisible(),"All Products Header is visible");
		Assert.assertTrue(allProducts.isBrandsHeaderDisplayed(),"Brands Header not displayed");
		Assert.assertTrue(allProducts.isBrandsLinksDisplayed(),"Brand links not displayed");
		allProducts.clickBrandPolo();
		
		BrandProductsPage brandProductsPage = new BrandProductsPage();
		Assert.assertTrue(brandProductsPage.isBrandHeaderPoloDisplayed());
		Assert.assertEquals(brandProductsPage.getBrandHeaderPolo(), "BRAND - POLO PRODUCTS");
		brandProductsPage.clickHMBrandLink();
		Assert.assertEquals(brandProductsPage.getBrandHeaderHM(), "BRAND - H&M PRODUCTS");
	}

}
