package AGenericcode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.GenericUtility.FileUtility;
import com.GenericUtility.WebDriveruility;

import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginGeneric
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
		
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(UN);
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PW);
		driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
		
		WebElement resource=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		w.moveOverOnElement(driver, resource);
		
		String data="vtiger CRM 5";
		w.getTitleWebSite2VerifyC(driver, data);
		w.getURL2Print(driver);
		
		driver.findElement(By.xpath("//a[normalize-space()='Sign Out']")).click();
		w.sleep(driver);
		w.close(driver);
		
}}


		