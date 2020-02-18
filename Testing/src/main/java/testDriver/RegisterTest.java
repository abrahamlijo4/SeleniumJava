package testDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegisterTest {

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
	public void registerTest() {
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName")).sendKeys("TestFirstName");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("TestLastName");
		driver.findElement(By.name("phone")).sendKeys("4168869854");
		driver.findElement(By.name("userName")).sendKeys("TestEmail@gmail.com");
		driver.findElement(By.name("address1")).sendKeys("TestAddress 1");
		driver.findElement(By.name("city")).sendKeys("Toronto");
		driver.findElement(By.name("state")).sendKeys("Ontario");
		driver.findElement(By.name("postalCode")).sendKeys("M3A1S1");
		Select country = new Select(driver.findElement(By.name("country")));
		country.selectByVisibleText("CANADA");
		driver.findElement(By.name("email")).sendKeys("TestEmail");
		driver.findElement(By.name("password")).sendKeys("TestPassword");
		driver.findElement(By.name("confirmPassword")).sendKeys("TestPassword");
		driver.findElement(By.name("submit")).click();
		
		new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("ac"))));
		
		if (driver.findElement(By.xpath("//font[contains(text(),'Thank you for registering')]")).isDisplayed()) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(true);
		}
	}
	
	@AfterTest
	public void closingTest() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
	
}
