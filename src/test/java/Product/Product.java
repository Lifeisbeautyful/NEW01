package Product;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Product
{
	public static void main(String[] args) throws Throwable {
		String key="webdriver.chrome.driver";
		String value="./chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		FileInputStream fis=new FileInputStream("./Vtiger.properties");
		Properties p=new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String UN= p.getProperty("un");
		String PW=p.getProperty("pw");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PW);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(1000);
		
		FileInputStream fis1=new FileInputStream("./Vtiger.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Random ran=new Random();
		int rnum = ran.nextInt(1000);
		String data = book.getSheet("Product").getRow(0).getCell(0).getStringCellValue()+rnum;
		System.out.println("Product Name = "+data);
		
		driver.findElement(By.xpath("(//a[text()='Products'])[1]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(data);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		Thread.sleep(1000);
		
		String Title= driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		System.out.println("Product Title = "+Title);
		if(Title.contains(data))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		WebElement target = driver.findElement(By.xpath("(//td[@valign='bottom']/img)[1]"));
		Actions act=new Actions(driver);
		act.moveToElement(target).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();
}
}