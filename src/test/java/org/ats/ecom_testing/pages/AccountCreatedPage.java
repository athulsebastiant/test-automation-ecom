package org.ats.ecom_testing.pages;
import static org.ats.ecom_testing.utils.WaitUtils.*;

import org.ats.ecom_testing.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage {
	WebDriver driver;
	By accountCreatedHeader = By.xpath("//h2/b[contains(text(),'Account Created!')]");
	By continueBtn = By.cssSelector("a.btn.btn-primary");

	public AccountCreatedPage() {
		this.driver = DriverFactory.getDriver();
	}
	
	
	
	public boolean isAccountCreatedHeaderVisible() {
		waitForVisibility(driver,accountCreatedHeader,10);
		return driver.findElement(accountCreatedHeader).isDisplayed();
	}

	public void clickContinueBtn() {
		driver.findElement(continueBtn).click();
	}
}
