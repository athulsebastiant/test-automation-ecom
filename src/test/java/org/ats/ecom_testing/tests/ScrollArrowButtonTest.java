package org.ats.ecom_testing.tests;

import org.ats.ecom_testing.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class ScrollArrowButtonTest extends org.ats.ecom_testing.base.BaseTest{
	
	@Test (groups = {"non_critical"})
	@Description("Test to check whether the user can scroll up with the arrow button successfully.")
	@Severity(SeverityLevel.MINOR)
	public void scrollArrowTest() {
		HomePage home = new HomePage();
		Assert.assertTrue(home.isHomePageVisible(),"Home page is not visible");
		home.scrollToBottomOfPage();
		Assert.assertTrue(home.isSubscriptionHeaderVisible(), "Subscription header not visible");
		home.clickScrollUpArrowBtn();
		Assert.assertTrue(home.verifyScrolledUp(), "Scroll arrow button does not scroll up");
	}

}
