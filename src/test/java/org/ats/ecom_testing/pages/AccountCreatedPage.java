package org.ats.ecom_testing.pages;
import static org.ats.ecom_testing.utils.WaitUtils.*;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ats.ecom_testing.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage {
	private static final Logger log = LogManager.getLogger(AccountCreatedPage.class);
	WebDriver driver;
	By accountCreatedHeader = By.xpath("//h2/b[contains(text(),'Account Created!')]");
	By continueBtn = By.cssSelector("a.btn.btn-primary");

	public AccountCreatedPage() {
		this.driver = DriverFactory.getDriver();
	}
	
	
	
	public boolean isAccountCreatedHeaderVisible() {
		log.info("Checking if 'Account Created' header is visible");
		try {
			waitForVisibility(driver,accountCreatedHeader,10);
			boolean visible = driver.findElement(accountCreatedHeader).isDisplayed();
			log.info("'Account Created' header visible: {}",visible);
			return visible;
		} catch (TimeoutException e) {
			// TODO: handle exception
			log.error("Timeout waiting for 'Account Created' header",e);
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			log.error("'Account Created' header element not found", e);
		}catch (Exception e) {
            log.error("Unexpected error while checking header visibility", e);
        }
		
		return false;
	}

	public void clickContinueBtn() {
		log.info("Attempting to click 'Continue' button");
		try {
			waitToBeClickable(driver, continueBtn, 10);
			driver.findElement(continueBtn).click();
			log.info("'Continue' button clicked successfully");
		} catch (TimeoutException e) {
			// TODO: handle exception
			log.error("Selenium timeout waiting for 'Continue' button", e);
            throw e;
		}catch (NoSuchElementException e) {
            log.error("'Continue' button element not found in DOM", e);
            throw e;
        } 
        catch (Exception e) {
            log.error("Unexpected error while clicking 'Continue' button", e);
            throw e;
        }
		
	}
}
