package com.w2a.architectbatch1.Rough;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridExample {
	public static void main(String[] args) throws MalformedURLException {
		
		
		String browser="ff";
		
		String chromedriver_path="E:\\chromedriver.exe";
		DesiredCapabilities cap=null;
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",chromedriver_path);
			cap=DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.ANY);
			cap.setCapability("chrome.binary",chromedriver_path);
			
		}
		else if(browser.equalsIgnoreCase("ff"))
		{
			
			cap=DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.ANY);
			
		}
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		driver.get("http://gmail.com");
		driver.quit();
	
	}

}
