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
import com.crm.objectrepositary.XCampaignCreatePage;
import com.crm.objectrepositary.XCampaignPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ZCampaignTest
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
		                       //.............................//
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
		C2.getSave().click();
		                      //.............................//
		w.pageToLoadImplicitly(driver);
		WebElement E1 = C2.getTitle();
		w.getTitleWP2VarifyC(driver, data, E1);
		                     //.............................//
		WebElement resource=h.getAdministrator();
		w.moveOverOnElement(driver, resource);
		h.getSignOut().click();
		w.sleep(driver);
		w.close(driver);
}}


