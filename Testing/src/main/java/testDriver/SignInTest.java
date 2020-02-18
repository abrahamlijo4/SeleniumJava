package testDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignInTest {
	
	public WebDriver driver;
	
	@BeforeTest
	public void initializeScript() {
		System.setProperty("webdriver.chrome.driver", "E:\\Work\\eclipse-workspace\\Drivers\\chromedriver80.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/");
		driver.findElement(By.linkText("New Tours")).click();;
	}
	
	@Test
	public void testingSignin() {
		driver.findElement(By.name("userName")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String loginSuccess = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td")).getText();
		
		
		if (loginSuccess.equals("Login Successfully")){
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	@AfterTest
	public void closingTest() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
}
