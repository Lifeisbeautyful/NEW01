package Campagine;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CampaignWithProduct {

	public static void main(String[] args) throws Throwable{
		String key="webdriver.chrome.driver";
		String value="./chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		FileInputStream fis=new FileInputStream("Vtiger.properties");
		Properties p=new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String UN= p.getProperty("un");
		String PW=p.getProperty("pw");
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PW);
		driver.findElement(By.id("submitButton")).click();
		
		FileInputStream fis1=new FileInputStream("Vtiger.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Random ran=new Random();
		int rnum = ran.nextInt(1000);
		String data = book.getSheet("Campaign").getRow(0).getCell(1).getStringCellValue()+rnum;
		System.out.println("Name of Campaign = "+data);
		
		WebElement Target = driver.findElement(By.xpath("//a[.='More']"));
		Actions a=new Actions(driver);
		a.moveToElement(Target).perform();
		driver.findElement(By.xpath("//a[text()='Campaigns' and @id='more' ]")).click();
		
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(data);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title='Select' ]")).click();
		Thread.sleep(2000);

		String CampaignWindow=driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		for(String W:allWindow)
		{
			driver.switchTo().window(W);
			if(CampaignWindow.contains(W))
			{
				continue;
			}
			else
			{
				WebElement W1=driver.findElement(By.xpath("//a[@id='3']"));
				W1.click();
			}
		}
		driver.switchTo().window(CampaignWindow);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		String Title = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println("Title of Campaign = "+Title);
		if(Title.contains(data))
		{
			System.out.println("Title of Campaign is verified");
		}
		else
		{
			System.out.println("Title of Campaign is verified");
		}
		
		WebElement target1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		a.moveToElement(target1).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();
	}}


