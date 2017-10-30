package com.w2a.architectbatch1.TestUtils;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;

import com.w2a.architectbatch1.baseSetup.TestSetUp;

public class TestUtils extends TestSetUp{

	
	@DataProvider(name = "dp")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);//2
		int cols = excel.getColumnCount(sheetName);//2

		Object[][] data = new Object[rows - 1][1];//2 1

		Hashtable<String, String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) {

			table = new Hashtable<String, String>();

			for (int colNum = 0; colNum < cols; colNum++) {

				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}

		}

		// System.out.println(data);
		return data;

	}
}
