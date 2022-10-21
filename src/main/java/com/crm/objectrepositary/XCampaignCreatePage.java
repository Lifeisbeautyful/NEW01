package com.crm.objectrepositary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class XCampaignCreatePage 
{
	@FindBy(name="campaignname")
	private WebElement CampaignTextBox;
	
	@FindBy(xpath="//input[contains(@class,'crmButton small save')]")
	private WebElement Save;
	
	@FindBy(xpath="//img[@title='Select' ]")
	private WebElement addProduct;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement Title;
	
	@FindBy(xpath="By.id(\"search_txt\")")
	private WebElement SearchBox;
	
	@FindBy(xpath="By.name(\"search\")")
	private WebElement Search;
	
	public XCampaignCreatePage(WebDriver driver) 
	{
		PageFactory.initElements( driver,this);
	}

	public WebElement getCampaignTextBox() {
		return CampaignTextBox;
	}
	
	public WebElement getSave() {
		return Save;
	}
	
	public WebElement getTitle() {
		return Title;
	}
	
	public WebElement getAddProduct() {
		return addProduct;
	}
	
	public WebElement getSearchBox() {
		return SearchBox;
	}

	public WebElement getSearch() {
		return Search;
	}

}
