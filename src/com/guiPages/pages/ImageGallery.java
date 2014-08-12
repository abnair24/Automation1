package com.guiPages.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ImageGallery extends BasePage {
	
	public ImageGallery(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath=".//*[@id='P']")
	WebElement welcomeMessage;
	
	public String welcomeMessage() throws Exception {
		return welcomeMessage.getText();
	}
	

}
