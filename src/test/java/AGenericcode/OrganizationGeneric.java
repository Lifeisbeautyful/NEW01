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

public class OrganizationGeneric
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
		
		ExcelUtility e=new ExcelUtility();
		JavaUtility j=new JavaUtility();
		String data=e.getDataFromExcel("Campaign",0, 1)+j.getRanDomNum();
		System.out.println("Organization name = " + data);
		
		driver.findElement(By.xpath("//a[@href=\"index.php?module=Accounts&action=index\"]")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(data);
		driver.findElement(By.xpath("(//input[contains(@title,'Save [Alt+S]')])[1]")).click();
	
		w.pageToLoadImplicitly(driver);
		
		WebElement Element=driver.findElement(By.xpath("//span[contains(text(),'Organization Information')]"));
		w.getTitleWP2VarifyC(driver, data,Element );
		
		WebElement resource=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		w.moveOverOnElement(driver, resource);
		
		driver.findElement(By.xpath("//a[normalize-space()='Sign Out']")).click();
		w.sleep(driver);
		w.close(driver);		
}}
