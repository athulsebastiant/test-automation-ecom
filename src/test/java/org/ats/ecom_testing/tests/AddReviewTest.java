package org.ats.ecom_testing.tests;

import org.ats.ecom_testing.pages.AllProductsPage;
import org.ats.ecom_testing.pages.HomePage;
import org.ats.ecom_testing.pages.ProductDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class AddReviewTest extends org.ats.ecom_testing.base.BaseTest{
	@Test (groups = {"product"})
	@Description("Test to chech whether reviews can be added for the products correctly")
	@Severity(SeverityLevel.MINOR)
	public void addReviewTest() {
		HomePage home = new HomePage();
		Assert.assertTrue(home.isHomePageVisible(),"Home page is not visible");

		home.clickProductsBtn();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/products");
		AllProductsPage allProducts = new AllProductsPage();
		Assert.assertTrue(allProducts.isAllProductsHeaderVisible(),"All Products Header is visible");
		allProducts.clickFirstProductView();
		
		ProductDetailsPage productDetailsPage = new ProductDetailsPage();
		Assert.assertTrue(productDetailsPage.isProductNameVisible(),"Product Name is not visible");
		Assert.assertTrue(productDetailsPage.isWriteYourReviewDisplayed(),"Write Your Review Header not found");
		productDetailsPage.enterName("testNAme");
		productDetailsPage.enterEmail("test1232@mail.com");
		productDetailsPage.enterReview("Sample review");
		productDetailsPage.submitReview();
		Assert.assertTrue(productDetailsPage.isReviewAcknowledged(),"Review not acknowledged");
	}
}
