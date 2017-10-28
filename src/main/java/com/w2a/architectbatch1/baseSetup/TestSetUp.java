package com.w2a.architectbatch1.baseSetup;

import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.w2a.architectbatch1.TestUtils.ExcelReader;
import com.w2a.architectbatch1.TestUtils.ExtentManager;
import com.w2a.architectbatch1.TestUtils.PropertyFileManager;

public class TestSetUp {

	protected static Properties configProperty;
	public ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\simple.xlsx");
	public static ExtentReports extent;
	public static ThreadLocal parentTest = new ThreadLocal();
	public static ThreadLocal test = new ThreadLocal();

	protected   WebDriver driver=null;
	@BeforeSuite
	public void setUp() {

		PropertyFileManager.setConfigFilePath(
				System.getProperty("user.dir") + "\\src\\test\\resources\\propertyFiles\\config.properties");
		//extent = ExtentManager.GetExtent();

	}

	@BeforeTest
	public void beforeTest() {

	}

	@BeforeClass
	public void beforeClass() {
/*
		ExtentTest parent = extent.createTest(getClass().getName());
		parentTest.set(parent);*/
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		WebDriver driver = null;
		System.out.println("executing beforeMethod");
		System.out.println("Driver-->"+driver);
		if(driver==null){
			
			driver= new FirefoxDriver();
			configProperty=PropertyFileManager.createConfigFileProperty();
			
		}

		//ExtentTest child = ((ExtentTest) parentTest.get()).createNode(method.getName());
		//test.set(child);
		

	}

	@AfterMethod
	public void afterMethod() {

		
		driver.quit();
		driver=null;
		extent.flush();
		
	}

	@AfterClass
	public void afterClass() {

	}

	@AfterTest
	public void afterTest() {

	}

	@AfterSuite
	public void tearDown() {

	}

}
