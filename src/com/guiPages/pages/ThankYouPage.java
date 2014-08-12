package com.guiPages.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThankYouPage extends BasePage {
	
	public ThankYouPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath=".//*[@id='log_out']/a")
	public WebElement logOut;
	
	@FindBy(xpath=".//*[@id='P']")
	WebElement welcomeMessage;
	
	@FindBy(xpath=".//*[@id='Details']/form/span[1]")
	WebElement firstName;
	
	@FindBy(xpath=".//*[@id='Details']/form/span[2]")
	WebElement lastName;
	
	@FindBy(xpath=".//*[@id='Details']/form/span[3]")
	WebElement phoneNumber;
	
	@FindBy(xpath=".//*[@id='Details']/form/span[4]")
	WebElement gender;
	
	@FindBy(xpath=".//*[@id='Details']/form/span[5]")
	WebElement industry;
	
	@FindBy(xpath=".//*[@id='Details']/form/span[6]")
	WebElement country;
	
	@FindBy(xpath=".//*[@id='Details']/form/span[7]")
	WebElement education;
	
	@FindBy(xpath=".//*[@id='Details']/form/span[10]")
	WebElement fileName;
	
	@FindBy(xpath=".//*[@id='Details']/form/span[11]")
	WebElement aboutMe;
	
	public String welcomeMessage() throws Exception {
		return welcomeMessage.getText();
	}
	
	public String firstName() throws Exception {
		return firstName.getText();
	}
	
	public String lastName() throws Exception {
		return lastName.getText();
	}
	
	public String phoneNumber() throws Exception {
		return phoneNumber.getText();
	}
	
	public String gender() throws Exception {
		return gender.getText();
	}
	
	public String industry() throws Exception {
		return industry.getText();
	}
	
	public String country() throws Exception {
		return country.getText();
	}
	
	public String education() throws Exception {
		return education.getText();
	}
	
	public String fetchFileName() throws Exception {
		return fileName.getText();
	}
	
	public boolean logoutLinkStatus() throws Exception {
		return logOut.isEnabled();
	}
	
	public String logOut() throws Exception {
		logOut.click();
		webDriverImplicitWait();
		return pageTitle();
	}
}
