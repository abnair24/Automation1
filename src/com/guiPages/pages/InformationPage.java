package com.guiPages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class InformationPage extends BasePage {
	
	public InformationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath=".//*[@id='P']")
	public WebElement welcomeMessage;
	
	@FindBy(id="log_out")
	WebElement logOut;
	
	@FindBy(xpath=".//*[@id='container']/div[3]/div[1]/table/tbody/tr[1]/td[1]")
	WebElement marketingTab;
	
	@FindBy(xpath=".//*[@id='container']/div[3]/div[1]/table/tbody/tr[1]/td[2]")
	WebElement webTab;
	
	@FindBy(xpath=".//*[@id='container']/div[3]/div[1]/table/tbody/tr[1]/td[3]")
	WebElement mobileTab;
	
	@FindBy(xpath=".//*[@id='sortable1']/li[1]")
	public WebElement elementTable1;
	
	@FindBy(xpath=".//*[@id='sortable2']/li[1]")
	public WebElement elementTable2;
	
	@FindBy(xpath=".//*[@id='sortable3']/li[3]")
	public WebElement elementTable3;
	
	@FindBy(id="sortable2")
	WebElement table2;
	
	@FindBy(id="sortable1")
	WebElement table1;
	
	@FindBy(id="sortable3")
	WebElement table3;
	
	@FindBy(xpath=".//*[@id='sortabletable']/thead/tr/td[1]/a")
	WebElement firstName;
	
	@FindBy(xpath=".//*[@id='sortabletable']/thead/tr/td[2]/a")
	WebElement lastName;
	
	@FindBy(xpath=".//*[@id='sortabletable']/thead/tr/td[3]/a")
	WebElement department;
	
	public boolean isElementDragFromTable1() throws Exception {
		String element1= dragAndDrop(elementTable1,elementTable2);
		return table2.getText().contains(element1);
	}
	
	public boolean isElementDragFromTable3() throws Exception {
		String element3 = dragAndDrop(elementTable3, elementTable2);
		return table2.getText().contains(element3);
	}
	
	
}
