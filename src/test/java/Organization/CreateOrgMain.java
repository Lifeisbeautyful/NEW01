package Organization;

//Creating an Organization
import java.io.FileInputStream;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgMain
{
	public static void main(String[] args) throws Throwable 
	{
		String key="webdriver.chrome.driver";
		String value="./chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//login
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
		
		//Organization creation
		FileInputStream f=new FileInputStream("./Vtiger.xlsx");
		Workbook book=WorkbookFactory.create(f);
		String data=book.getSheet("Organization").getRow(1).getCell(1).getStringCellValue();
		System.out.println(data);
		driver.findElement(By.xpath("//a[@href=\"index.php?module=Accounts&action=index\"]")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(data);
		driver.findElement(By.xpath("(//input[contains(@title,'Save [Alt+S]')])[1]")).click();
        Thread.sleep(1000);
		
       
		// Verification of the title of an Organization
		String title=driver.findElement(By.xpath("//span[contains(text(),'Organization Information')]")).getText();
		if(title.contains(data))
		{
			System.out.println("title is varified");
		}
		else
		{
			System.out.println("title is not varified");
		}
		
		//SignOut
		WebElement resource=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(resource).perform();
		
		Thread.sleep(1000);
		driver.close();
}}
