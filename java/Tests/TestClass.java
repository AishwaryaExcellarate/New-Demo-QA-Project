package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass 
{
	@Test
	public void testclass() throws InterruptedException
	{

       ChromeOptions options=new ChromeOptions();
       options.addArguments("--remote-allow-origins=*");
		Thread.sleep(2000);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://demoqa.com/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,+250)");
		driver.findElement(By.xpath("(//*[name()='svg'])[1]")).click();
		WebElement ele = driver.findElement(By.xpath("(//div[@class=\"element-group\"])[1]"));
		ele.click();
		driver.findElement(By.xpath("//span[contains(.,'Text Box')]")).click();
		driver.findElement(By.id("userName")).sendKeys("Puppy");
		driver.findElement(By.id("userEmail")).sendKeys("acc@123.com");
		driver.findElement(By.id("currentAddress")).sendKeys("mexico");
		driver.findElement(By.id("permanentAddress")).sendKeys("paris");
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,+250)");
		driver.findElement(By.cssSelector(".text-right.col-md-2.col-sm-12 button")).click();
		System.out.println(driver.findElement(By.id("output")).getText());
		driver.findElement(By.xpath("//span[contains(.,'Check Box')]")).click();
		driver.findElement(By.xpath("//span[@class='rct-checkbox']//*[name()='svg']")).click();
		Thread.sleep(2000);
		System.out.print(driver.findElement(By.id("result")).getText());
		//driver.findElement(By.xpath("//span[contains(.,'Web Tables')]")).click();
		//(//div[@class='rt-thead -header']//div[@class='rt-th rt-resizable-header -cursor-pointer'])[4]
		driver.findElement(By.id("item-4")).click();
		 
		for(int i=0;i<2;i++)
		{
			driver.findElement(By.xpath("//button[contains(.,'Double Click Me')]")).click();
			Thread.sleep(2000);
			
		}
		driver.findElement(By.xpath("//img[@src='/images/Toolsqa.jpg']")).click();
		
		
		
		
		
		driver.quit();
		
		
		
		
		
	}

}
