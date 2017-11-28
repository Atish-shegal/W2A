package com.w2a.architectbatch1.baseSetup;

import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
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
import com.aventstack.extentreports.Status;
import com.w2a.architectbatch1.TestUtils.DriverFactory;
import com.w2a.architectbatch1.TestUtils.DriverManager;
import com.w2a.architectbatch1.TestUtils.ExcelReader;
import com.w2a.architectbatch1.TestUtils.ExtentManager;
import com.w2a.architectbatch1.TestUtils.PropertyFileManager;
import com.w2a.architectbatch1.customAnnotation.TestCaseId;

public class TestSetUp {

	protected static Properties configProperty;
	public ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\simple.xlsx");
	public static ExtentReports extent;
	public static ThreadLocal<ExtentTest> classLevelReport = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentTest> testLevelReport = new ThreadLocal<ExtentTest>();

	protected WebDriver driver = null;

	@BeforeSuite
	public void setUp() {

		PropertyFileManager.setConfigFilePath(
				System.getProperty("user.dir") + "\\src\\test\\resources\\propertyFiles\\config.properties");
		DriverFactory.setChromeExeFilePath("");
		DriverFactory.setIeExeFilePath("");

		extent = ExtentManager.GetExtent();

	}

	@BeforeTest
	public void beforeTest() {

	}

	@BeforeClass
	public synchronized void beforeClass() {

		ExtentTest parent = extent.createTest(getClass().getSimpleName());
		classLevelReport.set(parent);
		configProperty = PropertyFileManager.createConfigFileProperty();
	}

	@BeforeMethod
	public synchronized void beforeMethod(Method method) {
		TestCaseId testCaseId=method.getAnnotation(TestCaseId.class);
		System.out.println(testCaseId.testCaseId());
		//String browser=getBrowserName(testCaseId.testCaseId())
		WebDriver driver = null;
		System.out.println("executing beforeMethod");
		System.out.println("Driver-->" + driver);
		if (driver == null) {
			//configProperty = PropertyFileManager.createConfigFileProperty();
			driver = DriverFactory.createDriverInstance(configProperty.getProperty("browser"));
			DriverManager.getDriver().navigate().to(configProperty.getProperty("testSiteUrl"));

		}

		
		/*ExtentTest child = classLevelReport.get().createNode(method.getName());
		testLevelReport.set(child);
		testLevelReport.get().log(Status.INFO, "Execution of Test Case-"+" "+method.getName()+" started");
*/
	}

	@AfterMethod
	public synchronized void afterMethod(ITestResult result) {
	/*	 if (result.getStatus() == ITestResult.FAILURE)
			 testLevelReport.get().fail(result.getThrowable());
	        else if (result.getStatus() == ITestResult.SKIP)
	        	testLevelReport.get().skip(result.getThrowable());
	        else
	        	testLevelReport.get().pass("Test passed");*/

	        extent.flush();
		
		DriverManager.getDriver().quit();

	}

	@AfterClass
	public void afterClass() {

	}

	@AfterTest
	public void afterTest() {

	}

	@AfterSuite
	public void tearDown() {
	//	extent.flush();
	}

}
