package com.w2a.architectbatch1.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.w2a.architectbatch1.TestUtils.DriverManager;

public abstract class BasePage<T> {
	
	
	public WebDriver driver;
	public int PAGE_LOAD_TIMEOUT=20;
	public int AJAX_LOAD_TIMEOUT=10;

	
	public T openPage(Class<T> clazz)
	{
		T page=null;
		AjaxElementLocatorFactory ajaxLocatorFactory=new AjaxElementLocatorFactory(DriverManager.getDriver(), AJAX_LOAD_TIMEOUT);
		page=PageFactory.initElements(DriverManager.getDriver(), clazz);
		PageFactory.initElements(ajaxLocatorFactory, page);
		
		ExpectedCondition pageLoadCondtion=	((BasePage) page).getPageLoadCondition();
		waitForPageLoad(pageLoadCondtion);
		return page;
		
		
		
	}
	
	public abstract ExpectedCondition getPageLoadCondition();
	
	public void waitForPageLoad(ExpectedCondition expectedCondition)
	{
		 WebDriverWait wait= new WebDriverWait(DriverManager.getDriver(), PAGE_LOAD_TIMEOUT);
		 wait.until(expectedCondition);
	}
	
}
