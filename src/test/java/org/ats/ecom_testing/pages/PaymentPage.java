package org.ats.ecom_testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.ats.ecom_testing.utils.WaitUtils.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ats.ecom_testing.utils.DriverFactory;
public class PaymentPage {
	private static final Logger log = LogManager.getLogger(PaymentPage.class);
	WebDriver driver;
	JavascriptExecutor js;
	By nameOnCard = By.xpath("//input[@name='name_on_card']");
	By cardNumber = By.xpath("//input[@name='card_number']");
	By cvc = By.xpath("//input[@name='cvc']");
	By expMonth = By.xpath("//input[@name='expiry_month']");
	By expYear = By.xpath("//input[@name='expiry_year']");
	By payAndConfirmBtn = By.cssSelector("button#submit");
	By successpaymentMsg = By.xpath("//div[contains(text(),'Your order has been placed successfully!')]");
	public PaymentPage() {
		this.driver = DriverFactory.getDriver();
		this.js = (JavascriptExecutor)driver;
	}
	
	public void fillNameOnCard(String name) {
		log.info("Filling name on card: {}", name);
		try {
            WebElement elem = driver.findElement(nameOnCard);
            elem.sendKeys(name);
            log.info("Name on card entered");
        } catch (NoSuchElementException e) {
            log.error("Name on card input not found", e);
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error filling name on card", e);
            throw e;
        }
	}
	
	public void fillCardNumber(String no) {
		log.info("Filling card number: {}", no);
        try {
            WebElement elem = driver.findElement(cardNumber);
            elem.sendKeys(no);
            log.info("Card number entered");
        } catch (NoSuchElementException e) {
            log.error("Card number input not found", e);
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error filling card number", e);
            throw e;
        }
	}
	
	public void fillcvc(int cvcN) {
		log.info("Filling CVC: {}", cvcN);
        try {
            WebElement elem = driver.findElement(cvc);
            elem.sendKeys(String.valueOf(cvcN));
            log.info("CVC entered");
        } catch (NoSuchElementException e) {
            log.error("CVC input not found", e);
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error filling CVC", e);
            throw e;
        }
	}
	
	public void fillExpMonth(int m) {
		log.info("Filling expiry month: {}", m);
        try {
            WebElement elem = driver.findElement(expMonth);
            elem.sendKeys(String.valueOf(m));
            log.info("Expiry month entered");
        } catch (NoSuchElementException e) {
            log.error("Expiry month input not found", e);
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error filling expiry month", e);
            throw e;
        }
	}
	
	public void fillExpYear(int y) {
		log.info("Filling expiry year: {}", y);
        try {
            WebElement elem = driver.findElement(expYear);
            elem.sendKeys(String.valueOf(y));
            log.info("Expiry year entered");
        } catch (NoSuchElementException e) {
            log.error("Expiry year input not found", e);
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error filling expiry year", e);
            throw e;
        }
	}
	
	public void clickPayandConfirmBtn() {
		log.info("Clicking 'Pay and Confirm' button");
        try {
            WebElement btn = driver.findElement(payAndConfirmBtn);
            js.executeScript("arguments[0].scrollIntoView(true);", btn);
            btn.click();
            log.info("'Pay and Confirm' clicked");
        } catch (NoSuchElementException e) {
            log.error("Pay and Confirm button not found", e);
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error clicking Pay and Confirm", e);
            throw e;
        }
	}
	
	public boolean isPaymentSuccessMessageDisplayed() {
		log.info("Verifying payment success message");
        try {
            waitForVisibility(driver, successpaymentMsg, 10);
            boolean visible = driver.findElement(successpaymentMsg).isDisplayed();
            log.info("Payment success message displayed: {}", visible);
            return visible;
        } catch (TimeoutException e) {
            log.error("Timeout waiting for payment success message", e);
        } catch (NoSuchElementException e) {
            log.error("Payment success message not found", e);
        } catch (Exception e) {
            log.error("Unexpected error verifying payment success message", e);
        }
        return false;
    }
}
