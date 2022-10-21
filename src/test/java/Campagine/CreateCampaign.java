package Campagine;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class CreateCampaign
{
			public static void main(String[] args) throws Throwable {
			String key="webdriver.chrome.driver";
			String value="./chromedriver.exe";
			System.setProperty(key, value);
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize(); 
			
			FileInputStream fis=new FileInputStream("Vtiger.properties");
			Properties p=new Properties();
			p.load(fis);
			String url = p.getProperty("url");
			String un = p.getProperty("un");
			String pwd=p.getProperty("pw");
			
			driver.get(url);
			driver.findElement(By.name("user_name")).sendKeys(un);
			driver.findElement(By.name("user_password")).sendKeys(pwd);
			driver.findElement(By.id("submitButton")).click();
			
			FileInputStream fis1=new FileInputStream("Vtiger.xlsx");
			Workbook book = WorkbookFactory.create(fis1);
			Random ran=new Random();
			int rnum = ran.nextInt(1000);
			String data = book.getSheet("Campaign").getRow(0).getCell(1).getStringCellValue()+rnum;
			System.out.println("data ="+data);
			
			WebElement target = driver.findElement(By.xpath("//a[.='More']"));
			Actions a=new Actions(driver);
			a.moveToElement(target).perform();
			driver.findElement(By.xpath("//a[text()='Campaigns' and @id='more' ]")).click();
			driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
			driver.findElement(By.name("campaignname")).sendKeys(data);
			driver.findElement(By.xpath("//input[contains(@class,'crmButton small save')]")).click();
			
			String Title = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			System.out.println("Title of Campaign = " + Title);
			if(Title.contains(data))
			{
				System.out.println("Title of Campaign is Verified");
			}
			else
			{
				System.out.println("Title of Campaign is not Verified");
			}
			
			WebElement target1 = driver.findElement(By.xpath("(//td[@valign='bottom']/img)[1]"));
			a.moveToElement(target1).perform();
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			driver.close();		
		}
	}

