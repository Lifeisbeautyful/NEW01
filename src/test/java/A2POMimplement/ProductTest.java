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
import com.crm.objectrepositary.ProductCreationPage;
import com.crm.objectrepositary.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductTest 
{
	
	public void productTest() throws Throwable
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
		
		HomePage h=new HomePage(driver);
		h.getProduct().click();
		
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
		
		w.pageToLoadImplicitly(driver);
		WebElement E1=P2.getTitle();
		w.getTitleWP2VarifyC(driver, data, E1);

		WebElement resource=h.getAdministrator();
		w.moveOverOnElement(driver, resource);
		h.getSignOut().click();
		w.close(driver);
}}
