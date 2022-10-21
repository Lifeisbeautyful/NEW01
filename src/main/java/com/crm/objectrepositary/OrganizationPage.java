package com.crm.objectrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage 
{

		@FindBy(xpath="//img[@title='Create Organization...']")
		private WebElement Add;
		
		@FindBy(xpath="//img[@title='Search in Organizations...']")
		private WebElement Search;
		
		public OrganizationPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		public WebElement getAdd()
		{
			return Add;
		}

		public WebElement getSearch() {
			return Search;
		}	
		
}
