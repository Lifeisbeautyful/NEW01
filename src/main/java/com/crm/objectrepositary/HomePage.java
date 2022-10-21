package com.crm.objectrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	@FindBy(xpath="//a[@href='index.php?module=Accounts&action=index']")
	private WebElement Organization;
	
	@FindBy(xpath="//a[normalize-space()='Products']")
	private WebElement Product;
	
	@FindBy(xpath="//a[normalize-space()='Contacts']")
	private WebElement Contact;
	
	@FindBy(xpath="//a[@href='javascript:;'][normalize-space()='More']")
	private WebElement More;
	
	@FindBy(xpath="//a[@name='Campaigns']")
	private WebElement Campaigns;
	
	@FindBy(xpath="//a[@name='Reports']")
	private WebElement Report;
	
	@FindBy(xpath="//a[@name='Invoice']")
	private WebElement Invoice;
	
	@FindBy(xpath="//a[@name='Quotes']")
	private WebElement Quote;
	
	@FindBy(xpath="//a[@name='Vendors']")
	private WebElement Vendors;
	
	@FindBy(xpath="//a[@name='Project Tasks']")
	private WebElement Tesks;
	
	@FindBy(xpath="//a[@href='index.php?module=HelpDesk&action=index']")
	private WebElement Tickets;
	
	@FindBy(xpath="//a[normalize-space()='Documents']")
	private WebElement Documents;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement Administrator;
	
	@FindBy(xpath="//a[normalize-space()='Sign Out']")
	private WebElement SignOut;
	
	//2
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//3
	public WebElement getOrganization() {
		return Organization;
	}

	public WebElement getProduct() {
		return Product;
	}

	public WebElement getContact() {
		return Contact;
	}

	public WebElement getMore() {
		return More;
	}

	public WebElement getCampaigns() {
		return Campaigns;
	}

	public WebElement getReport() {
		return Report;
	}

	public WebElement getInvoice() {
		return Invoice;
	}

	public WebElement getQuote() {
		return Quote;
	}

	public WebElement getVendors() {
		return Vendors;
	}

	public WebElement getTesks() {
		return Tesks;
	}

	public WebElement getTickets() {
		return Tickets;
	}

	public WebElement getDocuments() {
		return Documents;
	}
	
	public WebElement getAdministrator() {
		return Administrator;	
	}
	
	public WebElement getSignOut() {
		return SignOut;
	}
}
