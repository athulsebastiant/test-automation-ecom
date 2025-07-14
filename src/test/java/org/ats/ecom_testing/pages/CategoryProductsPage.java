package org.ats.ecom_testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import static org.ats.ecom_testing.utils.WaitUtils.*;

import org.ats.ecom_testing.utils.DriverFactory;
public class CategoryProductsPage {
	WebDriver driver;
	JavascriptExecutor js;
	By categoryHeaderWomenDress = By.xpath("//h2[contains(text(),'Women - Dress Products')]");
	By categoryHeaderMenTshirt = By.xpath("//h2[contains(text(),'Men - Tshirts Products')]");
	By categoryMen = By.xpath("//a[@href='#Men']");
	By subcategoryMenTshirts = By.xpath("//div[@id='Men']/div/ul/li/a[contains(text(),'Tshirts')]");
	public CategoryProductsPage() {
		this.driver = DriverFactory.getDriver();
		this.js = (JavascriptExecutor)driver;
	}
	
	public String getCategoryHeaderWomenDress() {
		waitForVisibility(driver, categoryHeaderWomenDress, 10);
		return driver.findElement(categoryHeaderWomenDress).getText();
	}
	
	public String getCategoryHeaderMenTshirts() {
		waitForVisibility(driver, categoryHeaderMenTshirt, 10);
		return driver.findElement(categoryHeaderMenTshirt).getText();
	}
	
	public void clickCategoryMen() {
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(categoryMen));
		driver.findElement(categoryMen).click();
	}
	
	public void clickSUbcategoryMenTshirts() {
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(subcategoryMenTshirts));
		driver.findElement(subcategoryMenTshirts).click();
	}
	
}
