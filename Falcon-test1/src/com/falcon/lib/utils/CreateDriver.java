package com.falcon.lib.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CreateDriver {
	
	public static WebDriver getBrowserInstance()
	{
		WebDriver driver = null;
		String browser = DataHandlers.getDataFromProperties("configuration", "browser");
		String url = DataHandlers.getDataFromProperties("configuration", "url");
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./browser-servers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", "./browser-servers/iedriver.exe");
			driver = new InternetExplorerDriver();
		}
		else
		{
			System.out.println("....invalid browser option check configuration properties"+"file in config-data folder");
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if(url.equalsIgnoreCase("url"))
		{
		driver.get("https://demo.actitime.com/login.do");
		}
		else
		{
			driver.get("https://localhost");
		}
		return driver;
		
	}
	
}
