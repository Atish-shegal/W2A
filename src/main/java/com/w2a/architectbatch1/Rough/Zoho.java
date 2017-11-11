package com.w2a.architectbatch1.Rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Zoho {
	
	public static void main(String[] args) {
		WebDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.zoho.com/");
		driver.findElement(By.className("signup")).click();
		driver.findElement(By.id("emailfield")).sendKeys("abhigya.jha@gmail.com");
		driver.findElement(By.id("password")).sendKeys("qwerty123");
		driver.findElement(By.id("signupbtn")).click();
		
	}

}
