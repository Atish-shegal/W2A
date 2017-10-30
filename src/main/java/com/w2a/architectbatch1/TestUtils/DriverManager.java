package com.w2a.architectbatch1.TestUtils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(WebDriver  webdriver) {
		DriverManager.driver.set( webdriver);
	}

	
	public static void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
		
	}
	public static void setImplecitWait(WebDriver driver, int time)
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
}
