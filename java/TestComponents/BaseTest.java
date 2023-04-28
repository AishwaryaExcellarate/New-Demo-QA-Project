package TestComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest
{
	public static  WebDriver driver;

	public WebDriver initializeDriver() throws IOException
	{
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\aishwaryaa\\eclipse-workspace\\DemoQAProject\\src\\main\\java\\Resources\\GlobalData.properties");
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		String username = prop.getProperty("Username");
		String useremail = prop.getProperty("Useremail");
		String currentaddress = prop.getProperty("Currentaddress");
		String permanentaddress = prop.getProperty("Permanentaddress");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(options);
		
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver=new FirefoxDriver();
			
		}
		
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			WebDriver driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}
	@BeforeTest
	public void launchapplication() throws IOException
	{
		driver=initializeDriver();
		LandingPage lp=new LandingPage(driver);
		lp.goToUrl();
		
	}
	
	 @AfterTest
	public void closebrowser()
	{
		driver.quit();
	}

}
