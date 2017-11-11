package com.w2a.architectbatch1.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class facebookLandingPage extends BasePage {

	
	@FindBy(id="email")
	public WebElement userEmail;
	
	@FindBy(id="pass")
	public WebElement userPassword;
	
	
	@FindBy(xpath="//input[@value='Log In']")
	public WebElement loginButton;
	
	public facebookLandingPage open()
	{
		return (facebookLandingPage)openPage(facebookLandingPage.class);
	}
	
	public FacebookHomePage doLoginWithValidCredentials(String email,String pass)
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(pass);
		loginButton.click();
		
		return (FacebookHomePage) openPage(FacebookHomePage.class);
	}
	
	
	
	
	@Override
	public ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(loginButton);
	}

}
