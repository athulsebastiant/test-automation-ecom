package org.ats.ecom_testing.tests;


import org.ats.ecom_testing.pages.HomePage;

import org.ats.ecom_testing.utils.DeleteAccountUtil;
import org.ats.ecom_testing.utils.SignupUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class RegisterUserTest extends org.ats.ecom_testing.base.BaseTest {
	
	@Test (groups= {"smoke","account"})
	@Description("Test to check whether the user can register with the website successfully.")
	@Severity(SeverityLevel.CRITICAL)
	public void registerNewUserTest() {
	
		HomePage home = new HomePage();
		Assert.assertTrue(home.isHomePageVisible(),"Home page is not visible");
		
		home.clickSignupLoginBtn();
		SignupUtil.signup(driver);
		Assert.assertTrue(home.isLoggedInUserNameVisible(), "Logged in Username not visible");

		home.clickDeleteAccountBtn();
		DeleteAccountUtil.deleteAccount(driver);
		
	}
}
