package com.automation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;
import com.automation.utilities.BrowserFactory;
import com.automation.utilities.ExcelDataProvider;
import com.automation.utilities.Helper;

public class LoginTestCRM extends BaseClass{
	





@Test(priority=1)
	public void loginApp()
	{
		//added comment for github
	
		logger=	report.createTest("Login to webapp");	
	
		LoginPage loginObj=PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting application");
		
		loginObj.loginToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		logger.pass("Login done successfully");		
		//Helper.captureScreenshot(driver);
		
	}

/*
@Test(priority=2)
public void loginApp2()
{
	
	logger=	report.createTest("Logout");	

	logger.fail("Login failed");
	
	//Helper.captureScreenshot(driver);
	
}
*/

}
