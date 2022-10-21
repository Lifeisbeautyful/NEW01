package ZPractice;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTrip {
	static {
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
	}
	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./makeMyTrip.properties");
		Properties p=new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(URL);
		FileInputStream fis1=new FileInputStream("./mmt.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String from = wb.getSheet("makeMyTrip").getRow(0).getCell(0).getStringCellValue();
		String to = wb.getSheet("makeMyTrip").getRow(0).getCell(1).getStringCellValue();
		driver.findElement(By.id("fromCity")).sendKeys(from);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.id("toCity")).sendKeys(to);
		r.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		Thread.sleep(1000);
		//dynamic date
		//String de_month = "October 2022";
		//String de_date = "10";
		driver.findElement(By.xpath("//div[text()='October 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='4']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[.='RETURN']")).click();
		Thread.sleep(1000);
		//dynamic date
		//String re_month="November";
		//String re_Date="10";
		driver.findElement(By.xpath("//div[text()='November']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='10']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Travellers & CLASS']")).click();
		
		String a="2";
		driver.findElement(By.xpath("//li[@data-cy='adults-"+a+"']")).click();
		
		String c="4";
		driver.findElement(By.xpath("//li[@data-cy='children-"+c+"']")).click();
		
		String i="1";
		driver.findElement(By.xpath("//li[@data-cy='infants-"+i+"']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@data-cy='travellerApplyBtn']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		
		
	}

}
