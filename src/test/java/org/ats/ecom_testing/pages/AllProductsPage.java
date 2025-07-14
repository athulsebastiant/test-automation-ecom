package org.ats.ecom_testing.pages;
import static org.ats.ecom_testing.utils.WaitUtils.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ats.ecom_testing.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class AllProductsPage {
	private static final Logger log = LogManager.getLogger(AccountCreatedPage.class);
	
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
		try {
            waitForVisibility(driver, allProductsHeader, 10);
            boolean visible = driver.findElement(allProductsHeader).isDisplayed();
            log.info("'All Products' header visible: {}", visible);
            return visible;
        } catch (TimeoutException e) {
            log.error("Timeout waiting for 'All Products' header", e);
        } catch (NoSuchElementException e) {
            log.error("'All Products' header element not found", e);
        } catch (Exception e) {
            log.error("Unexpected error checking 'All Products' header visibility", e);
        }
        return false;
	}

	public boolean isAllProductsListVisible() {
		log.info("Checking visibility of products list");
        try {
            waitForVisibility(driver, productList, 10);
            boolean visible = driver.findElement(productList).isDisplayed();
            log.info("Products list visible: {}", visible);
            return visible;
        } catch (TimeoutException e) {
            log.error("Timeout waiting for products list", e);
        } catch (NoSuchElementException e) {
            log.error("Products list element not found", e);
        } catch (Exception e) {
            log.error("Unexpected error checking products list visibility", e);
        }
        return false;
	}

	public void clickFirstProductView() {
		log.info("Clicking 'View Product' on the first product");
		try {
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(viewProductOfFirst));
		driver.findElement(viewProductOfFirst).click();
		log.info("'View Product' clicked on first product");
		} catch (TimeoutException e) {
            log.error("Timeout interacting with first product view", e);
            throw e;
        } catch (NoSuchElementException e) {
            log.error("'View Product' link for first product not found", e);
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error clicking first product view", e);
            throw e;
        }
	}

	public void search(String text) {
		log.info("Performing search for '{}'", text);
        try {
            driver.findElement(searchBox).sendKeys(text);
            driver.findElement(searchBtn).click();
            log.info("Search for '{}' submitted", text);
        } catch (Exception e) {
            log.error("Error during search for '{}'", text, e);
            throw e;
        }
	}

	public boolean isSearchedProductsHeadervisible() {
		log.info("Checking visibility of 'Searched Products' header");
        try {
            waitForVisibility(driver, searchedProductsHeader, 10);
            boolean visible = driver.findElement(searchedProductsHeader).isDisplayed();
            log.info("'Searched Products' header visible: {}", visible);
            return visible;
        } catch (TimeoutException e) {
            log.error("Timeout waiting for 'Searched Products' header", e);
        } catch (NoSuchElementException e) {
            log.error("'Searched Products' header element not found", e);
        } catch (Exception e) {
            log.error("Unexpected error checking 'Searched Products' header visibility", e);
        }
        return false;
	}

	public boolean areAllSearchedProductsRelevant(String keyword) {
		log.info("Verifying all searched products contain keyword '{}'", keyword);
		try {
		String normalizedKeyword = keyword.toLowerCase().replaceAll("[-\\s]", "");
		List<WebElement> productNames = driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"));
		for (WebElement product : productNames) {
			String normalizedName = product.getText().toLowerCase().replaceAll("[-\\s]", "");

			if (!normalizedName.contains(normalizedKeyword.toLowerCase())) {
				System.out.println("Irrelevant product found: " + normalizedName);
				return false;
			}
		}
		log.info("All {} searched products are relevant", productNames.size());
        return true;
		} catch (Exception e) {
            log.error("Error verifying searched products relevance", e);
            throw e;
        }
	}

	public String clickAddToCart(int productIndex) {
	//	(//div[@class='product-image-wrapper'])[1]//p
		log.info("Adding product #{} to cart", productIndex);
		try {
		WebElement productWrapper = driver
				.findElement(By.xpath("(//div[@class='product-image-wrapper'])[" + productIndex + "]"));
		js.executeScript("arguments[0].scrollIntoView(true);", productWrapper);
		actions.moveToElement(productWrapper).perform();
		
			Thread.sleep(2000);
		
		By dynamicAddToCartBtn = By
				.xpath("(//div[@class='product-overlay']//a[contains(text(),'Add to cart')])[" + productIndex + "]");
		waitToBeClickable(driver, dynamicAddToCartBtn, 10);
		WebElement addToCartBtn = driver.findElement(dynamicAddToCartBtn);
		actions.moveToElement(addToCartBtn).click().perform();
WebElement productName = driver.findElement(By.xpath("(//div[@class='product-overlay'])["+productIndex+"]/div/p"));
return productName.getText();
		} catch (InterruptedException e) {
            log.error("Interrupted while waiting to click Add to Cart", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            log.error("Timeout waiting for Add to Cart button on product #{}", productIndex, e);
            throw e;
        } catch (NoSuchElementException e) {
            log.error("Add to Cart button or product name not found for product #{}", productIndex, e);
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error adding product #{} to cart", productIndex, e);
            throw e;
        }
	}

	public void clickContinueShopping() {
		log.info("Clicking 'Continue Shopping' button");
		try {
            waitToBeClickable(driver, continueShoppingBtn, 10);
            actions.moveToElement(driver.findElement(continueShoppingBtn))
                   .click().build().perform();
            log.info("'Continue Shopping' clicked");
        } catch (TimeoutException e) {
            log.error("Timeout waiting for 'Continue Shopping' button", e);
            throw e;
        } catch (NoSuchElementException e) {
            log.error("'Continue Shopping' button not found", e);
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error clicking 'Continue Shopping'", e);
            throw e;
        }
	}

	public void clickViewCart() {
		log.info("Clicking 'View Cart' button");
		try {
            waitToBeClickable(driver, viewCartBtn, 10);
            actions.moveToElement(driver.findElement(viewCartBtn))
                   .click().build().perform();
            log.info("'View Cart' clicked");
        } catch (TimeoutException e) {
            log.error("Timeout waiting for 'View Cart' button", e);
            throw e;
        } catch (NoSuchElementException e) {
            log.error("'View Cart' button not found", e);
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error clicking 'View Cart'", e);
            throw e;
        }
	}
	
	public boolean isBrandsHeaderDisplayed() {
		log.info("Checking visibility of 'Brands' header");
		try {
            waitForVisibility(driver, brandsHeader, 10);
            boolean visible = driver.findElement(brandsHeader).isDisplayed();
            log.info("'Brands' header visible: {}", visible);
            return visible;
        } catch (TimeoutException e) {
            log.error("Timeout waiting for 'Brands' header", e);
        } catch (NoSuchElementException e) {
            log.error("'Brands' header not found", e);
        } catch (Exception e) {
            log.error("Unexpected error checking 'Brands' header visibility", e);
        }
        return false;
	}
	
	public boolean isBrandsLinksDisplayed() {
		log.info("Checking visibility of brands links section");
		try {
            waitForVisibility(driver, brandsLinks, 10);
            boolean visible = driver.findElement(brandsLinks).isDisplayed();
            log.info("Brands links section visible: {}", visible);
            return visible;
        } catch (TimeoutException e) {
            log.error("Timeout waiting for brands links", e);
        } catch (NoSuchElementException e) {
            log.error("Brands links section not found", e);
        } catch (Exception e) {
            log.error("Unexpected error checking brands links visibility", e);
        }
        return false;
	}

	public void clickBrandPolo() {
		log.info("Clicking on 'Polo' brand link");
        try {
            driver.findElement(brandPoloLink).click();
            log.info("'Polo' brand link clicked");
        } catch (TimeoutException e) {
            log.error("Timeout clicking 'Polo' brand", e);
            throw e;
        } catch (NoSuchElementException e) {
            log.error("'Polo' brand link not found", e);
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error clicking 'Polo' brand", e);
            throw e;
        }
	}
	
	public int getNumberOfDisplayedProducts() {
		log.info("Counting displayed products");
        try {
            List<WebElement> allProducts = driver.findElements(allProductsDisplayed);
            int count = allProducts.size();
            log.info("Number of displayed products: {}", count);
            return count;
        } catch (Exception e) {
            log.error("Error counting displayed products", e);
            throw e;
        }
	}
	
}
