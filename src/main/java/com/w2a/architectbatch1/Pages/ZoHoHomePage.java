package com.w2a.architectbatch1.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ZoHoHomePage extends BasePage{

	@FindBy(xpath="//div[text(),'CRM']")
	public WebElement crmLink;

	@Override
	public ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(crmLink);
	}

}
