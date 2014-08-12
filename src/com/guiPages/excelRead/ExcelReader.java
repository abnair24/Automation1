package com.guiPages.excelRead;


import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.guiPages.baseClasses.AutomationBase;

import jxl.Sheet;
import jxl.Workbook;

public class ExcelReader {
	private final static int FIRST_NAME= 0;
	private final static int LAST_NAME = 1;
	private final static int PHONE_NUMBER = 2;
	private final static int GENDER = 3 ;
	private final static int INDUSTRY =4;
	private final static int COUNTRY =5;
	private final static int EDUCATION = 6;
	private final static int COURSE =7;
	private final static int HOBBY = 8;
	private final static int FILE =9;
	private final static int ABOUT_ME =10;
			
	//public List<Object[]>userData = new ArrayList<Object[]>();
    	
	public static Iterator<Object[]> excelRead(int numberOfRecords) throws Exception {
		List<Object[]>userData= new ArrayList<Object[]>();
				
		Workbook wb= Workbook.getWorkbook(new File(AutomationBase.getExcelPath()));
		Sheet sheet =wb.getSheet(0);
		int col=sheet.getColumns();
		
		int rowsToBeFetched=numberOfRecords==0 ? sheet.getRows()-1 : numberOfRecords;
		
		for(int row =1; row<=rowsToBeFetched;row++)
		{
			UserDetails users = new UserDetails();
		    users.setFirstName(sheet.getCell(FIRST_NAME,row).getContents());
			users.setLastName(sheet.getCell(LAST_NAME,row).getContents());
			users.setPhoneNumber(sheet.getCell(PHONE_NUMBER,row).getContents());
			users.setGender(sheet.getCell(GENDER,row).getContents());
			users.setIndustry(sheet.getCell(INDUSTRY,row).getContents());
			users.setCountry(sheet.getCell(COUNTRY,row).getContents());
			users.setEducation(sheet.getCell(EDUCATION,row).getContents());
			users.setCourse(sheet.getCell(COURSE,row).getContents());
			users.setHobby(sheet.getCell(HOBBY,row).getContents());
			users.setFile(sheet.getCell(FILE,row).getContents());
			users.setAboutMe(sheet.getCell(ABOUT_ME,row).getContents());
			
			userData.add(new Object[]{users});
		}
		return userData.iterator();
	}
}
		
		
 