package org.ats.ecom_testing.tests;

import org.ats.ecom_testing.pages.AccountCreatedPage;
import org.ats.ecom_testing.pages.DeletedAccountPage;
import org.ats.ecom_testing.pages.HomePage;
import org.ats.ecom_testing.pages.SignupDataEntryPage;
import org.ats.ecom_testing.pages.SignupLoginPage;
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
		System.out.println("Working dir: " + System.getProperty("user.dir"));
		HomePage home = new HomePage();
		Assert.assertTrue(home.isHomePageVisible(),"Home page is not visible");
		home.clickSignupLoginBtn();
		
		SignupLoginPage signupPage = new SignupLoginPage();
		Assert.assertTrue(signupPage.isNewUserSignupVisible(),"New User Signup Header is not visible");
		signupPage.enterName("TestUser");
		signupPage.enterSignupEmail("testuser"+System.currentTimeMillis()+"@mail.com");
		signupPage.clickSignupBtn();
		SignupDataEntryPage signUpData = new SignupDataEntryPage();
		Assert.assertTrue(signUpData.isEnterAccountInfoVisible());
		signUpData.selectTitleMr();
		signUpData.typePswd("testPass123");
		signUpData.chooseDay("5");
		signUpData.chooseMonth("June");
		signUpData.chooseYear("2002");
		signUpData.optNewsLetter(true);
		signUpData.optSpOffer(true);
		signUpData.typeFirstname("TestMan");
		signUpData.typeLastname("ManTest");
		signUpData.typeAddress1("Sample Address 1");
		signUpData.typeAddress2("Sample Address 2");
		signUpData.chooseCountry("India");
		signUpData.typeState("Kerala");
		signUpData.typeCity("Thodupuzha");
		signUpData.typeZip("685587");
		signUpData.typeMob("1234567891");
		signUpData.clickCreateAccount();
		
		AccountCreatedPage accountCreatedPage = new AccountCreatedPage();
		Assert.assertTrue(accountCreatedPage.isAccountCreatedHeaderVisible(),"Account Created Header not found"); 
		accountCreatedPage.clickContinueBtn();
		
		Assert.assertTrue(home.isLoggedInUserNameVisible(), "Logged in Username not visible");
		home.clickDeleteAccountBtn();
		
		DeletedAccountPage deletedAccountPage = new DeletedAccountPage();
		Assert.assertTrue(deletedAccountPage.isAccountDeletedHeaderVisible(),"Account Deleted Header not visble");
		deletedAccountPage.clickContinueBtn();
		
	}
}
