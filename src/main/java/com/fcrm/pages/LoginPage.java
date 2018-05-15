package com.fcrm.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.fcrm.base.BasePage;

public class LoginPage extends BasePage
{	
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//input[@class = 'btn btn-small']")
	private WebElement loginBtn;
	

	public LoginPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void login(String un, String pw)
	{
		username.sendKeys(un);
		password.sendKeys(pw);
		loginBtn.sendKeys(Keys.ENTER);
	}
}