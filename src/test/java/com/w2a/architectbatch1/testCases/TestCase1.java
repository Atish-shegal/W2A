package com.w2a.architectbatch1.testCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.w2a.architectbatch1.TestUtils.DriverManager;
import com.w2a.architectbatch1.TestUtils.PropertyFileManager;
import com.w2a.architectbatch1.baseSetup.TestSetUp;

public class TestCase1 extends TestSetUp{

	@Test
	public void tc_01() {
		testLevelReport.get().assignAuthor("Rahul");
		testLevelReport.get().assignCategory("Sanity");
		DriverManager.getDriver().get(configProperty.getProperty("application.url.w2a"));
		testLevelReport.get().log(Status.INFO,"navigated to LoginPage");
		DriverManager.getDriver().findElement(By.linkText("MEMBER LOGIN")).click();
		testLevelReport.get().log(Status.INFO,"clicked on to Member login");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Test
	public void tc_02() {
		
		DriverManager.getDriver().get("https://www.facebook.com");
		DriverManager.getDriver().findElement(By.name("email")).sendKeys("rahul1111111");
		DriverManager.getDriver().findElement(By.name("pass")).sendKeys("fafdf");
		DriverManager.getDriver().findElement(By.xpath("//input[@value='Log In']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
