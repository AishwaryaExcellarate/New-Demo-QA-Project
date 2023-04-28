package Tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LandingPage;
import TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase extends BaseTest
{
	@Test
	public void testcase() throws  IOException
	{
		
			
			
			launchapplication();
			HomePage hp=new HomePage(driver);
			hp.ClickonElementsicon();
			hp.ClickonElementsbtn();
			hp.ClickonTextboxfield();
			hp.editUsername("puppy");
			hp.editUseremail("abc@123.com");
			hp.editCurrentadd("mexico");
			hp.editPermanentadd("paris");
			hp.ClickonSubmitbtn();
			hp.Clickoncheckboxlnk();
			hp.getTextfromOutput();
			hp.Clickoncheckboxbtn();
			hp.getResultfromCheckbox();
			hp.Clickondoublelnk();
			hp.Clickondoublebtn();
			hp.gobackToHome();
			
			
			
			
			
			
		
			 
			
				
			
			
	}

}
