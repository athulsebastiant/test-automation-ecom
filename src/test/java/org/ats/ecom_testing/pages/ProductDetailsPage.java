package org.ats.ecom_testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.ats.ecom_testing.utils.WaitUtils.*;

import org.ats.ecom_testing.utils.DriverFactory;
public class ProductDetailsPage {
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
		js = (JavascriptExecutor)driver;
	}
	
	public boolean isProductNameVisible() {
		waitForVisibility(driver, productName, 10);
		return driver.findElement(productName).isDisplayed();
	}
	
	public boolean isProductCategoryVisible() {
		waitForVisibility(driver, productCategory, 10);
		return driver.findElement(productCategory).isDisplayed();
	}
	
	public boolean isProductPriceVisible() {
		waitForVisibility(driver, price, 10);
		return driver.findElement(price).isDisplayed();
	}
	
	public boolean isAvailabiltyVisible() {
		waitForVisibility(driver, availability, 10);
		return driver.findElement(availability).isDisplayed();
	}
	
	public boolean isConditionVisible() {
		waitForVisibility(driver, condition, 10);
		return driver.findElement(condition).isDisplayed();
	}
	
	public boolean isBrandVisible() {
		waitForVisibility(driver, brand, 10);
		return driver.findElement(brand).isDisplayed();
	}
	
	public void ChangeQuantity(int qty) {
		waitForVisibility(driver, changeQuantityBox, 10);
		WebElement qtyBox = driver.findElement(changeQuantityBox);
		qtyBox.clear();
		qtyBox.sendKeys(String.valueOf(qty));
	}
	
	public void clickAddToCart() {
		driver.findElement(addToCartBtn).click();
	}
	
	public void clickViewCart() {
		waitToBeClickable(driver, viewCartBtn, 10);
		driver.findElement(viewCartBtn).click();
	}
	
	public boolean isWriteYourReviewDisplayed() {
		waitForVisibility(driver, writeYourReviewHeader, 10);
		return driver.findElement(writeYourReviewHeader).isDisplayed();
	}
	
	public void enterName(String name) {
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(enterName));
		driver.findElement(enterName).sendKeys(name);
	}
	
	public void enterEmail(String email) {
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(enterEmail));
		driver.findElement(enterEmail).sendKeys(email);
	}
	
	public void enterReview(String review) {
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(reviewBox));
		driver.findElement(reviewBox).sendKeys(review);
	}
	
	public void submitReview() {
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(submitReviewBtn));
		driver.findElement(submitReviewBtn).click();
	}
	
	public boolean isReviewAcknowledged() {
		waitForVisibility(driver, reviewAcknowledgement, 10);
		return driver.findElement(reviewAcknowledgement).isDisplayed();
	}
	
}
