package test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import page.LoginPage;
import utils.ExcelUtils;

@Listeners(test.ListenerTest.class)
public class LoginPageTest extends AbstractClass{
	boolean checkTestCase;
	private  WebDriver driver;
	public LoginPage loginPage;
	private ExcelUtils excel;
	
	public String alertMessage= "Sai password hoáº·c tÃ i khoáº£n !\nNáº¿u báº¡n chÆ°a cÃ³ tÃ i khoáº£n, hÃ£y Ä‘Äƒng kÃ½.";
	public String passMessage = "ChÃ o má»«ng báº¡n Ä‘Ã£ Ä‘Äƒng nháº­p thÃ nh cÃ´ng.";
	public String alterwarning = "Ä�á»‹a chá»‰ mail hoáº·c Ä‘á»‹nh dáº¡ng khÃ´ng Ä‘Ãºng.";
  
//	WebElement noti = driver.findElement(By.xpath("//div[@class=\"modal fade in\"]//div[@class=\"modal-content\"]//div[@class=\"modal-body\"]"));
////	  String expNoti = "Sai password hoÃ¡ÂºÂ·c tÃƒÂ i khoÃ¡ÂºÂ£n !";
//	  String accNoti = noti.getText();
//	  System.out.println(noti.getText());
//	  if (noti.getText().equals(alertMessage)==true
//			  || noti.getText().contains(alertMessage)==true) {
//			           System.out.print("Test case is passed! \r" );
//			  }
//			  else {
//				  System.out.print("Test case is failed! \r");
//			  }
	
	
	@BeforeMethod
	public void setUp() throws Exception {
		driver = getDriver();
		excel = new ExcelUtils();
		ExcelUtils.setExcelFile(".\\Data\\FunctionalTestCase-Login.xlsx", "InputData");
	}
	
	
	public void pauseWithTryCatch(int timeSecond) {
	      try {
	          Thread.sleep(timeSecond);
	      } catch (InterruptedException e) {
	          e.printStackTrace();
	      }
	  }
	
	@Test (priority = 1)
	public void signInPagenopass() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.Login(ExcelUtils.getCellData(1,2), ExcelUtils.getCellData(1,3));
		WebElement noti = driver.findElement(By.xpath("//div[@class=\"modal fade in\"]//div[@class=\"modal-content\"]//div[@class=\"modal-body\"]"));
//		  String expNoti = "Sai password hoÃ¡ÂºÂ·c tÃƒÂ i khoÃ¡ÂºÂ£n !";
		  //String accNoti = noti.getText();
		  //System.out.println(noti.getText());
		  if (noti.getText().equals(alertMessage)==true
				  || noti.getText().contains(alertMessage)==true) {
				           System.out.print("passed! \r" );
				           Assert.assertTrue(true);
				           ExcelUtils.setCellData(1, 5, "Passed");
				  }
				  else {
					  System.out.print("failed! \r");
					  Assert.assertTrue(false);
					  ExcelUtils.setCellData(1, 5, "Failed");
				  }
		  ExcelUtils.closeandsaveFile(".\\Data\\FunctionalTestCase-Login.xlsx");
//		driver.navigate().refresh();
	}
	
	@Test (priority = 2)
		public void signInPagenomail() throws Exception {
			

			loginPage = new LoginPage(driver);
			loginPage.Login(ExcelUtils.getCellData(2,2), ExcelUtils.getCellData(2,3));
			WebElement warning = driver.findElement(By.xpath("//li[contains(text(),'Ä�á»‹a chá»‰ mail hoáº·c Ä‘á»‹nh dáº¡ng khÃ´ng Ä‘Ãºng.')]"));
//			  WebElement noti = driver.findElement(By.xpath("//div[@class=\"modal fade in\"]//div[@class=\"modal-content\"]//div[@class=\"modal-body\"]"));
//			  String accNoti = noti.getText();
			  
			  if ( warning.getText().contains(alterwarning)==true) {
					           System.out.print("passed! \r" );
					           Assert.assertTrue(true);
					           ExcelUtils.setCellData(2, 5, "Passed");
					  }
					  else {
						  System.out.print("failed! \r");
						  Assert.assertTrue(false);
						  ExcelUtils.setCellData(2, 5, "Failed");
					  }
//			driver.navigate().refresh();
			  ExcelUtils.closeandsaveFile(".\\Data\\FunctionalTestCase-Login.xlsx");
	}
	
	@Test (priority = 3)
	public void signInPageempty() throws Exception {

		loginPage = new LoginPage(driver);
		loginPage.Login(ExcelUtils.getCellData(3,2), ExcelUtils.getCellData(3,3));
		WebElement warning = driver.findElement(By.xpath("//li[contains(text(),'Ä�á»‹a chá»‰ mail hoáº·c Ä‘á»‹nh dáº¡ng khÃ´ng Ä‘Ãºng.')]"));
//		  WebElement noti = driver.findElement(By.xpath("//div[@class=\"modal fade in\"]//div[@class=\"modal-content\"]//div[@class=\"modal-body\"]"));
//		  String accNoti = noti.getText();
		  
		  
		  if ( warning.getText().contains(alterwarning)==true) {
				           System.out.print("passed! \r" );
				           Assert.assertTrue(true);
				           ExcelUtils.setCellData(3, 5, "Passed");
				  }
				  else {
					  System.out.print("failed! \r");
					  Assert.assertTrue(false);
					  ExcelUtils.setCellData(3, 5, "Failed");
				  }
		  ExcelUtils.closeandsaveFile(".\\Data\\FunctionalTestCase-Login.xlsx");
	  }
//		driver.navigate().refresh();
	
	
	
	@Test (priority = 4)
	public void signInPagewrongpass() throws Exception {

		loginPage = new LoginPage(driver);
		loginPage.Login(ExcelUtils.getCellData(4,2), ExcelUtils.getCellData(4,3));
		WebElement noti = driver.findElement(By.xpath("//div[@class=\"modal fade in\"]//div[@class=\"modal-content\"]//div[@class=\"modal-body\"]"));
		  String accNoti = noti.getText();
		  //System.out.println(noti.getText());
		  if (noti.getText().equals(alertMessage)==true
				  || noti.getText().contains(alertMessage)==true) {
				           System.out.print("passed! \r" );
				           Assert.assertTrue(true);
				           ExcelUtils.setCellData(4, 5, "Passed");
				  }
				  else {
					  System.out.print("failed! \r");
					  Assert.assertTrue(false);
					  ExcelUtils.setCellData(4, 5, "Failed");
				  }
		  ExcelUtils.closeandsaveFile(".\\Data\\FunctionalTestCase-Login.xlsx");
//		driver.navigate().refresh();
	
	}
	
	@Test (priority = 5)
	public void signInPagewrongmail() throws Exception {

		loginPage = new LoginPage(driver);
		loginPage.Login(ExcelUtils.getCellData(5,2), ExcelUtils.getCellData(5,3));
		WebElement noti = driver.findElement(By.xpath("//div[@class=\"modal fade in\"]//div[@class=\"modal-content\"]//div[@class=\"modal-body\"]"));
//		  String expNoti = "Sai password hoÃ¡ÂºÂ·c tÃƒÂ i khoÃ¡ÂºÂ£n !";
		  String accNoti = noti.getText();
		  //System.out.println(noti.getText());
		  if (noti.getText().equals(alertMessage)==true
				  || noti.getText().contains(alertMessage)==true) {
				           System.out.print("passed! \r" );
				           Assert.assertTrue(true);
				           ExcelUtils.setCellData(5, 5, "Passed");
				  }
				  else {
					  System.out.print("failed! \r");
					  Assert.assertTrue(false);
					  ExcelUtils.setCellData(5, 5, "Failed");
				  }
		  ExcelUtils.closeandsaveFile(".\\Data\\FunctionalTestCase-Login.xlsx");
//		driver.navigate().refresh();
	
	}
	
	@Test (priority = 6)
	public void signInPagewrongpassandmail() throws Exception {

		loginPage = new LoginPage(driver);
		loginPage.Login(ExcelUtils.getCellData(6,2), ExcelUtils.getCellData(6,3));
		WebElement noti = driver.findElement(By.xpath("//div[@class=\"modal fade in\"]//div[@class=\"modal-content\"]//div[@class=\"modal-body\"]"));
//		  String expNoti = "Sai password hoÃ¡ÂºÂ·c tÃƒÂ i khoÃ¡ÂºÂ£n !";
		  String accNoti = noti.getText();
		  
		  if (noti.getText().equals(alertMessage)==true
				  && noti.getText().contains(alertMessage)==true) {
				           System.out.print("passed! \r" );
				           Assert.assertTrue(true);
				           ExcelUtils.setCellData(6, 5, "Passed");
				  }
				  else {
					  System.out.print("failed! \r");
					  Assert.assertTrue(false);
					  ExcelUtils.setCellData(6, 5, "Failed");
				  }
		  ExcelUtils.closeandsaveFile(".\\Data\\FunctionalTestCase-Login.xlsx");
//		driver.navigate().refresh();
	
	}
	
	@Test (priority = 7)
	public void signInPageinvalidname() throws Exception {

		loginPage = new LoginPage(driver);
		loginPage.Login(ExcelUtils.getCellData(7,2), ExcelUtils.getCellData(7,3));
		
		WebElement warning = driver.findElement(By.xpath("//li[contains(text(),'Ä�á»‹a chá»‰ mail hoáº·c Ä‘á»‹nh dáº¡ng khÃ´ng Ä‘Ãºng.')]"));
		WebElement noti = driver.findElement(By.xpath("//div[@class=\"modal fade in\"]//div[@class=\"modal-content\"]//div[@class=\"modal-body\"]"));
		  if ( warning.getText().equals(alterwarning)==true
				  && noti.getText().contains(alertMessage)==true) {
				           System.out.print("passed! \r" );
				           Assert.assertTrue(true);
				           ExcelUtils.setCellData(7, 5, "Passed");
				  }
				  else {
					  System.out.print("failed! \r");
					  Assert.assertTrue(false);
					  ExcelUtils.setCellData(7, 5, "Failed");
				  }
		  ExcelUtils.closeandsaveFile(".\\Data\\FunctionalTestCase-Login.xlsx");
//		driver.navigate().refresh();
	
	}
	
	@Test (priority = 8)
	public void signInPagePass() throws Exception {

		loginPage = new LoginPage(driver);
		loginPage.Login(ExcelUtils.getCellData(8,2), ExcelUtils.getCellData(8,3));
		WebElement passlogin = driver.findElement(By.xpath(" //body/div[5]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]"));	 
		  if ( passlogin.getText().contains(passMessage)==true) {
				           System.out.print("passed! \r" );
				           Assert.assertTrue(true);
				           ExcelUtils.setCellData(8, 5, "Passed");
				  }
				  else {
					  System.out.print("failed! \r");
					  Assert.assertTrue(false);
					  ExcelUtils.setCellData(8, 5, "Failed");
				  }
		  ExcelUtils.closeandsaveFile(".\\Data\\FunctionalTestCase-Login.xlsx");
//		driver.navigate().refresh();
	
	}
	
}
