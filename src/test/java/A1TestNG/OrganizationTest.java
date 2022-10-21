   package A1TestNG;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import com.GenericUtility.ExcelUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriveruility;
import com.crm.objectrepositary.HomePage;
import com.crm.objectrepositary.OrganizationCreationPage;
import com.crm.objectrepositary.OrganizationPage;

import BaseCase.BaseClass;

public class OrganizationTest extends  BaseClass
{    
	@Test(retryAnalyzer=com.GenericUtility.RetryAnalyser.class)
	public void organizationTest() throws Throwable
	{
		//Assert.fail();
		WebDriveruility w=new WebDriveruility();
		w.pageToLoadImplicitly(driver);
		HomePage h=new HomePage(driver);
		h.getOrganization().click();
		OrganizationPage O1=new OrganizationPage(driver);
		O1.getAdd().click();
		
		ExcelUtility e=new ExcelUtility();
		JavaUtility j=new JavaUtility();
		int rnum=j.getRanDomNum();
		String data=e.getDataFromExcel("Organization",0, 1)+rnum;
		System.out.println("Organization name = " + data);
		
		OrganizationCreationPage O2=new OrganizationCreationPage(driver);
		WebElement E1=O2.getOrgTextBox();
		E1.sendKeys(data);
		w.getAttribute(driver, E1);
		O2.getSaveBtn().click();
		System.out.println("Deepak");
		
		WebElement E2=O2.getTitle();
		//String E2=O2.getTitle().getText();
		//Assert.assertEquals("A","A");
		//SoftAssert s=new SoftAssert();
		//s.assertEquals("A", "A");
		w.sleep(driver);
		w.getTitleWP2VarifyC(driver, data,E2 );
		//s.assertAll();
	}
	@Test(groups = "regressiontest",priority=1)
	public void modifyOrg()
		{
			System.out.println("modify Organization");
		}
	
	
	}

