package testDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FlightFinderTest {
	public WebDriver driver;
	@BeforeTest
	public void initializeScript() {
		System.setProperty("webdriver.chrome.driver", "E:\\Work\\Java\\Selenium Java\\Selenium Web Drivers\\chromedriver80.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/");
		driver.findElement(By.linkText("New Tours")).click();;
	}
	
	@Test
	public void flightFinder() {
		driver.findElement(By.linkText("Flights")).click();
		driver.findElement(By.xpath("//input[@value='oneway']")).click();
		driver.findElement(By.name("findFlights")).click();
		boolean checkB2H = driver.findElement(By.xpath("//font[contains(text(),'BACK TO HOME')]")).isDisplayed();
		if (checkB2H) {
			Assert.assertTrue(true,"Test Passed");
		}else {
			Assert.assertFalse(true,"Test Failed");
		}
	}
	
	@AfterTest
	public void closingTest() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
}
