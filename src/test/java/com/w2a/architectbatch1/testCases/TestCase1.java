package com.w2a.architectbatch1.testCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.w2a.architectbatch1.TestUtils.PropertyFileManager;
import com.w2a.architectbatch1.baseSetup.TestSetUp;

public class TestCase1 extends TestSetUp{

	@Test
	public void tc_01() {
		
		driver.get(configProperty.getProperty("application.url.w2a"));
		driver.findElement(By.linkText("MEMBER LOGIN")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Test
	public void tc_02() {
		
		driver.get("https://www.facebook.com");
		driver.findElement(By.name("email")).sendKeys("fafdf");
		driver.findElement(By.name("pass")).sendKeys("fafdf");
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
