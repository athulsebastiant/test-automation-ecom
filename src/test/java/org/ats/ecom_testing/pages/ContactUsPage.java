package org.ats.ecom_testing.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ats.ecom_testing.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import static org.ats.ecom_testing.utils.WaitUtils.*;

import java.io.File;

public class ContactUsPage {
	WebDriver driver;
	private static final Logger log = LogManager.getLogger(ContactUsPage.class);

	By getInTouchHeader = By.xpath("//h2[contains(text(),'Get In Touch')]");
	By nameInput = By.xpath("//input[@placeholder='Name']");
	By emailInput = By.xpath("//input[@placeholder='Email']");
	By subjectinput = By.xpath("//input[@placeholder='Subject']");
	By messageInput = By.xpath("//textarea[@placeholder='Your Message Here']");
	By fileUpload = By.xpath("//input[@name='upload_file']");
	By submitBtn = By.xpath("//input[@value='Submit']");
	By successMsg = By.xpath(
			"//h2[contains(text(),'Get In Touch')]/following-sibling::div[contains(text(),'Success! Your details have been submitted successfully.')]");
	By homeBtn = By.xpath("//a/span[contains(text(),' Home')]");

	public ContactUsPage() {
		this.driver = DriverFactory.getDriver();
	}

	public boolean isGetInTouchHeaderVisible() {
		log.info("Checking if 'Get In Touch' header is visible");
		try {
			waitForVisibility(driver, getInTouchHeader, 10);
			boolean visible = driver.findElement(getInTouchHeader).isDisplayed();
			log.info("'Get In Touch' header visible: {}", visible);
			return visible;
		} catch (TimeoutException e) {
			log.error("Timeout waiting for 'Get In Touch' header", e);
		} catch (NoSuchElementException e) {
			log.error("'Get In Touch' header not found", e);
		} catch (Exception e) {
			log.error("Unexpected error checking 'Get In Touch' header", e);
		}
		return false;
	}

	public void enterName(String name) {
		log.info("Entering name: {}", name);
		try {
			driver.findElement(nameInput).sendKeys(name);
			log.info("Name entered");
		} catch (Exception e) {
			log.error("Error entering name", e);
			throw e;
		}
	}

	public void enterEmail(String email) {
		log.info("Entering email: {}", email);
		try {
			driver.findElement(emailInput).sendKeys(email);
			log.info("Email entered");
		} catch (Exception e) {
			log.error("Error entering email", e);
			throw e;
		}
	}

	public void enterSubject(String subject) {
		log.info("Entering subject: {}", subject);
		try {
			driver.findElement(subjectinput).sendKeys(subject);
			log.info("Subject entered");
		} catch (Exception e) {
			log.error("Error entering subject", e);
			throw e;
		}
	}

	public void enterMessage(String message) {
		log.info("Entering message");
		try {
			driver.findElement(messageInput).sendKeys(message);
			log.info("Message entered");
		} catch (Exception e) {
			log.error("Error entering message", e);
			throw e;
		}
	}

	public void uploadFile(String relativePathToFile) {
		log.info("Uploading file from path: {}", relativePathToFile);
		try {
			File file = new File(relativePathToFile);
			driver.findElement(fileUpload).sendKeys(file.getAbsolutePath());
			log.info("File uploaded: {}", file.getAbsolutePath());
		} catch (NoSuchElementException e) {
			log.error("File upload input not found", e);
			throw e;
		} catch (Exception e) {
			log.error("Error uploading file", e);
			throw e;
		}
	}

	public void clickSubmitBtn() {
		log.info("Clicking Submit button");
		try {
			driver.findElement(submitBtn).click();
			log.info("Submit button clicked");
		} catch (Exception e) {
			log.error("Error clicking Submit button", e);
			throw e;
		}
	}

	public boolean isSuccessMsgVisible() {
		log.info("Checking if success message is visible");
		try {
			waitForVisibility(driver, successMsg, 10);
			boolean visible = driver.findElement(successMsg).isDisplayed();
			log.info("Success message visible: {}", visible);
			return visible;
		} catch (TimeoutException e) {
			log.error("Timeout waiting for success message", e);
		} catch (NoSuchElementException e) {
			log.error("Success message element not found", e);
		} catch (Exception e) {
			log.error("Unexpected error checking success message", e);
		}
		return false;
	}

	public void clickHomeBtn() {
		log.info("Clicking Home button");
		try {
			driver.findElement(homeBtn).click();
			log.info("Home button clicked");
		} catch (Exception e) {
			log.error("Error clicking Home button", e);
			throw e;
		}
	}
}
