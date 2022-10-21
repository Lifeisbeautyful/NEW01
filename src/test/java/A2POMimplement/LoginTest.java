package A2POMimplement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.GenericUtility.FileUtility;
import com.GenericUtility.WebDriveruility;
import com.crm.objectrepositary.HomePage;
import com.crm.objectrepositary.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest
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
		w.getURL(driver, URL);
		w.maximize(driver);
		
		LoginPage l=new LoginPage(driver);
		l.login(UN, PW);
		
		w.sleep(driver);
		
		HomePage h=new HomePage(driver);
		WebElement resource=h.getAdministrator();
		w.moveOverOnElement(driver, resource);
		h.getSignOut().click();
		w.sleep(driver);
		w.close(driver);
	
	}}