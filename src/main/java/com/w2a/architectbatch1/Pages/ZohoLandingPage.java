package com.w2a.architectbatch1.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ZohoLandingPage extends BasePage{

	
	
	@FindBy(className="signin")
	public WebElement loginButton;
	
	@FindBy(className="signup")
	public WebElement signupButton;
	
	public ZohoLoginPage clickOnLogin()
	{
		loginButton.click();
		return (ZohoLoginPage) openPage(ZohoLoginPage.class);
		
	}
	public ZohoSignUpPage clickOnSignUp()
	{
		signupButton.click();
		return (ZohoSignUpPage) openPage(ZohoSignUpPage.class);
		
	}
	
	@Override
	public ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(loginButton);
	}
	
	
	public ZohoLandingPage open()
	{
		return (ZohoLandingPage)openPage(ZohoLandingPage.class);
	}
	

}
