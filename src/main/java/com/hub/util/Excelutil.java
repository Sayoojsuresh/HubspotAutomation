package com.hub.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelutil {
	
	static Workbook book;
	static Sheet sheet;
	public static String Testdatapath= "C://Users//Sayooj Suresh//workspace//Hubspot//src//main//java//com//hub//testdata//TestData.xlsx";
	
	public static Object[][] getdata(String SheetName)
	{
		try {
			FileInputStream file=new FileInputStream(Testdatapath);
			 
				
			book=WorkbookFactory.create(file);
		sheet=book.getSheet(SheetName);
		Object data[][]=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
			}
		return data;
		}
			catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			return null;
	}
	
}
