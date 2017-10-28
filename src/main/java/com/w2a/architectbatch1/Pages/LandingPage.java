package com.w2a.architectbatch1.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {
	
	@FindBy(xpath="//input[@name='firstName']")
	public static WebElement firstName;
	
	
	@FindBy(xpath="//input[@name='lastName']")
	public static WebElement lastName;

	
	public void doLoginWithValidDetails()
	{
		firstName.sendKeys("");
		
	}
	public void doLoginWithInValidDetails()
	{
		
	}
	public void doLoginWithoutuserName()
	{
		
	}
}
