package Contact;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContactModule {

	public static void main(String[] args) throws Throwable {
		String key="webdriver.chrome.driver";
		String value="./chromedriver.exe";
		System.setProperty(key, value);
		FileInputStream fis=new FileInputStream("./common_data.properties");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String pwd=p.getProperty("password");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[.='Contacts'])[1]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		FileInputStream fis1=new FileInputStream("./Book1.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sheet = book.getSheet("Contacts");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String first = cell.getStringCellValue();
		String last = book.getSheet("Contacts").getRow(0).getCell(1).getStringCellValue();
		String orgName=book.getSheet("Organization").getRow(0).getCell(0).getStringCellValue();
		System.out.println("data ="+first+" "+last);
		driver.findElement(By.name("firstname")).sendKeys(first);
		driver.findElement(By.name("lastname")).sendKeys(last);
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		String pw = driver.getWindowHandle();
		Set<String> allw=driver.getWindowHandles();
		Iterator<String>it=allw.iterator();
		while(it.hasNext())
		{
			String win=it.next();
			driver.switchTo().window(win);
			if(driver.getTitle().contains("Accounts&action"))
			{
				break;
			}
		}
		driver.findElement(By.id("search_txt")).sendKeys(orgName+Keys.ENTER);
		driver.findElement(By.xpath("//a[contains(text(),'"+orgName+"')]")).click();
		driver.switchTo().window(pw);
		WebElement target1 = driver.findElement(By.xpath("(//td[@valign='bottom']/img)[1]"));
		Actions act=new Actions(driver);
		act.moveToElement(target1).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();
	}

}
