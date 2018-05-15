package com.fcrm.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.fcrm.common.AutomationConstant;
import com.fcrm.utility.Property;

public class BasePage 
{	
	public Logger log = Logger.getLogger(this.getClass());
	public WebDriver driver;
	public String config;
	public long timeout;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		config=AutomationConstant.CONFIG_FILE;
		timeout=Long.parseLong(Property.getPropertyValue(AutomationConstant.CONFIG_FILE, "EXPLICIT"));
	}
	
	public void waitForElementPresent(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void verifyURLIs(String expURL)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.urlToBe(expURL));
	}
	
	public void verifyURLHas(String expURL)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.urlContains(expURL));
	}
}