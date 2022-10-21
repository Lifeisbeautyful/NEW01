package A1TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.GenericUtility.ExcelUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriveruility;
import com.crm.objectrepositary.HomePage;
import com.crm.objectrepositary.XCampaignCreatePage;
import com.crm.objectrepositary.XCampaignPage;

import BaseCase.BaseClass;

public class ZCampaignWithProductTest extends BaseClass
{
	@Test(groups = {"smokeTest"},priority=5)
	public void zcampaignWithProductTest() throws Throwable 
	{
		WebDriveruility w=new WebDriveruility();
		ExcelUtility e=new ExcelUtility();
		JavaUtility j=new JavaUtility();
		int rnum=j.getRanDomNum();
		String data=e.getDataFromExcel("Campaign",0, 1)+rnum;
		System.out.println("Campaign Name = " + data);
	
		HomePage h=new HomePage(driver);
		WebElement Target=h.getMore();
		w.moveOverOnElement(driver, Target);
		h.getCampaigns().click();
		
		XCampaignPage c=new XCampaignPage(driver);
		c.getAdd().click();
		
		XCampaignCreatePage C2=new XCampaignCreatePage(driver);
		C2.getCampaignTextBox().sendKeys(data);
		w.sleep(driver);
		
		//AddProduct
		C2.getAddProduct().click();
		w.switchToWindow2(driver, "productWindow");
		
		String Productdata=e.getDataFromExcel("Product",0, 1);
		driver.findElement(By.id("search_txt")).sendKeys(Productdata);
		driver.findElement(By.name("search")).click();
		
		//Dynamic path
		driver.findElement(By.xpath("//a[text()='"+Productdata+"']")).click();
		w.sleep(driver);
		w.switchToWindow2(driver, "CampaignWindow");
		C2.getSave().click();
		
		WebElement W2=C2.getTitle();
		w.getTitleWP2VarifyC(driver, data, W2);
}}
