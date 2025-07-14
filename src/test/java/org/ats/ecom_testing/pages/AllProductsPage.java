package org.ats.ecom_testing.pages;
import static org.ats.ecom_testing.utils.WaitUtils.*;

import org.ats.ecom_testing.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.List;

public class AllProductsPage {
	WebDriver driver;
	JavascriptExecutor js;
	Actions actions;
	By allProductsHeader = By.xpath("//h2[contains(text(),'All Products')]");
	By productList = By.xpath("//div[@class='features_items']");
	By viewProductOfFirst = By.xpath("(//a[contains(text(), 'View Product')])[1]");
	By searchBox = By.xpath("//input[@name='search']");
	By searchBtn = By.xpath("//button[@id='submit_search']");
	By searchedProductsHeader = By.xpath("//h2[contains(text(),'Searched Products')]");
	By firstProduct = By.xpath("(//div[@class='productinfo text-center'])[1]");
	By allProductsDisplayed = By.xpath("//div[@class='product-image-wrapper']");
	// By addToCartBtn =
	// By.xpath("(//div[@class='product-overlay'])[1]/div/a[contains(text(),'Add to
	// cart')]");
	By continueShoppingBtn = By.xpath("//button[contains(text(),'Continue Shopping')]");
	By viewCartBtn = By.xpath("//a/u[contains(text(),'View Cart')]");

	By brandsHeader = By.xpath("//h2[contains(text(),'Brands')]");
	
	By brandsLinks = By.cssSelector("div.brands-name");
	
	By brandPoloLink = By.xpath("//div[@class='brands-name']//li/a[contains(., 'Polo')]");
	
	public AllProductsPage() {
		// TODO Auto-generated constructor stub
		this.driver = DriverFactory.getDriver();
		this.js = (JavascriptExecutor) driver;
		this.actions = new Actions(driver);
	}

	public boolean isAllProductsHeaderVisible() {
		waitForVisibility(driver, allProductsHeader, 10);
		return driver.findElement(allProductsHeader).isDisplayed();
	}

	public boolean isAllProductsListVisible() {
		waitForVisibility(driver, productList, 10);
		return driver.findElement(productList).isDisplayed();
	}

	public void clickFirstProductView() {
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(viewProductOfFirst));
		driver.findElement(viewProductOfFirst).click();
	}

	public void search(String text) {
		driver.findElement(searchBox).sendKeys(text);
		driver.findElement(searchBtn).click();
	}

	public boolean isSearchedProductsHeadervisible() {
		waitForVisibility(driver, searchedProductsHeader, 10);
		return driver.findElement(searchedProductsHeader).isDisplayed();
	}

	public boolean areAllSearchedProductsRelevant(String keyword) {
		String normalizedKeyword = keyword.toLowerCase().replaceAll("[-\\s]", "");
		List<WebElement> productNames = driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"));
		for (WebElement product : productNames) {
			String normalizedName = product.getText().toLowerCase().replaceAll("[-\\s]", "");

			if (!normalizedName.contains(normalizedKeyword.toLowerCase())) {
				System.out.println("Irrelevant product found: " + normalizedName);
				return false;
			}
		}
		return true;
	}

	public String clickAddToCart(int productIndex) {
	//	(//div[@class='product-image-wrapper'])[1]//p
		WebElement productWrapper = driver
				.findElement(By.xpath("(//div[@class='product-image-wrapper'])[" + productIndex + "]"));
		js.executeScript("arguments[0].scrollIntoView(true);", productWrapper);
		actions.moveToElement(productWrapper).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		By dynamicAddToCartBtn = By
				.xpath("(//div[@class='product-overlay']//a[contains(text(),'Add to cart')])[" + productIndex + "]");
		waitToBeClickable(driver, dynamicAddToCartBtn, 10);
		WebElement addToCartBtn = driver.findElement(dynamicAddToCartBtn);
		actions.moveToElement(addToCartBtn).click().perform();
WebElement productName = driver.findElement(By.xpath("(//div[@class='product-overlay'])["+productIndex+"]/div/p"));
return productName.getText();
	}

	public void clickContinueShopping() {
		waitToBeClickable(driver, continueShoppingBtn, 10);
		actions.moveToElement(driver.findElement(continueShoppingBtn)).click().build().perform();
	}

	public void clickViewCart() {
		waitToBeClickable(driver, viewCartBtn, 10);
		actions.moveToElement(driver.findElement(viewCartBtn)).click().build().perform();
	}
	
	public boolean isBrandsHeaderDisplayed() {
		waitForVisibility(driver, brandsHeader, 10);
		return driver.findElement(brandsHeader).isDisplayed();
	}
	
	public boolean isBrandsLinksDisplayed() {
		waitForVisibility(driver, brandsLinks, 10);
		return driver.findElement(brandsLinks).isDisplayed();
	}

	public void clickBrandPolo() {
		driver.findElement(brandPoloLink).click();
	}
	
	public int getNumberOfDisplayedProducts() {
		List <WebElement> allProducts = driver.findElements(allProductsDisplayed);
		return allProducts.size();
	}
	
}
