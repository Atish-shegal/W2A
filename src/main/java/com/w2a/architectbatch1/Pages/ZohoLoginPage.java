package com.w2a.architectbatch1.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ZohoLoginPage extends BasePage{

	@FindBy(id="lid")
	public WebElement userName;
	
	@FindBy(id="pwd")
	public WebElement password;
	
	@FindBy(id="signin_submit")
	public WebElement signIn;
	
	@FindBy(id="msgpanel")
	public WebElement errorMessage;
	
	public ZoHoHomePage doLoginWithValidCredentials(String email,String pass)
	{
		userName.sendKeys(email);
		password.sendKeys(pass);
		signIn.click();
		return (ZoHoHomePage)openPage(ZoHoHomePage.class);
	}
	public ZohoLoginPage doLoginWithInValidCredentials(String email,String pass)
	{
		userName.sendKeys(email);
		password.sendKeys(pass);
		signIn.click();
		return this;
	}
	@Override
	public ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(userName);
	}

}
