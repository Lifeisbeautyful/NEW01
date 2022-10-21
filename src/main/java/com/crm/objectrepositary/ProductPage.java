package com.crm.objectrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage
{
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement add;
	
	@FindBy(xpath="//img[@title='Search in Products...']")
	private WebElement Search;
	
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getadd() {
		return add;
	}

	public WebElement getSearch() {
		return Search;
	}
}
