package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegisterPage {

	private WebDriver driver;
	private By fullnameInput = By.name("fullname");
	private By emailInput = By.name("mailaddress");
	private By passwordInput = By.name("dkpassword");
	private By registerBtn = By.name("dangky");
	private By errorfullName = By.xpath("//li[contains(text(),'Vui lòng cho biết họ tên.')]");
	private By errorEmailRegister = By.xpath("//li[contains(text(),'Địa chỉ mail hoặc định dạng không đúng.')]");
	private By errorPassRegister = By.xpath("//li[contains(text(),'Mật khẩu không được để trống.')]");
	private By errorMessageRegister = By.xpath("//*[@id=\"messageDialogResult\"]/div/div/div[2]");
	private By successMessageRegister = By.xpath("//*[@id=\"messageDialogResult\"]/div/div/div[2]");
	
	public RegisterPage(WebDriver driver) {
		this.driver= driver;
	}
	
	public void Register(String fullname, String email, String password) throws Exception {
		enterFullname(fullname);
		enterEmail(email);
		enterPassword(password);
		clickRegister();
		Thread.sleep(1000);//li[contains(text(),'Vui lÃ²ng cho biáº¿t há»� tÃªn.')]
	}
	
	
	public void enterFullname(String fullname) {
		WebElement fullnameTxtBox = driver.findElement(fullnameInput);
		if (fullnameTxtBox.isDisplayed())
			fullnameTxtBox.sendKeys(fullname);
	}
	
	public void enterEmail(String email) {
		WebElement emailTxtBox = driver.findElement(emailInput);
		if (emailTxtBox.isDisplayed())
			emailTxtBox.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		WebElement passwordTxtBox = driver.findElement(passwordInput);
		if (passwordTxtBox.isDisplayed())
			passwordTxtBox.sendKeys(password);
	}
	
	public void clickRegister() {
		WebElement register = driver.findElement(registerBtn);
		if (register.isDisplayed()) {
			register.click();
		}
	}
	
	public String getErrorFullname() {
		String strErrorFn = null;
		WebElement errorFullname = driver.findElement(errorfullName);
		if (errorFullname.isDisplayed() && errorFullname.isEnabled())
			strErrorFn = errorFullname.getText();
		return strErrorFn;
	}
	
	public String getErrorMessage() {
        String strErrorMsg = null;
        WebElement errorMessage = driver.findElement(errorMessageRegister);
        if (errorMessage.isDisplayed() && errorMessage.isEnabled())
            strErrorMsg = errorMessage.getText();
        return strErrorMsg;
    }
	
	public String getSuccessMessage() {
		String strSuccessMsg = null;
		WebElement successMessage = driver.findElement(successMessageRegister);
		if (successMessage.isDisplayed() && successMessage.isEnabled())
			strSuccessMsg = successMessage.getText();
		return strSuccessMsg;
	}
	
	public String getErrorEmail() {
		String srtErrorEmail = null;
		WebElement errorEmail = driver.findElement(errorEmailRegister);
		if (errorEmail.isDisplayed() && errorEmail.isEnabled())
			srtErrorEmail = errorEmail.getText();
		return srtErrorEmail;

	}
	
	public String getErrorPassword() {
		String srtErrorPassword = null;
		WebElement errorPassword = driver.findElement(errorPassRegister);
		if (errorPassword.isDisplayed() && errorPassword.isEnabled())
			srtErrorPassword = errorPassword.getText();
		return srtErrorPassword;
	}
	
	public void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}
	
}
	
