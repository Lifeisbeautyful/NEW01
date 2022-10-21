package Runparameter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.GenericUtility.FileUtility;
import com.GenericUtility.WebDriveruility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Runparameter 
{
	WebDriver driver;
	FileUtility f=new FileUtility();
	WebDriveruility w=new WebDriveruility();

	@Test
	public void method() throws Throwable
	{
	
	String BROWSER=System.getProperty("browser");
	
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
	
	String URL=System.getProperty("url");
	String UN=System.getProperty("un");
	String PW=System.getProperty("pw");
		
	w.maximize(driver);
	w.getURL(driver, URL);
	
	driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(UN);
	driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PW);
	driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
	
}}
