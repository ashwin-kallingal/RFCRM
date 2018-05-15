package com.fcrm.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.fcrm.common.AutomationConstant;

public class Excel 
{
	public static int getRowCount(String path, String sheet)
	{
		int rc=0;
		
		try
		{
			rc= WorkbookFactory.create( new FileInputStream(path)).getSheet(sheet).getLastRowNum();
		}catch(Exception e)
		{
			e.printStackTrace();
		}		
		return rc;
	}
	
	public static String getCellValue(String path, String sheet, int r, int c)
	{
		String value="";
		
		try
		{
			value=WorkbookFactory.create(new FileInputStream(path)).getSheet(sheet).getRow(r).getCell(c).toString();
		}catch(Exception e)
		{
			e.printStackTrace();
		}		
		return value;
	}
	
	public static void setCellValue(String name, String status, String timeStamp, String browser)
	{
		try
		{
			FileInputStream fis = new FileInputStream(AutomationConstant.RESULT_FILE);
			Workbook wb = WorkbookFactory.create(fis);
			int rc=wb.getSheet(AutomationConstant.RESULT_SHEET).getLastRowNum();
			Row r = wb.getSheet(AutomationConstant.RESULT_SHEET).createRow(rc+1);
			
			r.createCell(0).setCellValue(name);
			r.createCell(1).setCellValue(status);
			r.createCell(2).setCellValue(timeStamp);
			r.createCell(3).setCellValue(browser);
			
			FileOutputStream fos = new FileOutputStream(AutomationConstant.RESULT_FILE);
			wb.write(fos);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}		
	}
}