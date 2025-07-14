package org.ats.ecom_testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import static org.ats.ecom_testing.utils.WaitUtils.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ats.ecom_testing.utils.DriverFactory;

public class DeletedAccountPage {
	private static final Logger log = LogManager.getLogger(DeletedAccountPage.class);

	WebDriver driver;
	By accountDeletedHeader = By.xpath("//h2/b[contains(text(),'Account Deleted!')]");
	By continueBtn = By.xpath("//a[contains(text(),'Continue')]");

	public DeletedAccountPage() {
		// TODO Auto-generated constructor stub
		this.driver = DriverFactory.getDriver();
	}

	public boolean isAccountDeletedHeaderVisible() {
		log.info("Checking visibility of 'Account Deleted!' header");
		try {
			waitForVisibility(driver, accountDeletedHeader, 10);
			boolean visible = driver.findElement(accountDeletedHeader).isDisplayed();
			log.info("'Account Deleted!' header visible: {}", visible);
			return visible;
		} catch (TimeoutException e) {
			log.error("Timeout waiting for 'Account Deleted!' header", e);
		} catch (NoSuchElementException e) {
			log.error("'Account Deleted!' header element not found", e);
		} catch (Exception e) {
			log.error("Unexpected error checking 'Account Deleted!' header", e);
		}
		return false;
	}

	public void clickContinueBtn() {
		log.info("Clicking 'Continue' button on Deleted Account page");
		try {
			waitForVisibility(driver, continueBtn, 10);
			driver.findElement(continueBtn).click();
			log.info("'Continue' button clicked successfully");
		} catch (TimeoutException e) {
			log.error("Timeout waiting for 'Continue' button", e);
			throw e;
		} catch (NoSuchElementException e) {
			log.error("'Continue' button not found", e);
			throw e;
		} catch (Exception e) {
			log.error("Unexpected error clicking 'Continue' button", e);
			throw e;
		}
	}

}
