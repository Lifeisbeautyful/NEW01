package ZPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartOrder {
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button)[2]")).click();
		driver.findElement(By.name("q")).sendKeys("iphone");
		driver.findElement(By.xpath("//button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[.='APPLE iPhone 11 (Black, 128 GB)']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[.='BUY NOW']")).click();
	}

}
