package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import page.ContactPage;
import utils.ExcelUtils;

@Listeners(test.ListenerTest.class)
public class TCs_Contact extends AbstractClass{
//	boolean checkTestCase;
	private  WebDriver driver;
	public ContactPage contactPage;
	private ExcelUtils excel;
	
	private String expectedFullname = "Vui lÃ²ng cho biáº¿t há»� tÃªn.";
	private String expectedEmail = "Ä�á»‹a chá»‰ mail hoáº·c Ä‘á»‹nh dáº¡ng khÃ´ng Ä‘Ãºng.";
	private String expectedPhone = "Vui lÃ²ng cho biáº¿t sá»‘ Ä‘iá»‡n thoáº¡i.";
	private String expectedAddress = "Please fill out this field.";
	private String expectedSuccessfully = "ThÃ´ng tin cá»§a báº¡n Ä‘Ã£ Ä‘Æ°á»£c gá»­i tá»›i chÃºng tÃ´i.\nChÃºng tÃ´i sáº½ liÃªn láº¡c vá»›i báº¡n trong thá»�i gian sá»›m nháº¥t.";
	
	@BeforeMethod
	public void setUp() {
		driver = getDriver();
		excel = new ExcelUtils();
		ContactPage.selectMenuItemTest("Contact", driver);
//		WebElement contactbtn = driver.findElement(By.linkText("Contact"));
//		contactbtn.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
	}
	
	@Test(priority = 1)
	public void SendmailUnsuccessfullyEmptyPW() throws Exception {
		//getlinkExcel
		ExcelUtils.setExcelFile(".\\Data\\FunctionalTestCase-Contact.xlsx", "InputData");
		contactPage = new ContactPage(driver);
		
		//inputdata
		contactPage.Contact(ExcelUtils.getCellData(1,2), 
							ExcelUtils.getCellData(1,3), 
							ExcelUtils.getCellData(1,4), 
							ExcelUtils.getCellData(1,5), 
							ExcelUtils.getCellData(1,6));
		
		
		//actualtext
		String actualFullname = contactPage.getErrorFullname();
		String actualEmail = contactPage.getErrorEmail();
		String actualPhone = contactPage.getErrorPhone();
		String actualAddress = contactPage.getErrorAddress();
		
		//checkpoint
		if (expectedFullname.equals(actualFullname) 
			&& expectedEmail.equals(actualEmail)
			&& expectedPhone.equals(actualPhone)
			&& expectedAddress.equals(actualAddress)
			) {
	           System.out.print("passed! \r" );
	           Assert.assertTrue(true);
	           ExcelUtils.setCellData(1, 8, "Passed");
			}
			else {
				System.out.print("failed! \r" );
				Assert.assertTrue(false);
				ExcelUtils.setCellData(1, 8, "Failed");
			}
		ExcelUtils.closeandsaveFile(".\\Data\\FunctionalTestCase-Contact.xlsx");
		
	}
	@Test(priority = 2)
	public void SendmailUnsuccessfullyEmpty_3Field() throws Exception {
		//getlinkExcel
		ExcelUtils.setExcelFile(".\\Data\\FunctionalTestCase-Contact.xlsx", "InputData");
		contactPage = new ContactPage(driver);
		
		//inputdata
		contactPage.Contact(ExcelUtils.getCellData(2,2), 
							ExcelUtils.getCellData(2,3), 
							ExcelUtils.getCellData(2,4), 
							ExcelUtils.getCellData(2,5), 
							ExcelUtils.getCellData(2,6));
	
		//actualtext
		String actualEmail = contactPage.getErrorEmail();
		String actualPhone = contactPage.getErrorPhone();
		String actualAddress = contactPage.getErrorAddress();
		
		//checkpoint
		if (expectedEmail.equals(actualEmail)
			&& expectedPhone.equals(actualPhone)
			&& expectedAddress.equals(actualAddress)
			){
	           System.out.print("passed! \r" );
	           Assert.assertTrue(true);
	           ExcelUtils.setCellData(2, 8, "Passed");
			}
			else {
				System.out.print("failed! \r" );
				Assert.assertTrue(false);
				ExcelUtils.setCellData(2, 8, "Failed");
			}
		ExcelUtils.closeandsaveFile(".\\Data\\FunctionalTestCase-Contact.xlsx");

	}
	
	@Test(priority = 3)
	public void SendmailUnsuccessfullyEmpty_2Field() throws Exception {
		//getlinkExcel
		ExcelUtils.setExcelFile(".\\Data\\FunctionalTestCase-Contact.xlsx", "InputData");
		contactPage = new ContactPage(driver);
		
		//inputdata
		contactPage.Contact(ExcelUtils.getCellData(3,2), 
							ExcelUtils.getCellData(3,3), 
							ExcelUtils.getCellData(3,4), 
							ExcelUtils.getCellData(3,5), 
							ExcelUtils.getCellData(3,6));
	
		//actualtext
		
		String actualPhone = contactPage.getErrorPhone();
		String actualAddress = contactPage.getErrorAddress();
		
		//checkpoint
		if (expectedPhone.equals(actualPhone)
			&& expectedAddress.equals(actualAddress)
			){
	           System.out.print("passed! \r" );
	           Assert.assertTrue(true);
	           ExcelUtils.setCellData(3, 8, "Passed");
			}
			else {
				System.out.print("failed! \r" );
				Assert.assertTrue(false);
				ExcelUtils.setCellData(3, 8, "Failed");
			}
		ExcelUtils.closeandsaveFile(".\\Data\\FunctionalTestCase-Contact.xlsx");

	}
	
	@Test(priority = 4)
	public void SendmailUnsuccessfullyEmpty_1Field() throws Exception {
		//getlinkExcel
		ExcelUtils.setExcelFile(".\\Data\\FunctionalTestCase-Contact.xlsx", "InputData");
		contactPage = new ContactPage(driver);
		
		//inputdata
		contactPage.Contact(ExcelUtils.getCellData(4,2), 
							ExcelUtils.getCellData(4,3), 
							ExcelUtils.getCellData(4,4), 
							ExcelUtils.getCellData(4,5), 
							ExcelUtils.getCellData(4,6));
	
		//actualtext
		
		String actualAddress = contactPage.getErrorAddress();
		
		//checkpoint
		if (expectedAddress.equals(actualAddress)
			){
	           System.out.print("passed! \r" );
	           Assert.assertTrue(true);
	           ExcelUtils.setCellData(4, 8, "Passed");
			}
			else {
				System.out.print("failed! \r" );
				Assert.assertTrue(false);
				ExcelUtils.setCellData(4, 8, "Failed");
			}
		ExcelUtils.closeandsaveFile(".\\Data\\FunctionalTestCase-Contact.xlsx");

	}
	
	@Test(priority = 5)
	public void SendmailUnsuccessfully_Invalid_Phone() throws Exception {
		//getlinkExcel
		ExcelUtils.setExcelFile(".\\Data\\FunctionalTestCase-Contact.xlsx", "InputData");
		contactPage = new ContactPage(driver);
		
		//inputdata
		contactPage.Contact(ExcelUtils.getCellData(5,2), 
							ExcelUtils.getCellData(5,3), 
							ExcelUtils.getCellData(5,4), 
							ExcelUtils.getCellData(5,5), 
							ExcelUtils.getCellData(5,6));
	
		//actualtext
		
		String actualPhone = contactPage.getErrorPhone();
		
		//checkpoint
		if (expectedPhone.equals(actualPhone)
			){
	           System.out.print("passed! \r" );
	           Assert.assertTrue(true);
	           ExcelUtils.setCellData(5, 8, "Passed");
			}
			else {
				System.out.print("failed! \r" );
				Assert.assertTrue(false);
				ExcelUtils.setCellData(5, 8, "Failed");
			}
		ExcelUtils.closeandsaveFile(".\\Data\\FunctionalTestCase-Contact.xlsx");

	}
	
	@Test(priority = 6)
	public void SendmailUnsuccessfully_Invalid_Email() throws Exception {
		//getlinkExcel
		ExcelUtils.setExcelFile(".\\Data\\FunctionalTestCase-Contact.xlsx", "InputData");
		contactPage = new ContactPage(driver);
		
		//inputdata
		contactPage.Contact(ExcelUtils.getCellData(6,2), 
							ExcelUtils.getCellData(6,3), 
							ExcelUtils.getCellData(6,4), 
							ExcelUtils.getCellData(6,5), 
							ExcelUtils.getCellData(6,6));
	
		//actualtext
		
		String actualEmail = contactPage.getErrorEmail();
		
		//checkpoint
		if (expectedEmail.equals(actualEmail)
			){
	           System.out.print("passed! \r" );
	           Assert.assertTrue(true);
	           ExcelUtils.setCellData(6, 8, "Passed");
			}
			else {
				System.out.print("failed! \r" );
				Assert.assertTrue(false);
				ExcelUtils.setCellData(6, 8, "Failed");
			}
		ExcelUtils.closeandsaveFile(".\\Data\\FunctionalTestCase-Contact.xlsx");

	}
	
	@Test(priority = 7)
	public void SendmailSuccessfully() throws Exception {
		//getlinkExcel
		ExcelUtils.setExcelFile(".\\Data\\FunctionalTestCase-Contact.xlsx", "InputData");
		contactPage = new ContactPage(driver);
		
		//inputdata
		contactPage.Contact(ExcelUtils.getCellData(7,2), 
							ExcelUtils.getCellData(7,3), 
							ExcelUtils.getCellData(7,4), 
							ExcelUtils.getCellData(7,5), 
							ExcelUtils.getCellData(7,6));
		Thread.sleep(10000);
		//actualtext
		
		String actualSuccessSM = contactPage.getSuccessSendmail();
		
		//checkpoint
		if (expectedSuccessfully.equals(actualSuccessSM)
			){
	           System.out.print("passed! \r" );
	           Assert.assertTrue(true);
	           ExcelUtils.setCellData(7, 8, "Passed");
			}
			else {
				System.out.print("failed! \r" );
				Assert.assertTrue(false);
				ExcelUtils.setCellData(7, 8, "Failed");
			}
		ExcelUtils.closeandsaveFile(".\\Data\\FunctionalTestCase-Contact.xlsx");

	}
}
