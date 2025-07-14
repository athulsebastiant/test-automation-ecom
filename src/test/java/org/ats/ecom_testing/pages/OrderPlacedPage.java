package org.ats.ecom_testing.pages;
import static org.ats.ecom_testing.utils.WaitUtils.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ats.ecom_testing.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
public class OrderPlacedPage {
	private static final Logger log = LogManager.getLogger(OrderPlacedPage.class);
	WebDriver driver;
	By orderPlacedHeader = By.xpath("//h2[b[contains(text(),'Order Placed!')]]");
	By continueBtn = By.xpath("//a[contains(text(),'Continue')]");
	By downloadBtn = By.xpath("//a[contains(text(),'Download Invoice')]");
	public OrderPlacedPage() {
		this.driver = DriverFactory.getDriver();
	}
	
	public boolean isOrderPlaceHeaderDisplyed() {
		log.info("Checking if 'Order Placed!' header is displayed");
		 try {
	            waitForVisibility(driver, orderPlacedHeader, 10);
	            boolean visible = driver.findElement(orderPlacedHeader).isDisplayed();
	            log.info("'Order Placed!' header displayed: {}", visible);
	            return visible;
	        } catch (TimeoutException e) {
	            log.error("Timeout waiting for 'Order Placed!' header", e);
	        } catch (NoSuchElementException e) {
	            log.error("'Order Placed!' header element not found", e);
	        } catch (Exception e) {
	            log.error("Unexpected error checking order placed header", e);
	        }
	        return false;
	}
	
	public void clickContinueBtn() {
		log.info("Clicking 'Continue' button on Order Placed page");
        try {
            waitForVisibility(driver, continueBtn, 10);
            driver.findElement(continueBtn).click();
            log.info("'Continue' button clicked successfully");
        } catch (TimeoutException e) {
            log.error("Timeout waiting for 'Continue' button", e);
            throw e;
        } catch (NoSuchElementException e) {
            log.error("'Continue' button element not found", e);
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error clicking 'Continue' button", e);
            throw e;
        }
	}
	
	public void clickDownloadBtn() {
		log.info("Clicking 'Download Invoice' button");
        try {
            waitForVisibility(driver, downloadBtn, 10);
            driver.findElement(downloadBtn).click();
            log.info("'Download Invoice' button clicked successfully");
        } catch (TimeoutException e) {
            log.error("Timeout waiting for 'Download Invoice' button", e);
            throw e;
        } catch (NoSuchElementException e) {
            log.error("'Download Invoice' button element not found", e);
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error clicking 'Download Invoice' button", e);
            throw e;
        }
	}
}
