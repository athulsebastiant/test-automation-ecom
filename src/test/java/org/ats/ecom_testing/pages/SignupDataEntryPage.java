package org.ats.ecom_testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import static org.ats.ecom_testing.utils.WaitUtils.*;

import org.ats.ecom_testing.utils.DriverFactory;
public class SignupDataEntryPage {
	WebDriver driver;
	Actions actions;
	JavascriptExecutor js;
	By enterAccountInfoHeader = By.xpath("//h2/b[contains(text(),'Enter Account Information')]");
	By selectTitleMr = By.id("id_gender1"); 
	By selectTitleMrs = By.id("id_gender2");
	By enterName = By.xpath("//input[@id='name']");
	By enterPasswd = By.xpath("//input[@id='password']");
	By selectDay = By.cssSelector("select#days.form-control");
	By selectMonth = By.cssSelector("select#months.form-control");
	By selectYear = By.cssSelector("select#years.form-control");
	By checkNewsletter = By.cssSelector("input#newsletter");
	By checkSpOffer = By.cssSelector("input#optin");
	
	// Address info
	
	By enterFirstName = By.cssSelector("input#first_name");
	By enterLastName = By.cssSelector("input#last_name");
	By enterCompany = By.cssSelector("input#company");
	By enterAdd1 = By.cssSelector("input#address1");
	By enterAdd2 = By.cssSelector("input#address2");
	By selectCountry = By.cssSelector("select#country");
	By enterState = By.cssSelector("input#state");
	By enterCity = By.cssSelector("input#city");
	By enterZipcode = By.cssSelector("input#zipcode");
	By enterMob = By.cssSelector("input#mobile_number");
	
	By createAccBtn = By.xpath("//button[contains(text(),'Create Account')]");
	
	
	
	public SignupDataEntryPage() {
		// TODO Auto-generated constructor stub
		this.driver = DriverFactory.getDriver();
		this.actions = new Actions(driver);
		this.js = (JavascriptExecutor)driver;
	}
	
	public boolean isEnterAccountInfoVisible() {
		waitForVisibility(driver, enterAccountInfoHeader, 10);
		return driver.findElement(enterAccountInfoHeader).isDisplayed();
	}
	
	public void selectTitleMr() {
		driver.findElement(selectTitleMr).click();
	}
	
	public void selectTitleMrs() {
		driver.findElement(selectTitleMrs).click();
	}
	
//	public void typeName(String name) {
//		driver.findElement(enterName).sendKeys(name);
//	}
	
	public void typePswd(String pswd) {
		driver.findElement(enterPasswd).sendKeys(pswd);
	}
	
	public void chooseDay(String day) {
		Select select = new Select(driver.findElement(selectDay));
		select.selectByVisibleText(day);
	}
	
	public void chooseMonth(String month) {
		Select select = new Select(driver.findElement(selectMonth));
		select.selectByVisibleText(month);
	}
	
	public void chooseYear(String year) {
		Select select = new Select(driver.findElement(selectYear));
		select.selectByVisibleText(year);
	}
	
	public void optNewsLetter(boolean choice) {
		
		if(choice) {
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(checkNewsletter));
			driver.findElement(checkNewsletter).click();
		}
	}
	
	public void optSpOffer(boolean choice) {
		if(choice) {
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(checkSpOffer));
			driver.findElement(checkSpOffer).click();
		}
	}
	
	public void typeFirstname(String fn) {
		driver.findElement(enterFirstName).sendKeys(fn);
	}
	
	public void typeLastname(String ln) {
		driver.findElement(enterLastName).sendKeys(ln);
	}
	
	public void typeCompany(String cn) {
		driver.findElement(enterCompany).sendKeys(cn);
	}
	
	public void typeAddress1(String add1) {
		driver.findElement(enterAdd1).sendKeys(add1);
	}
	
	public void typeAddress2(String add2) {
		driver.findElement(enterAdd2).sendKeys(add2);
	}
	
	public void chooseCountry(String country) {
		Select select = new Select(driver.findElement(selectCountry));
		select.selectByVisibleText(country);
	}
	
	public void typeState(String state) {
		driver.findElement(enterState).sendKeys(state);
	}
	
	public void typeCity(String city) {
		driver.findElement(enterCity).sendKeys(city);
	}
	
	public void typeZip(String zip) {
		driver.findElement(enterZipcode).sendKeys(zip);
	}
	
	public void typeMob(String mob) {
		driver.findElement(enterMob).sendKeys(mob);
	}
	
	public void clickCreateAccount() {
		driver.findElement(createAccBtn).click();
	}
}
