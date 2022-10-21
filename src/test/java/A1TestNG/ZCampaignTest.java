package A1TestNG;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.GenericUtility.ExcelUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriveruility;
import com.crm.objectrepositary.HomePage;
import com.crm.objectrepositary.XCampaignCreatePage;
import com.crm.objectrepositary.XCampaignPage;

import BaseCase.BaseClass;

public class ZCampaignTest extends BaseClass
{
	@Test(groups = {"smokeTest"},priority=4)
	public void zcampaignTest() throws Throwable
	{
	
		ExcelUtility e=new ExcelUtility();
		JavaUtility j=new JavaUtility();
		int rnum=j.getRanDomNum();
		String data=e.getDataFromExcel("Campaign",0, 1)+rnum;
		System.out.println("Campaign Name = " + data);
	
		WebDriveruility w=new WebDriveruility();
		HomePage h=new HomePage(driver);
		WebElement Target=h.getMore();
		w.pageToLoadImplicitly(driver);
		w.moveOverOnElement(driver, Target);
		h.getCampaigns().click();
		
		XCampaignPage c=new XCampaignPage(driver);
		c.getAdd().click();
		
		XCampaignCreatePage C2=new XCampaignCreatePage(driver);
		C2.getCampaignTextBox().sendKeys(data);
		C2.getSave().click();
		                     
		w.pageToLoadImplicitly(driver);
		WebElement E1 = C2.getTitle();
		w.getTitleWP2VarifyC(driver, data, E1);	                
	}
	@Test(groups = "regressiontest",priority=3)
	public void modifyCampaign()
	{
		System.out.println("Campaigns are modified");
	}
	
}


