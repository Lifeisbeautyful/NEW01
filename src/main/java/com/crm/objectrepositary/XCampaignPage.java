package com.crm.objectrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class XCampaignPage
{
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement add;
	
	public XCampaignPage(WebDriver driver) 
	{
		PageFactory.initElements( driver,this);
	}

	public WebElement getAdd() {
		return add;
	}
	
	

}
