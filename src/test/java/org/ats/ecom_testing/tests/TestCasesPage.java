package org.ats.ecom_testing.tests;

import org.ats.ecom_testing.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;



public class TestCasesPage extends org.ats.ecom_testing.base.BaseTest {
	@Test
	@Description("Test to check whether the user can successfully navigate to the test cases page successfully.")
	@Severity(SeverityLevel.MINOR)
	public void testCasesTest() {
		HomePage home = new HomePage();
		Assert.assertTrue(home.isHomePageVisible(),"Home page is not visible");
		home.clickTestCasesBtn();
		Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/test_cases");
	}
}
