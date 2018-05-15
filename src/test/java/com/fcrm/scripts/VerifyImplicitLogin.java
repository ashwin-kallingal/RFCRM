package com.fcrm.scripts;

import org.testng.annotations.Test;
import com.fcrm.base.BaseTest;

public class VerifyImplicitLogin extends BaseTest
{	
	public VerifyImplicitLogin()
	{
		AutoLoginRequired=true;
		AutoLogoutRequired=true;
	}
	
	@Test(priority=2)
	
	public void testImplicitLogin()
	{
		System.out.println("Implicit Login Logout Successfull");
		
	}
}