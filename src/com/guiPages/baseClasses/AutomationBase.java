package com.guiPages.baseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AutomationBase {
	
	public static WebDriver driver;
	
	protected static AutomationProperties properties = new AutomationProperties();
	
	DesiredCapabilities capabilities = new DesiredCapabilities();
	
	public void setBrowser(final String BROWSER) throws Exception {
		
		if(BROWSER.contentEquals("firefox")) {
			FirefoxProfile firefoxprofile = new FirefoxProfile();
			firefoxprofile.setAssumeUntrustedCertificateIssuer(false);
			driver = new FirefoxDriver(firefoxprofile);
		}
		
		else if(BROWSER.contentEquals("internet explorer")) {
			System.setProperty("webdriver.ie.driver",getIEDriverPath());
			driver = new InternetExplorerDriver();
		}
		else if(BROWSER.contentEquals("chrome")) {
			System.setProperty("webdriver.chrome.driver",getChromeDriverPath());
			ChromeOptions chromeoptions =  new ChromeOptions();
			chromeoptions.addArguments("--test-type");
			driver = new ChromeDriver(chromeoptions);
		}
	}
	
	public static String getBrowser() {
		return properties.getPropertyValue(AutomationProperties.BROWSERNAME);
	}
	
	public static String getUrl() {
		return properties.getPropertyValue(AutomationProperties.BASE_URL);
	}
	
	public static String getExcelPath() {
		return properties.getPropertyValue(AutomationProperties.XLS_PATH);
	}
	
	public static String getScreenshotPath() {
		return properties.getPropertyValue(AutomationProperties.SCREENSHOT_PATH);
	}
	
	public static String getChromeDriverPath() {
		return properties.getPropertyValue(AutomationProperties.CHROME_DRIVER_PATH);
	}
	
	public static String getIEDriverPath() {
		return properties.getPropertyValue(AutomationProperties.IE_DRIVER_PATH);
	}
	

}
