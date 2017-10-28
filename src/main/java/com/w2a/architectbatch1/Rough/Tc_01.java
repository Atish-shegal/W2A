package com.w2a.architectbatch1.Rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Tc_01 {
	
	
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.gotomeeting.com");
		WebElement firstName=driver.findElement(By.xpath("//input[@name='firstName']"));
		firstName.sendKeys("Rahul");
		
		
		
	}

}
