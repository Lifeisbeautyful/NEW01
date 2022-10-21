package BaseCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.GenericUtility.FileUtility;
import com.GenericUtility.WebDriveruility;
import com.crm.objectrepositary.HomePage;
import com.crm.objectrepositary.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	FileUtility f=new FileUtility();
	WebDriveruility w=new WebDriveruility();
	
    public WebDriver driver;
    public static WebDriver sDriver;
    
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void BS() 
	{
		System.out.println("Database connection");
	}
	
	@BeforeTest(groups = {"smokeTest","regressionTest"})
	public void BT()
	{
		System.out.println("Execute in parallel mode");
	}
	
	
	//@Parameters("BROWSER")//this is used here for CROWSS-BROWSER TESTING//
	
	
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void BC() throws Throwable 
	//public void BC(String BROWSER) throws Throwable
	{
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
			sDriver=driver;
		System.out.println("Launching the browser");
	}
	
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void BM() throws Throwable
	{
		String URL=f.getPropertyKeyValue("url");             
		String UN=f.getPropertyKeyValue("un");
		String PW=f.getPropertyKeyValue("pw");
		w.getURL(driver, URL);
		w.maximize(driver);
		LoginPage l=new LoginPage(driver);
		l.login(UN, PW);
		
		System.out.println("Login to application");
	}
	
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void AM() throws Throwable
	{
		System.out.println("Logout the application");
		
		HomePage h=new HomePage(driver);
		WebElement resource=h.getAdministrator();
		w.moveOverOnElement(driver, resource);
		h.getSignOut().click();
	}
	
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void AC() throws Throwable 
	{
		System.out.println("Closing the browser");
		w.close(driver);
	}     
	
	@AfterTest(groups = {"smokeTest","regressionTest"})
	public void AT()
	{
		System.out.println("Execution complete");
	}
	
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void AS()
	{
		System.out.println("End database connection");
	}
}
