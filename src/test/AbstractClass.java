package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class AbstractClass {
	
	public WebDriver driver;
	public static String baseUrl = "http://store.bobapop.com.vn/";
	public WebDriver getDriver() {
		return driver;
	}
	
	@BeforeMethod
	public void beforeTest() {
		System.out.println("Launching Chrome browser...");
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_94.exe");
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_95.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseUrl + "dang-ky.html");
		
	  }
	@AfterMethod
	  public void teardown() throws Exception {
		  Thread.sleep(2000);
		  driver.quit();
	  }
}
