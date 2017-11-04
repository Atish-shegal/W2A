package com.w2a.architectbatch1.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FacebookLandingPage extends BasePage{
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="pass")
	private WebElement password;
	
	@FindBy(linkText="Log In")
	private WebElement loginButton;

	@Override
	public ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(loginButton);
	}
	
	public FacebookLandingPage open()
	{
		return (FacebookLandingPage)openPage(FacebookLandingPage.class);
	}
	
	public FacebookHomePage doLoginWithValidCredentials(String userName,String pass)
	{
	
		email.sendKeys(userName);
		password.sendKeys(pass);
		loginButton.click();
		return new FacebookHomePage().open();
	}
	

}
