package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class LoginPage {

	WebDriver driver;
	
	//Initialize webdriver
	public LoginPage(WebDriver localdriver)
	{
		this.driver=localdriver;
	}
	
	
	//Locators
	@FindBy(name="email") WebElement usernameWebElement;
	
	@FindBy(name="password") WebElement passwordWebElement;
	
	@FindBy(xpath="//button[@type='submit']") WebElement submitWebElement;
	
	public void loginToCRM(String usernameData,String passwordData)
	{
		try
		{
			Thread.sleep(2000);
		}
		catch(InterruptedException e)
		{
			
		}
		
		usernameWebElement.sendKeys(usernameData);
		passwordWebElement.sendKeys(passwordData);
		submitWebElement.click();
	}
}
