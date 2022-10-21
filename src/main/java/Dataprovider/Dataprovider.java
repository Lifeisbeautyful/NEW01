package Dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider
{
	@Test(dataProvider="dataProvider_test")
	public void CompanyDetails(String name,String phone, String email) 
	{
		String key="webdriver.chrome.driver";
		String value="./chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
		
		driver.findElement(By.xpath("//a[@href=\"index.php?module=Accounts&action=index\"]")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(name);
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phone);
		driver.findElement(By.xpath("//input[@id='email1']")).sendKeys(email);
		driver.findElement(By.xpath("(//input[contains(@title,'Save [Alt+S]')])[1]")).click();
		
		//WebElement resource=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//Actions a=new Actions(driver);
		//a.moveToElement(resource).perform();
		
		//driver.findElement(By.xpath("//a[normalize-space()='Sign Out']")).click();
		//Thread.sleep(1000);
		driver.close();	
		System.out.println("Org name is " + email );
		System.out.println();
		System.out.println("Phone is " + phone );
		System.out.println();
		System.out.println("Email is " + email );
		System.out.println();
	}
	
	@DataProvider
	public Object[][] dataProvider_test()
	{
		Object[][] objArr=new Object[3][3];
		
		objArr[0][0]="Deepak1";
		objArr[0][1]="9035371794";
		objArr[0][2]="deepakdeep396@gmail.com";
		
		objArr[1][0]="Deepak2";
		objArr[1][1]="9035371794";
		objArr[1][2]="deepakdeep396@gmail.com";
		
		objArr[2][0]="Deepak3";
		objArr[2][1]="9035371794";
		objArr[2][2]="deepakdeep396@gmail.com";
		
		return objArr;
	}

}
