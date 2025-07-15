package org.ats.ecom_testing.utils;

import org.ats.ecom_testing.pages.SignupLoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginUtil {
	final public static String email = "asas1@mail.com";
	final public static String password = "1234567";
	final public static String name = "qwqw";
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
	public static void login(WebDriver driver) {
		SignupLoginPage signupPage = new SignupLoginPage();
		Assert.assertTrue(signupPage.isLoginHeaderVisible(), "Login header isn't visible");
		signupPage.enterLoginEmail(email);
		signupPage.enterLoginPassword(password);
		signupPage.clickLoginBtn();
	}
}
