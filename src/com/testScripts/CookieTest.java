package com.testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.guiPages.baseClasses.AutomationBase;
import com.guiPages.common.RowNumber;
import com.guiPages.excelRead.UserDetails;
import com.guiPages.navigation.Header;
import com.guiPages.pages.HomePage;
import com.guiPages.pages.ImageGallery;
import com.guiPages.pages.RegisterPage;
import com.guiPages.pages.ThankYouPage;

public class CookieTest extends AutomationBase{
	RegisterPage register;
	Header header;
	HomePage homePage;
	ImageGallery imageGallery;
	ThankYouPage thankYou;
	
	
	@BeforeClass
	public void setup() throws Exception {
		super.setBrowser(getBrowser());
		
		/* Initializing RegisterPage and ThankYou page */
		
		register= PageFactory.initElements(driver, RegisterPage.class);
		thankYou= PageFactory.initElements(driver, ThankYouPage.class);
		header = PageFactory.initElements(driver,Header.class);
		homePage= PageFactory.initElements(driver, HomePage.class);
		imageGallery= PageFactory.initElements(driver, ImageGallery.class);
		
		register.webDriverImplicitWait();
		register.open();
		register.maximizeWindow();
	}
	
	@RowNumber(rowNumber=1)
	@Test(dataProvider="Userlist_Data",dataProviderClass=RegistrationPageTest.class)
	
	public void cookieTest(UserDetails user) throws Exception {
		
		register.populateUserFields(user);
		register.submitButton.click();
		register.webDriverWaitExpectedCondition(thankYou.logOut);
		register.deleteCookie();
		header.clickTab(Header.HOME);
		header.clickTab(Header.IMAGE_GALLERY);
		
		Assert.assertEquals(homePage.welcomeMessage(), "Welcome Guest");
		Assert.assertEquals(imageGallery.welcomeMessage(), "Welcome Guest");		
	}
	
	@AfterClass
	public void teardown() throws Exception {
		header.clickTab(Header.HOME);
		driver.quit();
	}
}
