package org.ats.ecom_testing.utils;

import org.ats.ecom_testing.pages.AccountCreatedPage;
import org.ats.ecom_testing.pages.SignupDataEntryPage;
import org.ats.ecom_testing.pages.SignupLoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignupUtil {
	final public static String title = "Mr."; 
	final public static String fName = "TestMan";
	final public static String LName =  "ManTest";
	final public static String add1= "Sample Address 1";
	final public static String add2 = "Sample Address 2";
	final public static String country = "India";
	final public static String state = "Kerala";
	final public static String city = "Thodupuzha";
	final public static String zip = "685587";
	final public static String mob = "1234567891";
	public static void signup(WebDriver driver) {
		SignupLoginPage signupLoginPage = new SignupLoginPage();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login");
		signupLoginPage.enterName("TestMan");
		signupLoginPage.enterSignupEmail("testuser"+System.currentTimeMillis()+"@mail.com");
		signupLoginPage.clickSignupBtn();
		SignupDataEntryPage signUpData = new SignupDataEntryPage();
		Assert.assertTrue(signUpData.isEnterAccountInfoVisible());
		signUpData.selectTitleMr();
		signUpData.typePswd("testPass123");
		signUpData.chooseDay("5");
		signUpData.chooseMonth("June");
		signUpData.chooseYear("2002");
		signUpData.optNewsLetter(true);
		signUpData.optSpOffer(true);
		signUpData.typeFirstname(fName);
		signUpData.typeLastname(LName);
		signUpData.typeAddress1(add1);
		signUpData.typeAddress2(add2);
		signUpData.chooseCountry(country);
		signUpData.typeState(state);
		signUpData.typeCity(city);
		signUpData.typeZip(zip);
		signUpData.typeMob(mob);
		signUpData.clickCreateAccount();
		
		
		AccountCreatedPage accountCreatedPage = new AccountCreatedPage();
		Assert.assertTrue(accountCreatedPage.isAccountCreatedHeaderVisible(),"Account Created Header not found"); 
		accountCreatedPage.clickContinueBtn();
	}
}
