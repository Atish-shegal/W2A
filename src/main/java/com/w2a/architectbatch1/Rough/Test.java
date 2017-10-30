package com.w2a.architectbatch1.Rough;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {
	
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		WebDriver driver = new FirefoxDriver();
		System.out.println(driver);
		driver.close();
		driver.quit();
		System.out.print(driver);
		ThreadLocal local = new ThreadLocal();
		//local.fin
	}

}
