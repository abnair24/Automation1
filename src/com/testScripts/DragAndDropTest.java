package com.testScripts;



import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.guiPages.baseClasses.AutomationBase;
import com.guiPages.navigation.Header;
import com.guiPages.pages.InformationPage;
import com.guiPages.pages.RegisterPage;

public class DragAndDropTest extends AutomationBase{
	RegisterPage registerPage;
	InformationPage information;
	Header header;
	
	
	@BeforeClass
	public void setup() throws Exception {
		super.setBrowser(getBrowser());
		
		registerPage= PageFactory.initElements(driver, RegisterPage.class);
		header= PageFactory.initElements(driver,Header.class);
		registerPage.webDriverImplicitWait();
		registerPage.open();
		registerPage.maximizeWindow();
		header.clickTab(Header.INFORMATION);
		information =registerPage.handleNewTab(InformationPage.class);
	}

	@Test(alwaysRun=true)
	public void dragTable1Element() throws Exception {
		Assert.assertTrue(information.isElementDragFromTable1());
	}
	
	@Test(alwaysRun=true)
	public void dragTable3Element() throws Exception {
		Assert.assertTrue(information.isElementDragFromTable3());
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		header.clickTab(Header.HOME);
		driver.quit();
	}
}
