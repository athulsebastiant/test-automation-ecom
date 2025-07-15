package org.ats.ecom_testing.tests;

import org.ats.ecom_testing.pages.HomePage;
import org.ats.ecom_testing.pages.SignupLoginPage;
import org.ats.ecom_testing.utils.LoginUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class RegisterUserWithExistingEmail extends org.ats.ecom_testing.base.BaseTest {
	@Test (groups = {"account"})
	@Description("Test to check whether the user can register with an already existing email id, successfully.")
	@Severity(SeverityLevel.NORMAL)
	public void registerUserWithExistingEmail() {
		HomePage home = new HomePage();
		Assert.assertTrue(home.isHomePageVisible(),"Home page is not visible");
		
		home.clickSignupLoginBtn();
		SignupLoginPage signupPage = new SignupLoginPage();
		Assert.assertTrue(signupPage.isNewUserSignupVisible(),"New User Signup Header is not visible");
		signupPage.enterName(LoginUtil.name);
		signupPage.enterSignupEmail(LoginUtil.email);
		signupPage.clickSignupBtn();
		Assert.assertTrue(signupPage.isExistingEmailWarningIsVisible(), "Email address exists warning not shown");
		
	}
}
