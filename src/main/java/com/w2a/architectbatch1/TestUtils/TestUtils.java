package com.w2a.architectbatch1.TestUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;


import com.w2a.architectbatch1.baseSetup.TestSetUp;

public class TestUtils extends TestSetUp{

	public static String screenshotPath;
	public static String screenshotName;

	/*
	 * @description: Method to take capture screenshot
	 */
	public static void captureScreenshot() throws IOException {
		
		screenshotPath = "./Screenshots/";
		File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".png";

		
		
		FileUtils.copyFile(scrFile,
				new File(screenshotPath + screenshotName));


	}
	/*@DataProvider(name = "dp")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);//2
		int cols = excel.getColumnCount(sheetName);//2

		Object[][] data = new Object[rows - 1][1];//2 1

		Hashtable<String, String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) {

			table = new Hashtable<String, String>();

			for (int colNum = 0; colNum <cols; colNum++) {

				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}

		}

		// System.out.println(data);
		return data;

	}*/
	
	@DataProvider(name="dp")
	public  Object[][] getData(Method m) {

		int rows = excel.getRowCount(configProperty.getProperty("testSheetName"));
		System.out.println("Total rows are : " + rows);

		String testName = m.getName();

		// Find the test case start row

		int testCaseRowNum = 1;

		for (testCaseRowNum = 1; testCaseRowNum <= rows; testCaseRowNum++) {

			String testCaseName = excel.getCellData(configProperty.getProperty("testSheetName"), 0, testCaseRowNum);

			if (testCaseName.equalsIgnoreCase(testName))
				break;

		}

		System.out.println("Test case starts from row num: " + testCaseRowNum);

		// Checking total rows in test case

		int dataStartRowNum = testCaseRowNum + 2;

		int testRows = 0;
		while (!excel.getCellData(configProperty.getProperty("testSheetName"), 0, dataStartRowNum + testRows).equals("")) {

			testRows++;
		}

		System.out.println("Total rows of data are : " + testRows);

		// Checking total cols in test case

		int colStartColNum = testCaseRowNum + 1;
		int testCols = 0;

		while (!excel.getCellData(configProperty.getProperty("testSheetName"), testCols, colStartColNum).equals("")) {

			testCols++;

		}

		System.out.println("Total cols are : " + testCols);

		// Printing data

		Object[][] data = new Object[testRows][1];

		int i = 0;
		for (int rNum = dataStartRowNum; rNum < (dataStartRowNum + testRows); rNum++) {

			Hashtable<String, String> table = new Hashtable<String, String>();

			for (int cNum = 0; cNum < testCols; cNum++) {

				// System.out.println(excel.getCellData(Constants.DATA_SHEET,
				// cNum, rNum));
				String testData = excel.getCellData(configProperty.getProperty("testSheetName"), cNum, rNum);
				String colName = excel.getCellData(configProperty.getProperty("testSheetName"), cNum, colStartColNum);

				table.put(colName, testData);

			}

			data[i][0] = table;
			i++;

		}

		return data;
	}
	public static boolean isElementPresent(WebElement element)
	{
		if(element.isDisplayed())
			return true;
		else
			return false;
	}
	

}
