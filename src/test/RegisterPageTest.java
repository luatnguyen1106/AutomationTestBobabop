package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import page.RegisterPage;
import utils.ExcelUtils;

@Listeners(test.ListenerTest.class)

public class RegisterPageTest extends AbstractClass {
	boolean checkTestCase;
	private WebDriver driver;
	public RegisterPage registerPage;
	
	@BeforeMethod
	public void setUp() {
		driver = getDriver();
		new ExcelUtils();
	}
	
	@Test(priority = 1)
	public void checkEmptyRegister() throws Exception {
		ExcelUtils.setExcelFile(".\\Data\\FunctionalTestCase-Register.xlsx", "InputData");
		registerPage = new RegisterPage(driver);
		registerPage.Register(ExcelUtils.getCellData(1,2), ExcelUtils.getCellData(1,3),  ExcelUtils.getCellData(1,4));
		String text = registerPage.getErrorFullname();
		String text1 = registerPage.getErrorEmail();
		String text2 = registerPage.getErrorPassword();
		String altertext = "Vui lÃ²ng cho biáº¿t há»� tÃªn.";
		String altertext1 = "Ä�á»‹a chá»‰ mail hoáº·c Ä‘á»‹nh dáº¡ng khÃ´ng Ä‘Ãºng.";
		String altertext2 = "Máº­t kháº©u khÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng.";
//		if (altertext.equals(text) == true && altertext1.equals(text1) == true && altertext2.equals(text2) == true) {
//			this.checkTestCase = true;
//			if (checkTestCase) {
//				Assert.assertTrue(true);
//				System.out.print("Test case is passed! \r" );
//			}
//			else {
//				Assert.assertTrue(false);
//				System.out.print("Test case is failed! \r" );
//			}
//		}
		if(altertext.equals(text) == true && altertext1.equals(text1) && altertext2.equals(text2)) {
			System.out.println("passed! \r");
			Assert.assertTrue(true);
			ExcelUtils.setCellData(1, 6, "Passed");
		}
		else {
			System.out.print("failed! \r" );
			Assert.assertTrue(false);
			ExcelUtils.setCellData(1, 6, "Failed");
		}
		ExcelUtils.closeandsaveFile(".\\Data\\FunctionalTestCase-Register.xlsx");
		
	}
	@Test(priority = 2)
	public void checkEmptyEmailRegister() throws Exception {
//		beforeTest();
		ExcelUtils.setExcelFile(".\\Data\\FunctionalTestCase-Register.xlsx", "InputData");
		registerPage = new RegisterPage(driver);
		registerPage.Register(ExcelUtils.getCellData(2,2), ExcelUtils.getCellData(2,3),  ExcelUtils.getCellData(2,4));
		String text = registerPage.getErrorEmail();
		String text1 = registerPage.getErrorPassword();
		String altertext = "Ä�á»‹a chá»‰ mail hoáº·c Ä‘á»‹nh dáº¡ng khÃ´ng Ä‘Ãºng.";
		String altertext1 = "Máº­t kháº©u khÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng.";
//		if (altertext.equals(text) == true && altertext1.equals(text1) == true) {
//			this.checkTestCase = true;
//			if (checkTestCase) {
//				Assert.assertTrue(true);
//				System.out.print("Test case is passed! \r" );
//			}
//			else {
//				Assert.assertTrue(false);
//				System.out.print("Test case is failed! \r" );
//			}
//		}
		if(altertext.equals(text) == true && altertext1.equals(text1)) {
			System.out.println("passed! \r");
			Assert.assertTrue(true);
			ExcelUtils.setCellData(2, 6, "Passed");
		}
		else {
			System.out.print("failed! \r" );
			Assert.assertTrue(false);
			ExcelUtils.setCellData(2, 6, "Failed");
		}
		ExcelUtils.closeandsaveFile(".\\Data\\FunctionalTestCase-Register.xlsx");	
	}
	
	@Test(priority = 3)
	public void checkEmptyPassRegister() throws Exception {
//		beforeTest();
		ExcelUtils.setExcelFile(".\\Data\\FunctionalTestCase-Register.xlsx", "InputData");
		registerPage = new RegisterPage(driver);
		registerPage.Register(ExcelUtils.getCellData(3,2), ExcelUtils.getCellData(3,3),  ExcelUtils.getCellData(3,4));
		String text = registerPage.getErrorPassword();
		String altertext = "Máº­t kháº©u khÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng.";
//		if ( altertext.equals(text) == true) {
//			this.checkTestCase = true;
//			if (checkTestCase) {
//				Assert.assertTrue(true);
//				System.out.print("Test case is passed! \r" );
//			}
//			else {
//				Assert.assertTrue(false);
//				System.out.print("Test case is failed! \r" );
//			}
//		}
		if(altertext.equals(text) == true) {
			System.out.println("passed! \r");
			Assert.assertTrue(true);
			ExcelUtils.setCellData(3, 6, "Passed");
		}
		else {
			System.out.print("failed! \r" );
			Assert.assertTrue(false);
			ExcelUtils.setCellData(3, 6, "Failed");
		}
		ExcelUtils.closeandsaveFile(".\\Data\\FunctionalTestCase-Register.xlsx");	
	}
	
	@Test(priority = 4)
	public void checkWrongFormatEmailRegister() throws Exception {
//		beforeTest();
		ExcelUtils.setExcelFile(".\\Data\\FunctionalTestCase-Register.xlsx", "InputData");
		registerPage = new RegisterPage(driver);
		registerPage.Register(ExcelUtils.getCellData(4,2), ExcelUtils.getCellData(4,3),  ExcelUtils.getCellData(4,4));
		Thread.sleep(2000);
		String text = registerPage.getSuccessMessage();
		
		String altertext = "Ä�á»‹a chá»‰ mail hoáº·c Ä‘á»‹nh dáº¡ng khÃ´ng Ä‘Ãºng.";
//		if (altertext.equals(text) == true) {
//			this.checkTestCase = true;
//			if (checkTestCase) {
//				Assert.assertTrue(true);
//				System.out.print("Test case is passed! \r" );
//			}
//			else {
//				Assert.assertTrue(false);
//				System.out.print("Test case is failed! \r" );
//			}
//		}
		if(altertext.equals(text) == true) {
			System.out.println("passed! \r");
			Assert.assertTrue(true);
			ExcelUtils.setCellData(4, 6, "Passed");
		}
		else {
			System.out.print("failed! \r" );
			Assert.assertTrue(false);
			ExcelUtils.setCellData(4, 6, "Failed");
		}
		ExcelUtils.closeandsaveFile(".\\Data\\FunctionalTestCase-Register.xlsx");	
	}
	
	@Test(priority = 5)
	public void checkExsitEmailRegister() throws Exception {
//		beforeTest();
		ExcelUtils.setExcelFile(".\\Data\\FunctionalTestCase-Register.xlsx", "InputData");
		registerPage = new RegisterPage(driver);
		registerPage.Register(ExcelUtils.getCellData(5,2), ExcelUtils.getCellData(5,3),  ExcelUtils.getCellData(5,4));
		Thread.sleep(2000);
		String text = registerPage.getErrorMessage();
		String altertext = "Ä�á»‹a chá»‰ mail nÃ y Ä‘Ã£ Ä‘Æ°á»£c sá»­ dá»¥ng, xin vui lÃ²ng Ä‘Äƒng kÃ½ Ä‘á»‹a chá»‰ mail khÃ¡c !";
//		if (altertext.equals(text) == true) {
//			this.checkTestCase = true;
//			if (checkTestCase) {
//				Assert.assertTrue(true);
//				System.out.print("Test case is passed! \r" );
//			}
//			else {
//				Assert.assertTrue(false);
//				System.out.print("Test case is failed! \r" );
//			}
//		}
		if(altertext.equals(text) == true) {
			System.out.println("passed! \r");
			Assert.assertTrue(true);
			ExcelUtils.setCellData(5, 6, "Passed");
		}
		else {
			System.out.print("failed! \r" );
			Assert.assertTrue(false);
			ExcelUtils.setCellData(5, 6, "Failed");
		}
		ExcelUtils.closeandsaveFile(".\\Data\\FunctionalTestCase-Register.xlsx");	
	}
	
	@Test(priority = 6)
	public void checkSuccessLogin() throws Exception {
//		beforeTest();
		ExcelUtils.setExcelFile(".\\Data\\FunctionalTestCase-Register.xlsx", "InputData");
		registerPage = new RegisterPage(driver);
		registerPage.Register(ExcelUtils.getCellData(6,2), ExcelUtils.getCellData(6,3),  ExcelUtils.getCellData(6,4));
		Thread.sleep(2000);
		String text = registerPage.getSuccessMessage();
		String altertext = "Ä�Äƒng kÃ½ thÃ nh cÃ´ng, chÃ o má»«ng báº¡n Ä‘áº¿n vá»›i há»‡ thá»‘ng Bobapop.";
//		if (altertext.equals(text) == true) {
//			this.checkTestCase = true;
//			if (checkTestCase) {
//				Assert.assertTrue(true);
//				System.out.print("Test case is passed! \r" );
//			}
//			else {
//				Assert.assertTrue(false);
//				System.out.print("Test case is failed! \r" );
//			}
//		}
		if(altertext.equals(text) == true) {
			System.out.println("passed! \r");
			Assert.assertTrue(true);
			ExcelUtils.setCellData(6, 6, "Passed");
		}
		else {
			System.out.print("failed! \r" );
			Assert.assertTrue(false);
			ExcelUtils.setCellData(6, 6, "Failed");
		}
		ExcelUtils.closeandsaveFile(".\\Data\\FunctionalTestCase-Register.xlsx");

	}
}
