package com.w2a.architectbatch1.Rough;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Rough {
	

	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Before Suite executed");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("After Suite executed");
	}
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Before Test executed");
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("After Test executed");
	}
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Before Class executed");
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("After CLass executed");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method executed");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method executed");
	}
	
	
	
	
	@Test(dataProvider="SearchProvider")
	public void testCase(String a, String b)
	{
		System.out.println("TextCAse executed");
	}
	 @DataProvider(name="SearchProvider")
	    public Object[][] getDataFromDataprovider(){
		 System.out.println("Dataprovide executed");
	    return new Object[][] 
	    	{
	            { "Guru99", "India" },
	            { "Krishna", "UK" },
	            { "Bhupesh", "USA" }
	        };

	    }


}
