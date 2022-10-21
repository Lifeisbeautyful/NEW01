package BLogin;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginMain {

	public static void main(String[] args) throws Throwable 
	{
		String key="webdriver.chrome.driver";
		String value="./chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		FileInputStream fis=new FileInputStream("./Vtiger.properties");
		Properties p=new Properties();
		p.load(fis);
		String Url=p.getProperty("url");
		String Un=p.getProperty("un");
		String Pw=p.getProperty("pw");
		
		driver.get(Url);
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(Un);
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(Pw);
		driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
		
		WebElement resource=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(resource).perform();
		
		driver.findElement(By.xpath("//a[normalize-space()='Sign Out']")).click();
		Thread.sleep(1000);
		driver.close();
	}}