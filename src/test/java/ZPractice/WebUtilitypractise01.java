package ZPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.GenericUtility.ExcelUtility;
import com.GenericUtility.FileUtility;
import com.GenericUtility.JavaUtility;

public class WebUtilitypractise01
{
	public static void main(String[] args) throws Throwable 
	{
		String key="webdriver.chrome.driver";
		String value="./chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		
		FileUtility f=new FileUtility();                        //Login with File Utility
		String URL=f.getPropertyKeyValue("url");
		String User=f.getPropertyKeyValue("un");
		String Pwd=f.getPropertyKeyValue("pw");
		driver.get(URL);
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(User);
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(Pwd);
		driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
		
		JavaUtility j=new JavaUtility();                           //Made Random with Java Utility
		int ranNum = j.getRanDomNum();
		
		ExcelUtility e=new ExcelUtility();                         //Create Organization with Excel Utility
		String data=e.getDataFromExcel("Organization",0,1)+ranNum;
		driver.findElement(By.xpath("//a[@href=\"index.php?module=Accounts&action=index\"]")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(data);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		

	}
}
