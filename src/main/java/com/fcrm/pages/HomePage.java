package com.fcrm.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.fcrm.base.BasePage;

public class HomePage extends BasePage
{
	
	@FindBy(xpath="//a[@href = 'https://www.freecrm.com/index.cfm?logout=1']")
	private WebElement logoutBtn;

	public HomePage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void logout()
	{
		driver.switchTo().frame("mainpanel");
		logoutBtn.sendKeys(Keys.ENTER);
	}

}
