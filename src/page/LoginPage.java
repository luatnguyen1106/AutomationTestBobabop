package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage  {

private WebDriver driver;
	
	private By maildn = By.xpath("//input[@id='maildangnhap']");
	private By passdn = By.xpath("//input[@id='dnpassword']");
	private By btndn = By.xpath("//input[@id='dangnhap']");
	
	private By errorEmailtext = By.xpath("//li[contains(text(),'Địa chỉ mail hoặc định dạng không đúng.')]");
	private By errorMessagetext = By.xpath("//body/footer[1]/div[3]/div[1]/div[1]/div[2]");
	private By passMesstext = By.xpath("//body/div[5]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]");
	public LoginPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public void Login(String username , String password) throws Exception {
		enterEmail(username);
		enterPassword(password);
		clickSignIn();
		Thread.sleep(2000);
	}
	
	
		
	
	
	public void enterEmail(String email) {
		WebElement emailTxtBox = driver.findElement(maildn);
		if (emailTxtBox.isDisplayed())
			emailTxtBox.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		WebElement passwordTxtBox = driver.findElement(passdn);
		if (passwordTxtBox.isDisplayed())
			passwordTxtBox.sendKeys(password);
	}
	
	public void clickSignIn() {
		WebElement signin = driver.findElement(btndn);
		if (signin.isDisplayed()) {
			signin.click();
		}
	}
	
	public String getErrorMessWrong() {
		String strErrorMsg = null;
		WebElement errorMsg = driver.findElement(errorMessagetext);
		if (errorMsg.isDisplayed() && errorMsg.isEnabled())
			strErrorMsg = errorMsg.getText();
		return strErrorMsg;
	}
	public String getErrorMessageMail() {
		String strErrorMsg2 = null;
		WebElement errorMsg2 = driver.findElement(errorEmailtext);
		if (errorMsg2.isDisplayed() && errorMsg2.isEnabled())
			strErrorMsg2 = errorMsg2.getText();
		return strErrorMsg2;
	}
	public String getPassMessageMail() {
		String strPassMsg2 = null;
		WebElement PassMsg2 = driver.findElement(passMesstext);
		if (PassMsg2.isDisplayed() && PassMsg2.isEnabled())
			strPassMsg2 = PassMsg2.getText();
		return strPassMsg2;
	}
}
