package org.ats.ecom_testing.tests;


import org.ats.ecom_testing.pages.HomePage;

import org.ats.ecom_testing.utils.LoginUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;



public class LoginWithCorrectCreds extends org.ats.ecom_testing.base.BaseTest {
	@Test (groups = {"smoke","account"})
	@Description("Test for checking whether user can login with the correct credentials.")
	@Severity(SeverityLevel.CRITICAL)
	public void loginWithCorrectCredentials() {
		HomePage home = new HomePage();
		Assert.assertTrue(home.isHomePageVisible(),"Home page is not visible");
		
		home.clickSignupLoginBtn();
		LoginUtil.login(driver);
		Assert.assertTrue(home.isLoggedInUserNameVisible(), "Logged in Username not visible");

	}
}
