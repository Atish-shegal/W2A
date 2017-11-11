package com.w2a.architectbatch1.Rough;

import com.w2a.architectbatch1.TestUtils.ExcelReader;

public class TestDataRough {
	
	public static void main(String[] args) {
		
		ExcelReader excel= new ExcelReader("E:\\WorkSpace\\Architectbatch1\\src\\test\\resources\\testdata\\simple.xlsx");
		
		String sheetName="testData";
		
		int totalROws=excel.getRowCount(sheetName);
		System.out.println(excel.getRowCount(sheetName));
		String testCaseName="tc_01";
		
		int testCaseRowStart=1;
		
		for(;testCaseRowStart<=totalROws;testCaseRowStart++)
		{
			if(excel.getCellData(sheetName, 0, testCaseRowStart).equals(testCaseName))
			{
				break;
			}
		}
		System.out.println("My Testcase: "+testCaseName+" starts from row num: "+testCaseRowStart);
		
		int testDataRowStart=testCaseRowStart+2;
		int datarows=0;
		while(!excel.getCellData(sheetName, 0, testDataRowStart+datarows).equals(""))
		{
			//testDataRowStart++;
			datarows++;
		}
			
		System.out.println("Total no of rows:"+datarows);
		
		int columnstartfrom=testCaseRowStart+1;
		int noOfCells=0;
		while(!excel.getCellData(sheetName, noOfCells, columnstartfrom).equals(""))
		{
			//testDataRowStart++;
			noOfCells++;
		}
		System.out.println("Total no of cells:"+ noOfCells);
			
		
	}

}
