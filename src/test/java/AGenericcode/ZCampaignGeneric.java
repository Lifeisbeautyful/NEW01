package AGenericcode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.GenericUtility.ExcelUtility;
import com.GenericUtility.FileUtility;
import com.GenericUtility.JavaUtility;
import com.GenericUtility.WebDriveruility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ZCampaignGeneric
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
		
		                       //.............................//
		ExcelUtility e=new ExcelUtility();
		JavaUtility j=new JavaUtility();
		String data=e.getDataFromExcel("Campaign",0, 1)+j.getRanDomNum();
		System.out.println("Campaign Name = " + data);
	
		WebElement target = driver.findElement(By.xpath("//a[.='More']"));
		w.moveOverOnElement(driver, target);
		driver.findElement(By.xpath("//a[text()='Campaigns' and @id='more' ]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(data);
		driver.findElement(By.xpath("//input[contains(@class,'crmButton small save')]")).click();
		
		                      //.............................//
		w.pageToLoadImplicitly(driver);
		WebElement Element= driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		w.getTitleWP2VarifyE(driver, data, Element);
		
		                     //.............................//
		WebElement s= driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		w.moveOverOnElement(driver, s);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		w.close(driver);
}}
