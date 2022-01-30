package com.automation.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
public static WebDriver startApplication(WebDriver localdriver,String BrowserName,String appURL)
{
	if(BrowserName.equals("Chrome"))
	{
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");//"chromedriver.exe");
		localdriver=new ChromeDriver();
		
	}
	else if(BrowserName.equals("Firefox"))
	{
		
	}
	else
	{
		System.out.println("not supported");
	}
	localdriver.get(appURL);
	localdriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	localdriver.manage().window().maximize();
	localdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	return localdriver;
}
public static void quitBrowser(WebDriver localdriver)
{
	localdriver.quit();
}

}
