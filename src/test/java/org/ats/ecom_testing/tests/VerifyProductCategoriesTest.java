package org.ats.ecom_testing.tests;

import org.ats.ecom_testing.pages.CategoryProductsPage;
import org.ats.ecom_testing.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;



public class VerifyProductCategoriesTest extends org.ats.ecom_testing.base.BaseTest {
	@Test (groups = {"product","non_critical"})
	@Description("Test to check whether the user can filter products by category successfully.")
	@Severity(SeverityLevel.NORMAL)
	public void verifyProductCategoriesTest() {
		HomePage home = new HomePage();
		Assert.assertTrue(home.isHomePageVisible(),"Home page is not visible");
		home.isCategoryHeaderDisplayed();
		
		home.clickWomenCategory();
		home.clickWomenDressSubCategory();
		CategoryProductsPage categoryProductsPage = new CategoryProductsPage();
		Assert.assertEquals(categoryProductsPage.getCategoryHeaderWomenDress(), "WOMEN - DRESS PRODUCTS");
		
		categoryProductsPage.clickCategoryMen();
		categoryProductsPage.clickSUbcategoryMenTshirts();
		System.out.println(categoryProductsPage.getCategoryHeaderMenTshirts());
		Assert.assertEquals(categoryProductsPage.getCategoryHeaderMenTshirts(), "MEN - TSHIRTS PRODUCTS");
	}
}
