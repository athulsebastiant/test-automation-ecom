package org.ats.ecom_testing.tests;

import org.ats.ecom_testing.pages.HomePage;
import org.ats.ecom_testing.pages.SignupLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;



public class LogoutSuccessTest extends org.ats.ecom_testing.base.BaseTest {
	@Test (groups = {"smoke","account"})
	@Description("Test to check whether the user can logout from thw website successfully.")
	@Severity(SeverityLevel.CRITICAL)
	public void logoutSuccessfully() {
		HomePage home = new HomePage();
		Assert.assertTrue(home.isHomePageVisible(), "Home page is not visible");
		home.clickSignupLoginBtn();
		SignupLoginPage signupPage = new SignupLoginPage();
		Assert.assertTrue(signupPage.isLoginHeaderVisible(), "Login header isn't visible");
		signupPage.enterLoginEmail("asas1@mail.com");
		signupPage.enterLoginPassword("1234567");
		signupPage.clickLoginBtn();
		Assert.assertTrue(home.isLoggedInUserNameVisible(), "Logged in Username not visible");
		home.clickLogoutBtn();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login");
		
	}
	
}
