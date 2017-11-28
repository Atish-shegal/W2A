package com.w2a.architectbatch1.testCases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.w2a.architectbatch1.Pages.FacebookHomePage;
import com.w2a.architectbatch1.Pages.facebookLandingPage;
import com.w2a.architectbatch1.TestUtils.DriverManager;
import com.w2a.architectbatch1.TestUtils.TestUtils;
import com.w2a.architectbatch1.baseSetup.TestSetUp;
import com.w2a.architectbatch1.customAnnotation.TestCaseId;

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
	
	@TestCaseId(testCaseId="tc_01")
	@Test(dataProviderClass=TestUtils.class,dataProvider="dp")
	public void tc_02(Hashtable<String, String> data) {
		
		facebookLandingPage fbLandingPage=new facebookLandingPage().open();
		
		FacebookHomePage fbHomePage=fbLandingPage.doLoginWithValidCredentials(data.get("username"), data.get("password"));
		
	}

	

}
