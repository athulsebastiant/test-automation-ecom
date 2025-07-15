package org.ats.ecom_testing.tests;

import org.ats.ecom_testing.pages.HomePage;
import org.ats.ecom_testing.pages.SignupLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;



public class LoginWithIncorrectCreds extends org.ats.ecom_testing.base.BaseTest {
	@Test (groups = {"smoke","account"})
	@Description("Test for checking whether user can login with the incorrect credentials or not.")
	@Severity(SeverityLevel.CRITICAL)
	public void loginWithIncorrectCredentials() {
		HomePage home = new HomePage();
		Assert.assertTrue(home.isHomePageVisible(),"Home page is not visible");
		
		home.clickSignupLoginBtn();
		SignupLoginPage signupPage = new SignupLoginPage();
		Assert.assertTrue(signupPage.isLoginHeaderVisible(), "Login header isn't visible");
		signupPage.enterLoginEmail("wrong@mail.com");
		signupPage.enterLoginPassword("wrongPass");
		signupPage.clickLoginBtn();
		Assert.assertTrue(signupPage.isIncorrectCredWarningIsVisible(),"Incorrect email password warning not shown");
		
	}
}
