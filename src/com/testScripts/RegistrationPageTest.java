package com.testScripts;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;




import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guiPages.baseClasses.AutomationBase;
import com.guiPages.common.RowNumber;
import com.guiPages.excelRead.ExcelReader;
import com.guiPages.excelRead.UserDetails;
import com.guiPages.navigation.Header;
import com.guiPages.pages.HomePage;
import com.guiPages.pages.ImageGallery;
import com.guiPages.pages.RegisterPage;
import com.guiPages.pages.ThankYouPage;

public class RegistrationPageTest extends AutomationBase {
	
	RegisterPage register;
	ThankYouPage thankYou;
	Header header;
	HomePage homePage;
	ImageGallery imageGallery;
	
		
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
	
	@DataProvider(name="Userlist_Data")
	public static Iterator<Object[]> userListDetails(Method testName) throws Exception {
		RowNumber rowNumber= testName.getAnnotation(RowNumber.class);
		int rowsToBeFetched = rowNumber.rowNumber();
		
		return ExcelReader.excelRead(rowsToBeFetched);
	}
	
	
	@RowNumber(rowNumber=0)
	@Test(dataProvider ="Userlist_Data",priority=0) 
	public void registrationTest(UserDetails user) throws Exception {
		register.populateUserFields(user);
		register.submitButton.click();
	    register.webDriverWaitExpectedCondition(thankYou.logOut);
	    
	    Assert.assertEquals(thankYou.welcomeMessage(), "Welcome "+user.getFirstName());
	    Assert.assertEquals(thankYou.firstName(), user.getFirstName());
	    Assert.assertEquals(thankYou.lastName(), user.getLastName());
	    Assert.assertEquals(thankYou.phoneNumber(),user.getPhoneNumber());
	    Assert.assertEquals(thankYou.gender(), user.getGender());
	    Assert.assertEquals(thankYou.industry(), user.getIndustry());
	    Assert.assertEquals(thankYou.country(), user.getCountry());
	    Assert.assertEquals(thankYou.education(),user.getEducation());
	    Assert.assertTrue(thankYou.logoutLinkStatus());
	    register.pageScreenShot(user.getFirstName());
		
		Assert.assertEquals(thankYou.logOut(),register.pageTitle());
		}
	
	
    @RowNumber (rowNumber = 1)
    @Test(dataProvider="Userlist_Data",priority=1)
	public void cookieTest(UserDetails user) throws Exception {
		register.populateUserFields(user);
		register.submitButton.click();
		register.webDriverWaitExpectedCondition(thankYou.logOut);
		register.deleteCookie();
		header.clickTab(Header.HOME);
		header.clickTab(Header.IMAGE_GALLERY);
		
		Assert.assertEquals(homePage.welcomeMessage(), "Welcome Guest");
		Assert.assertEquals(imageGallery.welcomeMessage(), "Welcome Guest");
		header.clickTab(Header.HOME);
		
	}
    
    @AfterClass
    public void teardown() throws Exception {
    	
    	driver.quit();
    }
    
}


