package com.w2a.architectbatch1.testCases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.w2a.architectbatch1.Pages.FacebookHomePage;
import com.w2a.architectbatch1.Pages.FacebookLandingPage;
import com.w2a.architectbatch1.TestUtils.DriverManager;
import com.w2a.architectbatch1.TestUtils.TestUtils;
import com.w2a.architectbatch1.baseSetup.TestSetUp;

public class TestCase1 extends TestSetUp{

	/*@Test(dataProviderClass=TestUtils.class,dataProvider="dp")
	public void tc_01(Hashtable<String,String> data) {
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

	}*/
	@Test(dataProviderClass=TestUtils.class,dataProvider="dp")
	public void tc_02(Hashtable<String, String> data) {
		
		FacebookLandingPage fbLandingPage=new FacebookLandingPage().open();
		
		FacebookHomePage homepage=fbLandingPage.doLoginWithValidCredentials(data.get("username"),data.get("password"));
		
	}

	

}
