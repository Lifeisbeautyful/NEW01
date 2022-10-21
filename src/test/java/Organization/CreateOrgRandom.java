package Organization;

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

public class CreateOrgRandom
{
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
	
		FileInputStream f=new FileInputStream("./Vtiger.xlsx");
		Workbook book=WorkbookFactory.create(f);
		Random ran=new Random();
		int rnum=ran.nextInt(1000);
		String data=book.getSheet("Organization").getRow(1).getCell(1).getStringCellValue()+rnum;
		System.out.println("Organization =" + data);
		
		driver.findElement(By.xpath("//a[@href=\"index.php?module=Accounts&action=index\"]")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(data);
		driver.findElement(By.xpath("(//input[contains(@title,'Save [Alt+S]')])[1]")).click();
		
		Thread.sleep(2000);
		String title=driver.findElement(By.xpath("//span[contains(text(),'Organization Information')]")).getText();
		if(title.contains(data))
		{
			System.out.println("Org title is varified");
		}
		else
		{
			System.out.println("Org title is not varified");
		}
		
		//SignOut
		WebElement resource=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(resource).perform();
		
		driver.close();
}}
