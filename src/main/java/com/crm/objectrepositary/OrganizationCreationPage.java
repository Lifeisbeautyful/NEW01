package com.crm.objectrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationCreationPage
{
	@FindBy(xpath="//input[@name=\"accountname\"]")
	private WebElement OrgTextBox;
	
	@FindBy(xpath="(//input[contains(@title,'Save [Alt+S]')])[1]")
	private WebElement SaveBtn;
	
	@FindBy(xpath="//textarea[@name='bill_street']")
	private WebElement Address;
	
	@FindBy(xpath="//span[contains(text(),'Organization Information')]")
	private WebElement Title;
	
	//2
	public OrganizationCreationPage(WebDriver driver)
	{
		PageFactory.initElements( driver, this);
	}
	
	//3
	public WebElement getOrgTextBox() {
		return OrgTextBox;
	}
	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	public WebElement getAddress() {
		return Address;
	}
	public WebElement getTitle() {
		return Title;
	}
}
