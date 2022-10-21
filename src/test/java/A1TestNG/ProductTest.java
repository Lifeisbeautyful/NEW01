package A1TestNG;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.GenericUtility.ExcelUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriveruility;
import com.crm.objectrepositary.HomePage;
import com.crm.objectrepositary.ProductCreationPage;
import com.crm.objectrepositary.ProductPage;

import BaseCase.BaseClass;

public class ProductTest extends BaseClass
{
	@Test(groups = {"smokeTest"},priority=2)
	public void productTest() throws Throwable
	{
		WebDriveruility w=new WebDriveruility();
		HomePage h=new HomePage(driver);
		h.getProduct().click();
		w.pageToLoadImplicitly(driver);
		
		ProductPage P1=new ProductPage(driver);
		P1.getadd().click();
		
		ExcelUtility e=new ExcelUtility();
		JavaUtility j=new JavaUtility();
		int rnum=j.getRanDomNum();
		String data=e.getDataFromExcel("product",0, 1)+rnum;
		System.out.println("Product Name = " + data);
		
		ProductCreationPage P2=new ProductCreationPage(driver);
		P2.getProductBox().sendKeys(data);
		P2.getSave().click();
		
		WebElement E1=P2.getTitle();
		w.getTitleWP2VarifyC(driver, data, E1);
	}
	//Product Deletion
	@Test(groups = "regressiontest",priority=2)
	public void ProductModify() throws Throwable
		{
		System.out.println("modify Products");
		}
}

