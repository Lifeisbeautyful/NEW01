package A2POMimplement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.GenericUtility.ExcelUtility;
import com.GenericUtility.FileUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriveruility;
import com.crm.objectrepositary.HomePage;
import com.crm.objectrepositary.LoginPage;
import com.crm.objectrepositary.OrganizationCreationPage;
import com.crm.objectrepositary.OrganizationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrganizationTest
{
	public static void main(String[] args) throws Throwable
	{
		FileUtility f=new FileUtility();
		WebDriver driver;
		String BROWSER=f.getPropertyKeyValue("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		String URL=f.getPropertyKeyValue("url"); 
		String UN=f.getPropertyKeyValue("un");
		String PW=f.getPropertyKeyValue("pw");
		
		WebDriveruility w=new WebDriveruility();
		w.maximize(driver);
		w.getURL(driver, URL);
		
		LoginPage l=new LoginPage(driver);
		l.login(UN, PW);
		
		ExcelUtility e=new ExcelUtility();
		JavaUtility j=new JavaUtility();
		int rnum=j.getRanDomNum();
		String data=e.getDataFromExcel("Organization",0, 1)+rnum;
		System.out.println("Organization name = " + data);
		
		HomePage h=new HomePage(driver);
		h.getOrganization().click();
		
		OrganizationPage O1=new OrganizationPage(driver);
		O1.getAdd().click();
		
		OrganizationCreationPage O2=new OrganizationCreationPage(driver);
		WebElement E1=O2.getOrgTextBox();
		E1.sendKeys(data);
		w.getAttribute(driver, E1);
		O2.getSaveBtn().click();
		
		WebElement E2=O2.getTitle();
		w.pageToLoadImplicitly(driver);
		w.getTitleWP2VarifyC(driver, data,E2 );
		
		WebElement resource=h.getAdministrator();
		w.moveOverOnElement(driver, resource);
		h.getSignOut().click();
		w.close(driver);	
	}
}
