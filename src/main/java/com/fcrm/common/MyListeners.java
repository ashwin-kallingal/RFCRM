package com.fcrm.common;

import java.util.ArrayList;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.log4testng.Logger;

import com.fcrm.base.BaseTest;
import com.fcrm.utility.Excel;
import com.fcrm.utility.Utility;

public class MyListeners implements ITestListener
{
	public Logger log = Logger.getLogger(this.getClass());
	public static int passCount=0;
	public static int failCount=0;
	public static int skipCount=0;
	
	public static ArrayList<String> passList = new ArrayList<String>();
	public static ArrayList<String> failList = new ArrayList<String>();
	public static ArrayList<String> skipList = new ArrayList<String>();

	@Override
	public void onFinish(ITestContext result)
	{
		Reporter.log("Pass Count is:"+passCount,true);
		Reporter.log("Fail Count is:"+failCount,true);
		Reporter.log("Skip Count is:"+skipCount,true);	
		
		Reporter.log("Pass Test Cases:"+passList,true);
		Reporter.log("Fail Test Cases:"+failList,true);
		Reporter.log("Skip Test Cases:"+skipList,true);
	}

	@Override
	public void onStart(ITestContext result)
	{		
		Reporter.log("TestCase on Start :"+result.getName(),true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{		
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		Excel.setCellValue(result.getName(), "FAIL", Utility.getFormattedDateTime(), BaseTest.myBrowser);
		Utility.getDesktopScreenshot(AutomationConstant.SCREENSHOT_PATH);
		failList.add(result.getName());
		failCount++;		
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		Excel.setCellValue(result.getName(), "SKIP", Utility.getFormattedDateTime(), BaseTest.myBrowser);
		skipList.add(result.getName());
		skipCount++;		
	}

	@Override
	public void onTestStart(ITestResult result) 
	{		
		Reporter.log("Test Started for TestCase:"+result.getName(),true);
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		Excel.setCellValue(result.getName(), "PASS", Utility.getFormattedDateTime(), BaseTest.myBrowser);
		passList.add(result.getName());
		passCount++;		
	}
}