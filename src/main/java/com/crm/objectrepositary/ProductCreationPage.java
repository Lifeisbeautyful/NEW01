package com.crm.objectrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCreationPage
{
	@FindBy(xpath="//input[@name='productname']")
	private WebElement ProductBox;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement Save;
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement Title;
	
	@FindBy(xpath="//input[@name='Delete']")
	private WebElement Delete;
	
	public ProductCreationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getTitle() {
		return Title;
	}

	public WebElement getProductBox() {
		return ProductBox;
	}

	public WebElement getSave() {
		return Save;
	}
	
	public WebElement getDelete() {
		return Delete;
	}
}
