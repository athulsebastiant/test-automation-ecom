package org.ats.ecom_testing.base;

import org.ats.ecom_testing.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;



public class BaseTest {
	 protected WebDriver driver;

	    @BeforeClass(alwaysRun = true, groups = {"smoke","account","product"})
	    @Parameters("browser")
	    public void setUp(@Optional("chrome") String browser) {
	    	System.out.println("=== setUp() called ===");
	        driver = DriverFactory.initializeDriver(browser);
	        driver.manage().window().maximize();
	        driver.get("https://automationexercise.com/");
	    }

	    @AfterClass(alwaysRun = true,groups = {"smoke","account","product"})
	    public void tearDown() {
	        DriverFactory.quitDriver();
	    }
}
