package com.w2a.architectbatch1.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.w2a.architectbatch1.TestUtils.DriverManager;

public abstract class BasePage<T> {

	
	public WebDriver driver;
	public int PAGE_LOAD_TIMEOUT=30;
	public int AJAX_LOAD_TIMEOUT=10;
	
	public BasePage()
	{
		driver=DriverManager.getDriver();
	}
	
	
	
	public T openPage(Class<T> clazz)
	{
		T page=null;
		
		//

		AjaxElementLocatorFactory ajaxElemFactory = new AjaxElementLocatorFactory(DriverManager.getDriver(), AJAX_LOAD_TIMEOUT);
		
		page=PageFactory.initElements(DriverManager.getDriver(), clazz);
		PageFactory.initElements(ajaxElemFactory, page);
		
		ExpectedCondition expectedCondition=((BasePage) page).getPageLoadCondition();
		
		waitForPageToLoad(expectedCondition);
		
		return page;
		
	}
	
	public abstract ExpectedCondition getPageLoadCondition();
	
	public void waitForPageToLoad(ExpectedCondition expectedCond)
	{
		Wait  wait= new WebDriverWait(DriverManager.getDriver(), PAGE_LOAD_TIMEOUT);
		wait.until(expectedCond);
		
	}
	
}
