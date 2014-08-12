package com.guiPages.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guiPages.common.CommonMethods;
import com.guiPages.excelRead.ExcelReader;
import com.guiPages.excelRead.UserDetails;

public class RegisterPage extends BasePage {
	
	public RegisterPage(WebDriver driver) {
		super(driver);
	}
		
	
	@FindBy(xpath="//div[1]/div[3]/div/div/form/input[1]") 
	WebElement firstName;
	
	@FindBy(xpath="//div[1]/div[3]/div/div/form/input[2]")
	WebElement lastName;
	
	@FindBy(xpath="//div[1]/div[3]/div/div/form/input[3]")
	WebElement phoneNumber;
	
	@FindAll(@FindBy(xpath="//div[1]/div[3]/div/div/form/div[1]/div[2]/input"))
	List<WebElement> gender;
	
	@FindBy(xpath="//div[1]/div[3]/div/div/form/select[1]")
	WebElement industry;
	
	@FindBy(id="tags")
	WebElement country;
	
	@FindBy(xpath="//div[1]/div[3]/div/div/form/select[2]")
	WebElement education;
	
	@FindBy(xpath="//div[1]/div[3]/div/div/form/select[3]")
	WebElement course;
	
	@FindAll(@FindBy(xpath="//div[1]/div[3]/div/div/form/div[3]/div[2]/input"))
	List<WebElement> hobby;
	
	@FindBy(xpath="//div[1]/div[3]/div/div/form/input[4]")
	WebElement browseButton;
	
	@FindBy(xpath="//div[1]/div[3]/div/div/form/textarea")
	WebElement aboutMe;
	
	@FindBy(xpath=".//*[@id='Details']/form/div[4]/input[1]")
	public WebElement submitButton;
	
	@FindBy(xpath=".//*[@id='Details']/form/div[4]/input[2]")
	WebElement resetButton;	
	
	
	
	public void populateUserFields(UserDetails user) throws InterruptedException, IOException {
		CommonMethods.populateField(firstName, user.getFirstName());
		CommonMethods.populateField(lastName, user.getLastName());
		CommonMethods.populateField(phoneNumber, user.getPhoneNumber());
		CommonMethods.selectRadioButton(gender,user.getGender());
		CommonMethods.selectDropDown(industry, user.getIndustry());
		CommonMethods.autoSuggestDropDown(country, user.getCountry());
		CommonMethods.selectDropDown(education, user.getEducation());
		CommonMethods.selectDropDown(course, user.getCourse());
		CommonMethods.selectCheckBoxes(hobby, user.getHobby());
		CommonMethods.populateField(aboutMe, user.getAboutMe());
		CommonMethods.uploadFile(browseButton, user.getFile());
			
	}
	
		
}
	
	
	


