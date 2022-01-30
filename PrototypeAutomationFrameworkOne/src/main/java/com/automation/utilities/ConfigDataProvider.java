package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
Properties property;
	public ConfigDataProvider()
	{
		File src=new File("./Config/Config.properties");
		
		try {
			FileInputStream fs=new FileInputStream(src);
			
			property=new Properties();
			
			property.load(fs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Not able to load config file"+e.getMessage());
		} 
	}
	
	public String getDataFromConfig(String keytoSearch)
	{
		return property.getProperty(keytoSearch);
	}
	public String getBrowser()
	{
		return property.getProperty("Browser");
	}
	public String getTestURL()
	{
		return property.getProperty("qaURL");
	}
}
