package com.automation.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	//to handle screenshots, frames, windows, sync issue, java script executor
	
	public static String captureScreenshot(WebDriver driver)
	{
		//an interface
	File fileSrc=	((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String screenShotPath=System.getProperty("user.dir")+"/Screenshots/Prototype_"+getCurrentDateTime()+".png";
	try {
		FileHandler.copy(fileSrc,new File(screenShotPath));
	
	System.out.println("screenshot captured");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Unable to capture screenshot"+e.getMessage());
	}
	return screenShotPath;
	}
	
	
	public static String getCurrentDateTime()
	{
	DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
	
	Date curentDate=new Date();
	return customFormat.format(curentDate); 
	}
	public void handleFrames()
	{
		
	}
	
	
}
