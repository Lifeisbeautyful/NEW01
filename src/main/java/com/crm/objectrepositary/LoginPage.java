package com.crm.objectrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage    //POM 
{
	@FindBy(name="user_name")
	private WebElement UserName;
	
	@FindBy(name="user_password")
	private WebElement PassWord;
	
	@FindBy(id="submitButton")
	private WebElement login;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getUsername() {
		return UserName;
	}
	public WebElement getPassword() {
		return PassWord;
	}
	public WebElement getLogin() {
		return login;
	}
	
	public void login(String Username,String Password)
	{
		UserName.sendKeys(Username);
		PassWord.sendKeys(Password);
		login.click();
	}
	
}