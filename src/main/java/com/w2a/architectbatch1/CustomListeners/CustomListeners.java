package com.w2a.architectbatch1.CustomListeners;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.w2a.architectbatch1.TestUtils.TestUtils;
import com.w2a.architectbatch1.baseSetup.TestSetUp;

public class CustomListeners extends TestSetUp implements ITestListener, ISuiteListener {

	public void onFinish(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		

		try {
			TestUtils.captureScreenshot();
		} catch (IOException e) {

		}

		StringWriter sw = new StringWriter();
		String exceptionMessage = "";
		exceptionMessage = arg0.getThrowable().getClass().toString();
		System.out.println(exceptionMessage);
		// exceptionMessage = arg0.getThrowable().getMessage();
		exceptionMessage = exceptionMessage + " " + Arrays.toString(arg0.getThrowable().getStackTrace());

		//System.out.println(exceptionMessage);
		testLevelReport.get().log(Status.FAIL,
				"<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
						+ "</font>" + "</b >" + "</summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details>");

		
		try {

			testLevelReport.get().fail("<b>" + "<font color=" + "red>" + "ScreenShot of failure" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(TestUtils.screenshotPath + TestUtils.screenshotName)
							.build());
		} catch (IOException e) {

		}
		String text = "This Test case got failed";
		Markup m = MarkupHelper.createLabel(text, ExtentColor.RED);
		testLevelReport.get().log(Status.FAIL, m);
		extent.flush();


		
	}

	public void onTestSkipped(ITestResult arg0) {
		String text = "This Test case got Skipped";
		Markup m = MarkupHelper.createLabel(text, ExtentColor.AMBER);
		testLevelReport.get().log(Status.SKIP, m);
		//	testLevelReport.get().log(Status.SKIP, "TestCase- " + arg0.getName() + " Skipped");
		extent.flush();
	}

	public void onTestStart(ITestResult arg0) {
		

		ITestNGMethod testNGMethod = arg0.getMethod();

		//test = new ExtentManager().createTest(arg0.getName(), testNGMethod.getDescription());
		//setExtentTest(test);
		
		ExtentTest t= classLevelReport.get().createNode(arg0.getMethod().getMethodName());
		testLevelReport.set(t);
		
		
		//getExtentTest().log(Status.INFO, "<b>" + "Starting Test- " + arg0.getName() + " Execution" + "<b>");
		testLevelReport.get().log(Status.INFO, "<b>" + "Starting Test- " + arg0.getName() + " Execution" + "</b>");
		
	}

	public void onTestSuccess(ITestResult arg0) {
		String text = "TestCase- " + arg0.getName() + " PASS";
		Markup m = MarkupHelper.createLabel(text, ExtentColor.GREEN);
		testLevelReport.get().log(Status.PASS, m);
		extent.flush();
		
	}

	
}
