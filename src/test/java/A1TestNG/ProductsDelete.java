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

public class ProductsDelete extends BaseClass
{
	@Test(groups = {"smokeTest"},priority=3)
	public void productsDelete() throws Throwable 
	{
		WebDriveruility w=new WebDriveruility();
		HomePage h=new HomePage(driver);
		w.pageToLoadImplicitly(driver);
		h.getProduct().click();
		
		ProductPage P1=new ProductPage(driver);
		P1.getadd().click();
		
		ExcelUtility e=new ExcelUtility();
		JavaUtility j=new JavaUtility();
		int rnum=j.getRanDomNum();
		String data=e.getDataFromExcel("product",0, 1)+rnum;
		
		ProductCreationPage P2=new ProductCreationPage(driver);
		w.pageToLoadImplicitly(driver);
		P2.getProductBox().sendKeys(data);
		P2.getSave().click();
		
		w.pageToLoadImplicitly(driver);
		WebElement E1=P2.getTitle();
		w.getTitleWP2VarifyC(driver, data, E1);
		System.out.println();
		System.out.println("Product is deleted");
		P2.getDelete().click();
		
		w.sleep(driver);
		w.switchAlertWindowAccpect(driver);
			
	}
}
