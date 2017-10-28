package com.w2a.architectbatch1.testCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.w2a.architectbatch1.baseSetup.TestSetUp;

public class TestCase2 extends TestSetUp{
	@Test
	public void tc_03() {
		
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
