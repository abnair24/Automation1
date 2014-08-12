package com.guiPages.common;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.GetScreenOrientation;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {
	
			
	public static void populateField(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	
	public static void selectRadioButton(List<WebElement>radioButtons, String value) {
		
		for(WebElement radio: radioButtons) {
			if(radio.getAttribute("value").equalsIgnoreCase(value))
				radio.click();
		}
	}
	
	public static void selectCheckBoxes(List<WebElement>checkBoxes, String value) {
		
		List<String> list = new ArrayList<String>(Arrays.asList(value.split(",")));
		
		for(String str:list) {
			
			for(WebElement check: checkBoxes) {
				
				if(check.getAttribute("value").equalsIgnoreCase(str)) {
					check.click();
				}
			}
		}
		
	}

	public static void selectDropDown(WebElement dropDown, String value) {
		new Select(dropDown).selectByVisibleText(value);
	}
	
	public static void autoSuggestDropDown(WebElement autoDropDown, String value) throws InterruptedException {
		autoDropDown.sendKeys(value);
		autoDropDown.sendKeys(Keys.TAB);
		}
	
	public static void uploadFile(WebElement fileUpload,String value) {
		fileUpload.sendKeys(value);
	}
	
	public static void handleNewTabWindow(WebDriver driver) {
		Set<String>handles = driver.getWindowHandles();
		String newTab= (String)handles.toArray()[1];
		driver.switchTo().window(newTab);
	}
	
	public static WebElement getElementByText(List<WebElement>elements,String value) {
		WebElement retValue= null;
		for(WebElement element: elements) {
			if(value.equalsIgnoreCase(element.getText())) 
			{
				retValue=element;
				break;
			}
		}
		return retValue;
	}
	
}
