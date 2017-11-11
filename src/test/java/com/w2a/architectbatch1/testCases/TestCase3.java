package com.w2a.architectbatch1.testCases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.architectbatch1.Pages.ZoHoHomePage;
import com.w2a.architectbatch1.Pages.ZohoLandingPage;
import com.w2a.architectbatch1.Pages.ZohoLoginPage;
import com.w2a.architectbatch1.TestUtils.TestUtils;
import com.w2a.architectbatch1.baseSetup.TestSetUp;

public class TestCase3 extends TestSetUp{
	
	@Test
	public void verifyLoginWithValidCred(Hashtable<String,String> data)
	{
		ZohoLandingPage landingPage= new ZohoLandingPage().open();
		
		ZohoLoginPage loginPage=landingPage.clickOnLogin();
		ZoHoHomePage homePage=loginPage.doLoginWithValidCredentials(data.get("username"), data.get("password"));
	    Assert.assertTrue(TestUtils.isElementPresent(homePage.crmLink));
	}

}
