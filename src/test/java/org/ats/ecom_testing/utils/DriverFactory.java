package org.ats.ecom_testing.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static WebDriver initializeDriver(String browser) {
        if (tlDriver.get() == null) {
        	WebDriver driver;
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    tlDriver.set(driver);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    tlDriver.set(new FirefoxDriver());
                    break;
                case "edge":
                	WebDriverManager.edgedriver().setup();
                	tlDriver.set(new EdgeDriver());
                	break;
                default:
                    throw new IllegalArgumentException("Browser not supported: " + browser);
            }
        }
        return getDriver();
    }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}
