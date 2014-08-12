package com.guiPages.navigation;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.guiPages.common.CommonMethods;
import com.guiPages.pages.BasePage;

public class Header extends BasePage {
	
	public static final String HOME="Home";
	public static final String INFORMATION="Information";
	public static final String IMAGE_GALLERY="Image Gallery";
	
	public Header(WebDriver driver) {
		super(driver);
	}

	
	@FindBys({@FindBy(className="header"), @FindBy(tagName="a")})
	List<WebElement> tabs;
	
	
	public void clickTab(String tabName) throws Exception {
		
		WebElement tab=CommonMethods.getElementByText(tabs,tabName);
		tab.click();
		webDriverImplicitWait();
	}
		
		
}
