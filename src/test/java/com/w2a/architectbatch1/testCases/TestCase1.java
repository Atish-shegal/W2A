package com.w2a.architectbatch1.testCases;

import org.testng.annotations.Test;

import com.w2a.architectbatch1.Pages.FacebookHomePage;
import com.w2a.architectbatch1.Pages.FacebookLandingPage;
import com.w2a.architectbatch1.baseSetup.TestSetUp;

public class TestCase1 extends TestSetUp{

	/*@Test
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

	}*/
	@Test
	public void tc_02() {
		
		FacebookLandingPage fbLandingPage=new FacebookLandingPage().open();
		
		FacebookHomePage homepage=fbLandingPage.doLoginWithValidCredentials("918744954505","qwerty@123");
		
	}

	

}
