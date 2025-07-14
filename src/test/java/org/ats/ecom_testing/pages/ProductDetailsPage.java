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

public class ProductDetailsPage {
	private static final Logger log = LogManager.getLogger(ProductDetailsPage.class);

	WebDriver driver;
	JavascriptExecutor js;
	By productName = By.xpath("//div[@class='product-information']/h2");
	By productCategory = By.xpath("//div[@class='product-information']/p[contains(text(),'Category: ')]");
	By price = By.xpath("//div[@class='product-information']/span/span[contains(text(),'Rs.')]");
	By availability = By.xpath("//div[@class='product-information']/p[b[contains(text(),'Availability:')]]");
	By condition = By.xpath("//div[@class='product-information']/p[b[contains(text(),'Condition:')]]");
	By brand = By.xpath("//div[@class='product-information']/p[b[contains(text(),'Brand:')]]");
	By changeQuantityBox = By.cssSelector("input#quantity");
	By addToCartBtn = By.cssSelector("button.cart");
	By viewCartBtn = By.xpath("//a[u[contains(text(),'View Cart')]]");
	By writeYourReviewHeader = By.xpath("//a[contains(text(),'Write Your Review')]");
	By reviewAcknowledgement = By.xpath("//span[contains(text(),'Thank you for your review.')]");

	By enterName = By.cssSelector("input#name");
	By enterEmail = By.cssSelector("input#email");
	By reviewBox = By.cssSelector("textarea#review");
	By submitReviewBtn = By.cssSelector("button#button-review");

	public ProductDetailsPage() {
		this.driver = DriverFactory.getDriver();
		js = (JavascriptExecutor) driver;
	}

	public boolean isProductNameVisible() {
		log.info("Verifying whether product Name is visible");
		try {
			waitForVisibility(driver, productName, 10);
			boolean visible = driver.findElement(productName).isDisplayed();
			log.info("Product name is visible.");
			return visible;
		} catch (TimeoutException e) {
			log.error("Timeout waiting for product name", e);
		} catch (NoSuchElementException e) {
			log.error("Product name not found", e);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Failed to check product name visibility.", e);

		}
		return false;
	}

	public boolean isProductCategoryVisible() {
		log.info("Verifying whether product category is visible");
		try {
			waitForVisibility(driver, productCategory, 10);
			boolean visible = driver.findElement(productCategory).isDisplayed();
			log.info("Product category is visible.");
			return visible;
		} catch (TimeoutException e) {
			log.error("Timeout waiting for product category", e);
		} catch (NoSuchElementException e) {
			log.error("Product category not found", e);
		} catch (Exception e) {
			log.error("Failed to check product category visibility.", e);

		}
		return false;
	}

	public boolean isProductPriceVisible() {
		log.info("Verifying whether product price is visible");
		try {
			waitForVisibility(driver, price, 10);
			boolean visible = driver.findElement(price).isDisplayed();
			log.info("Product price is visible.");
			return visible;
		} catch (TimeoutException e) {
			log.error("Timeout waiting for product price", e);
		} catch (NoSuchElementException e) {
			log.error("Product price not found", e);
		}

		catch (Exception e) {
			log.error("Failed to check product price visibility.", e);

		}
		return false;
	}

	public boolean isAvailabiltyVisible() {
		log.info("Verifying whether availability info is visible");
		try {
			waitForVisibility(driver, availability, 10);
			boolean visible = driver.findElement(availability).isDisplayed();
			log.info("Availability is visible.");
			return visible;
		} catch (TimeoutException e) {
			log.error("Timeout waiting for availability info", e);
		} catch (NoSuchElementException e) {
			log.error("Availability info not found", e);
		} catch (Exception e) {
			log.error("Failed to check availability visibility", e);
		}
		return false;
	}

	public boolean isConditionVisible() {
		log.info("Verifying whether product condition is visible");
		try {
			waitForVisibility(driver, condition, 10);
			boolean visible = driver.findElement(condition).isDisplayed();
			log.info("Product condition is visible.");
			return visible;
		} catch (TimeoutException e) {
			log.error("Timeout waiting for product condition", e);
		} catch (NoSuchElementException e) {
			log.error("Product condition not found", e);
		} catch (Exception e) {
			log.error("Failed to check product condition visibility", e);
		}
		return false;
	}

	public boolean isBrandVisible() {
		log.info("Verifying whether product brand is visible");
		try {
			waitForVisibility(driver, brand, 10);
			boolean visible = driver.findElement(brand).isDisplayed();
			log.info("Product brand is visible.");
			return visible;
		} catch (TimeoutException e) {
			log.error("Timeout waiting for product brand", e);
		} catch (NoSuchElementException e) {
			log.error("Product brand not found", e);
		} catch (Exception e) {
			log.error("Failed to check product brand visibility", e);
		}
		return false;
	}

	public void ChangeQuantity(int qty) {
		log.info("Changing quantity to: " + qty);
		try {
			waitForVisibility(driver, changeQuantityBox, 10);
			WebElement qtyBox = driver.findElement(changeQuantityBox);
			qtyBox.clear();
			qtyBox.sendKeys(String.valueOf(qty));
			log.info("Quantity successfully updated.");
		} catch (TimeoutException e) {
			log.error("Timeout waiting for quantity input box", e);
		} catch (NoSuchElementException e) {
			log.error("Quantity input box not found", e);
		} catch (Exception e) {
			log.error("Failed to change quantity", e);
		}
	}

	public void clickAddToCart() {
		log.info("Clicking on 'Add to Cart' button");
		try {
			driver.findElement(addToCartBtn).click();
			log.info("'Add to Cart' clicked successfully.");
		} catch (NoSuchElementException e) {
			log.error("'Add to Cart' button not found", e);
		} catch (Exception e) {
			log.error("Failed to click 'Add to Cart'", e);
		}
	}

	public void clickViewCart() {
		log.info("Clicking on 'View Cart' button");
		try {
			waitToBeClickable(driver, viewCartBtn, 10);
			driver.findElement(viewCartBtn).click();
			log.info("'View Cart' clicked successfully.");
		} catch (TimeoutException e) {
			log.error("Timeout waiting for 'View Cart' button", e);
		} catch (NoSuchElementException e) {
			log.error("'View Cart' button not found", e);
		} catch (Exception e) {
			log.error("Failed to click 'View Cart'", e);
		}
	}

	public boolean isWriteYourReviewDisplayed() {
		log.info("Checking if 'Write Your Review' section is displayed");
		try {
			waitForVisibility(driver, writeYourReviewHeader, 10);
			boolean visible = driver.findElement(writeYourReviewHeader).isDisplayed();
			log.info("'Write Your Review' section is visible.");
			return visible;
		} catch (TimeoutException e) {
			log.error("Timeout waiting for 'Write Your Review' section", e);
		} catch (NoSuchElementException e) {
			log.error("'Write Your Review' section not found", e);
		} catch (Exception e) {
			log.error("Failed to check review section visibility", e);
		}
		return false;
	}

	public void enterName(String name) {
		log.info("Entering name: " + name);
		try {
			WebElement nameField = driver.findElement(enterName);
			js.executeScript("arguments[0].scrollIntoView();", nameField);
			nameField.sendKeys(name);
			log.info("Name entered successfully.");
		} catch (NoSuchElementException e) {
			log.error("Name field not found", e);
		} catch (Exception e) {
			log.error("Failed to enter name", e);
		}
	}

	public void enterEmail(String email) {
		log.info("Entering email: " + email);
		try {
			WebElement emailField = driver.findElement(enterEmail);
			js.executeScript("arguments[0].scrollIntoView();", emailField);
			emailField.sendKeys(email);
			log.info("Email entered successfully.");
		} catch (NoSuchElementException e) {
			log.error("Email field not found", e);
		} catch (Exception e) {
			log.error("Failed to enter email", e);
		}
	}

	public void enterReview(String review) {
		log.info("Entering review: " + review);
		try {
			WebElement reviewField = driver.findElement(reviewBox);
			js.executeScript("arguments[0].scrollIntoView();", reviewField);
			reviewField.sendKeys(review);
			log.info("Review entered successfully.");
		} catch (NoSuchElementException e) {
			log.error("Review box not found", e);
		} catch (Exception e) {
			log.error("Failed to enter review", e);
		}
	}

	public void submitReview() {
		log.info("Submitting review");
		try {
			WebElement submitBtn = driver.findElement(submitReviewBtn);
			js.executeScript("arguments[0].scrollIntoView();", submitBtn);
			submitBtn.click();
			log.info("Review submitted successfully.");
		} catch (NoSuchElementException e) {
			log.error("Submit button not found", e);
		} catch (Exception e) {
			log.error("Failed to submit review", e);
		}
	}

	public boolean isReviewAcknowledged() {
		log.info("Checking for review acknowledgement");
		try {
			waitForVisibility(driver, reviewAcknowledgement, 10);
			boolean visible = driver.findElement(reviewAcknowledgement).isDisplayed();
			log.info("Review acknowledgement is visible.");
			return visible;
		} catch (TimeoutException e) {
			log.error("Timeout waiting for review acknowledgement", e);
		} catch (NoSuchElementException e) {
			log.error("Review acknowledgement not found", e);
		} catch (Exception e) {
			log.error("Failed to check review acknowledgement", e);
		}
		return false;
	}

}
