package org.ats.ecom_testing.pages;

import static org.ats.ecom_testing.utils.WaitUtils.*;

import java.time.Duration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ats.ecom_testing.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	private static final Logger log = LogManager.getLogger(CartPage.class);
	WebDriver driver;
	JavascriptExecutor js;
	By subscriptionBox = By.cssSelector("input#susbscribe_email");
	By subBtn = By.cssSelector("button#subscribe");
	By succesfulSub = By.xpath("//div[@id='success-subscribe']/div");
	By proceedToCheckoutBtn = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
	By registerLoginBtn = By.xpath("//a[u[contains(text(),'Register / Login')]]");
	By signupLogin = By.xpath("//a[contains(text(), 'Signup / Login')]");

	public CartPage() {
		this.driver = DriverFactory.getDriver();
		this.js = (JavascriptExecutor) driver;
	}

	public void subscribe(String email) {
		log.info("Subscribing with email '{}'", email);
		try {
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(subscriptionBox));
			driver.findElement(subscriptionBox).sendKeys(email);
			driver.findElement(subBtn).click();
			log.info("Subscribe button clicked");
		} catch (TimeoutException e) {
			log.error("Timeout during subscription flow", e);
			throw e;
		} catch (NoSuchElementException e) {
			log.error("Subscription elements not found", e);
			throw e;
		} catch (Exception e) {
			log.error("Unexpected error in subscribe()", e);
			throw e;
		}
	}

	public boolean subConfirmation() {
		log.info("Checking subscription confirmation message");
		try {
			waitForVisibility(driver, succesfulSub, 10);
			boolean visible = driver.findElement(succesfulSub).isDisplayed();
			log.info("Subscription confirmation visible: {}", visible);
			return visible;
		} catch (TimeoutException e) {
			log.error("Timeout waiting for subscription confirmation", e);
		} catch (NoSuchElementException e) {
			log.error("Subscription confirmation element not found", e);
		} catch (Exception e) {
			log.error("Unexpected error in subConfirmation()", e);
		}
		return false;

	}

	public Set<String> getAllProductsinCart() {
		log.info("Retrieving all product names from cart");
		try {
			Set<String> productNames = new HashSet<>();
			List<WebElement> nameElements = driver.findElements(By.xpath("//table/tbody/tr/td[2]/h4/a"));
			for (WebElement element : nameElements) {
				productNames.add(element.getText().trim());
			}

			log.info("Found {} products in cart", productNames.size());
			return productNames;
		} catch (Exception e) {
			log.error("Error retrieving products in cart", e);
			return new HashSet<>();
		}
	}

	public String getProductNameAtIndex(int index) {
		log.info("Getting product name at index {}", index);
		try {
			String xpath = "//table/tbody/tr[" + index + "]/td[2]/h4/a";
			String name = driver.findElement(By.xpath(xpath)).getText().trim();
			log.info("Product at index {}: '{}'", index, name);
			return name;
		} catch (Exception e) {
			log.error("Error getting product name at index " + index, e);
			return "";
		}
	}

	public int getQuantity(int productIndex) {
		log.info("Getting quantity for product at index {}", productIndex);
		try {
			By qtyLocator = By.xpath("//table/tbody/tr[" + productIndex + "]/td[4]");
			waitForVisibility(driver, qtyLocator, 10);
			String qtyText = driver.findElement(qtyLocator).getText();
			int qty = Integer.parseInt(qtyText);
			log.info("Quantity at index {}: {}", productIndex, qty);
			return qty;
		} catch (TimeoutException e) {
			log.error("Timeout getting quantity at index {}", productIndex, e);
		} catch (NoSuchElementException e) {
			log.error("Quantity element not found at index {}", productIndex, e);
		} catch (NumberFormatException e) {
			log.error("Invalid number format for quantity at index {}", productIndex, e);
		} catch (Exception e) {
			log.error("Unexpected error in getQuantity()", e);
		}
		return 0;
	}

	public void clickProceedToCheckoutBtn() {
		log.info("Clicking 'Proceed To Checkout' button");
		try {

			waitToBeClickable(driver, proceedToCheckoutBtn, 10);
			driver.findElement(proceedToCheckoutBtn).click();
			log.info("'Proceed To Checkout' clicked");
		} catch (Exception e) {
			log.error("Error clicking 'Proceed To Checkout'", e);
			throw e;
		}
	}

	public void clickRegisterLoginBtn() {
		log.info("Clicking 'Register / Login' button");
		try {
			waitToBeClickable(driver, registerLoginBtn, 10);
			driver.findElement(registerLoginBtn).click();
			log.info("'Register / Login' clicked");
		} catch (Exception e) {
			log.error("Error clicking Register/Login", e);
			throw e;
		}
	}

	public void clickRemoveProduct(int productIndex) {
		log.info("Removing product at index {}", productIndex);
		try {

			By removeProductBtn = By.xpath("//table/tbody/tr[" + productIndex + "]/td[6]/a");
			driver.findElement(removeProductBtn).click();
			log.info("Remove clicked for product index {}", productIndex);
		} catch (Exception e) {
			log.error("Error clicking remove for index " + productIndex, e);
			throw e;
		}
	}

	public void waitUntilProductRemoved(String productName) {
		log.info("Waiting until product '{}' is removed", productName);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(d -> !getAllProductsinCart().contains(productName));
			log.info("Product '{}' removed from cart", productName);
		} catch (Exception e) {
			log.error("Error waiting for product '{}' removal", productName, e);
			throw e;
		}
	}

	public void clickSignupLogin() {
		log.info("Clicking 'Signup / Login' link");
		try {
			driver.findElement(signupLogin).click();
			log.info("'Signup / Login' clicked");
		} catch (Exception e) {
			log.error("Error clicking Signup/Login", e);
			throw e;
		}
	}

}
