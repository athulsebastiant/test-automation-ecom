package org.ats.ecom_testing.tests;

import org.ats.ecom_testing.pages.ContactUsPage;
import org.ats.ecom_testing.pages.HomePage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class ContactFormTest extends org.ats.ecom_testing.base.BaseTest {
	@Test (groups = {"non_critical"})
	@Description("Test to check whether the contact us form works correctly.")
	@Severity(SeverityLevel.MINOR)
	public void contactFormTest() {
		HomePage home = new HomePage();
		Assert.assertTrue(home.isHomePageVisible(),"Home page is not visible");
		
		home.clickContactUsBtn();
		ContactUsPage contactUs = new ContactUsPage();
		Assert.assertTrue(contactUs.isGetInTouchHeaderVisible(), "get In touch message not visible");
		contactUs.enterName("testMan");
		contactUs.enterEmail("test@mail.com");
		contactUs.enterSubject("Test Subject");
		contactUs.enterMessage("Test message");
		contactUs.uploadFile("src/test/java/org/ats/ecom_testing/resources/SampleFile.txt");
		contactUs.clickSubmitBtn();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		contactUs.isSuccessMsgVisible();
		contactUs.clickHomeBtn();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");
		
	}
}
