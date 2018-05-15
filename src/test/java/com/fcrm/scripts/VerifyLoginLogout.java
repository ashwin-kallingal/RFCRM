package com.fcrm.scripts;

import org.testng.annotations.Test;
import com.fcrm.base.BaseTest;
import com.fcrm.pages.HomePage;
import com.fcrm.pages.LoginPage;
import com.fcrm.utility.Excel;

public class VerifyLoginLogout extends BaseTest
{	
	public VerifyLoginLogout()
	{
		AutoLoginRequired=false;
		AutoLogoutRequired=false;
	}
	
	@Test(priority=1)
	
	public void testExplicitLogin()
	{
		String usn = Excel.getCellValue(INPUT_FILE, INPUT_SHEET, 1, 0);
		String pwd = Excel.getCellValue(INPUT_FILE, INPUT_SHEET, 1, 1);
		
		LoginPage lp = new LoginPage(driver);
		lp.login(usn, pwd);
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) 
		{			
			e.printStackTrace();
		}
		
		HomePage hp = new HomePage(driver);
		hp.logout();	
		
		System.out.println("Explicit Login Logout Successfull");	
	}
}