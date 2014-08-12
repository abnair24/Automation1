package com.guiPages.pages;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.ExpectedExceptionsHolder;

import com.guiPages.baseClasses.AutomationBase;
import com.guiPages.common.CommonMethods;

public class BasePage {

	private static final int EXPLICIT_WAIT_TIMEOUT=5;
	private static final int IMPLICIT_WAIT_TIMEOUT=5;
	private static final String URL="http://www.grazitti.com/qasite/sample_reg.php";
	
	
	/* WebDriver for the page */
	WebDriver driver;
	
	/* Expected page title. is used in isPageLoad() to check page is loaded */
	String pageTitle;
	
	/* Constructor */
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	/*Open default page */
	public void open() {
		driver.get(AutomationBase.getUrl());
	}
	
	/* Return the page title */
	public String getURL() {
		return URL;
	}
	
	/* Return page title */
	public String pageTitle() {
		return driver.getTitle();
	}
	
	/* Maximize Browser Window */
	
	public void pageScreenShot(String name) throws Exception {
		TakesScreenshot shot = (TakesScreenshot)driver;
		File scrshot= shot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrshot, new File(AutomationBase.getScreenshotPath()+name+"-"+getTimeStamp()+".jpg"));
		
	}
	
	public String getTimeStamp() throws Exception {
		Date time=new Date();
	    String timeStamp = new Timestamp(time.getTime()).toString();
	    timeStamp=timeStamp.replace(' ','_');
	    timeStamp=timeStamp.replace(":", "_");
	    return timeStamp;
	}
		
	public void webDriverWaitExpectedCondition(WebElement element) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void webDriverImplicitWait() throws Exception {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	public <T> T handleNewTab(Class<T> c) throws Exception {
		CommonMethods.handleNewTabWindow(driver);
		return PageFactory.initElements(driver,c);
		//Constructor<T>ct = c.getConstructor(WebDriver.class);
		
		//return ct.newInstance(driver);
	}
	
	public String dragAndDrop(WebElement source, WebElement target) throws Exception {
		String drag = source.getText();
		Actions action = new Actions(driver);
		action.dragAndDrop(source,target).build().perform();
		return drag;
	}
			
	public void deleteCookie() throws Exception {
		driver.manage().deleteAllCookies();
	}
	
	
	
	
	
	
	
	
	
	
}
