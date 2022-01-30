package com.automation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.automation.utilities.BrowserFactory;
import com.automation.utilities.ConfigDataProvider;
import com.automation.utilities.ExcelDataProvider;
import com.automation.utilities.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	//Setup Excel data provider before test starts
	@BeforeSuite
	public void SetupSuite()
	{
		 Reporter.log("Setting up reports and test getting ready", true);
		
		 
		 excel=new ExcelDataProvider();
		 config=new ConfigDataProvider();
		 
		 //get current working directory which is of eclipse in system.getproperty function
		 ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Prototype1Report_"+Helper.getCurrentDateTime()+".html"));
		 
		 report=new ExtentReports();
		 report.attachReporter(extent);
		 
		 Reporter.log("config done, test can start", true);
	}
	
	//Before running the class LoginTestCRM, first do this
	//setup browser
	
	//value under parameter should match with pom.xml under ${}
	
	@BeforeClass	
	@Parameters({"browser","urlToTest"})
	public void Setup(String browser,String url)
	{
		 Reporter.log("Start browser and get app ready", true);
		//driver=BrowserFactory.startApplication(driver, config.getBrowser(), config.getTestURL());
		
		 driver=BrowserFactory.startApplication(driver, browser, url);
		 
		 //System.out.println("Driver tile"+driver.getTitle());

		 Reporter.log("browser is up and running", true);
	}
	
	//After running this class do this
	@AfterClass
	public void Close()
	{
		BrowserFactory.quitBrowser(driver);
	}
	
	//when to run below code after every test case
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		 Reporter.log("test is about to end", true);
		if(result.getStatus()==ITestResult.FAILURE) //an interface , it has all info after test case run
		{
			///Helper.captureScreenshot(driver);
			logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.skip("Test skip", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		//adding multiple test case data if present in single report
		report.flush();
		
		 Reporter.log("test completed, reports generated", true);
	}
}
