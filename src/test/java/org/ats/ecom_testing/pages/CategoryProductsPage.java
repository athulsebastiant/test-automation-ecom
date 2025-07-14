package org.ats.ecom_testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import static org.ats.ecom_testing.utils.WaitUtils.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ats.ecom_testing.utils.DriverFactory;

public class CategoryProductsPage {
	private static final Logger log = LogManager.getLogger(CategoryProductsPage.class);

	WebDriver driver;
	JavascriptExecutor js;
	By categoryHeaderWomenDress = By.xpath("//h2[contains(text(),'Women - Dress Products')]");
	By categoryHeaderMenTshirt = By.xpath("//h2[contains(text(),'Men - Tshirts Products')]");
	By categoryMen = By.xpath("//a[@href='#Men']");
	By subcategoryMenTshirts = By.xpath("//div[@id='Men']/div/ul/li/a[contains(text(),'Tshirts')]");

	public CategoryProductsPage() {
		this.driver = DriverFactory.getDriver();
		this.js = (JavascriptExecutor) driver;
	}

	public String getCategoryHeaderWomenDress() {
		log.info("Retrieving 'Women - Dress Products' header text");
		try {
			waitForVisibility(driver, categoryHeaderWomenDress, 10);
			String text = driver.findElement(categoryHeaderWomenDress).getText();
			log.info("Found header text: {}", text);
			return text;
		} catch (TimeoutException e) {
			log.error("Timeout waiting for 'Women - Dress Products' header", e);
			throw e;
		} catch (NoSuchElementException e) {
			log.error("'Women - Dress Products' header element not found", e);
			throw e;
		} catch (Exception e) {
			log.error("Unexpected error getting 'Women - Dress Products' header", e);
			throw e;
		}
	}

	public String getCategoryHeaderMenTshirts() {
		log.info("Retrieving 'Men - Tshirts Products' header text");
		try {
			waitForVisibility(driver, categoryHeaderMenTshirt, 10);
			String text = driver.findElement(categoryHeaderMenTshirt).getText();
			log.info("Found header text: {}", text);
			return text;
		} catch (TimeoutException e) {
			log.error("Timeout waiting for 'Men - Tshirts Products' header", e);
			throw e;
		} catch (NoSuchElementException e) {
			log.error("'Men - Tshirts Products' header element not found", e);
			throw e;
		} catch (Exception e) {
			log.error("Unexpected error getting 'Men - Tshirts Products' header", e);
			throw e;
		}
	}

	public void clickCategoryMen() {
		log.info("Clicking category tab 'Men'");
		try {
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(categoryMen));
			driver.findElement(categoryMen).click();
			log.info("'Men' category clicked");
		} catch (TimeoutException e) {
			log.error("Timeout locating 'Men' category link", e);
			throw e;
		} catch (NoSuchElementException e) {
			log.error("'Men' category link not found", e);
			throw e;
		} catch (Exception e) {
			log.error("Unexpected error clicking 'Men' category", e);
			throw e;
		}
	}

	public void clickSUbcategoryMenTshirts() {
		log.info("Clicking subcategory 'Men - Tshirts'");
		try {
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(subcategoryMenTshirts));
			driver.findElement(subcategoryMenTshirts).click();
			log.info("'Men - Tshirts' subcategory clicked");
		} catch (TimeoutException e) {
			log.error("Timeout locating 'Men - Tshirts' subcategory link", e);
			throw e;
		} catch (NoSuchElementException e) {
			log.error("'Men - Tshirts' subcategory link not found", e);
			throw e;
		} catch (Exception e) {
			log.error("Unexpected error clicking 'Men - Tshirts' subcategory", e);
			throw e;
		}
	}

}
