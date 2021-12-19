package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ContactPage {
	private WebDriver driver;
	private By fullNameInput = By.name("fullname");
	private By emailInput = By.name("mailaddress");
	private By phoneInput = By.name("phonenumber");
	private By addressInput = By.name("address");
	private By messageInput = By.name("detailcontact");
	private By Sendbtn = By.name("sendmail");
	
	private By errorEmailtext = By.xpath("//span[@class=\"help-block with-errors\"]//ul//li[text()=\"Địa chỉ mail hoặc định dạng không đúng.\"]");
	private By errorFullnametext = By.xpath("//span[@class=\"help-block with-errors\"]//ul//li[text()=\"Vui lòng cho biết họ tên.\"]");
	private By errorPhonetext = By.xpath("//span[@class=\"help-block with-errors\"]//ul//li[text()=\"Vui lòng cho biết số điện thoại.\"]");
	private By errorAddresstext = By.xpath("//form[@id=\"contactForm\"]/div/div/div[2]/div[4]/span/ul/li");
	private By SuccessSendmailText = By.xpath("//div[@id=\"messageDialog\"]//div[@class=\"modal-body\"]");
	
	public ContactPage(WebDriver driver) {
		this.driver= driver;
	}
	
	public void Contact(String fullname, String email, String phone, String address, String message) throws Exception {
		enterFullname(fullname);
		enterEmail(email);
		enterPhone(phone);
		enterAddress(address);
		enterMessage(message);
		clickSendmail();
		Thread.sleep(1000);
	}
	//entervalue
	public void enterFullname(String fullname) {
		WebElement fullNameTxtBox = driver.findElement(fullNameInput);
		if (fullNameTxtBox.isDisplayed())
			fullNameTxtBox.sendKeys(fullname);
	}
	public void enterEmail(String email) {
		WebElement emailTxtBox = driver.findElement(emailInput);
		if (emailTxtBox.isDisplayed())
			emailTxtBox.sendKeys(email);
	}
	public void enterPhone(String phone) {
		WebElement phoneTxtBox = driver.findElement(phoneInput);
		if (phoneTxtBox.isDisplayed())
			phoneTxtBox.sendKeys(phone);
	}
	public void enterAddress(String address) {
		WebElement addressTxtBox = driver.findElement(addressInput);
		if (addressTxtBox.isDisplayed())
			addressTxtBox.sendKeys(address);
	}
	public void enterMessage(String message) {
		WebElement addressTxtBox = driver.findElement(messageInput);
		if (addressTxtBox.isDisplayed())
			addressTxtBox.sendKeys(message);
	}
	//clickbutton
	public void clickSendmail() {
		WebElement signin = driver.findElement(Sendbtn);
		if (signin.isDisplayed()) {
			signin.click();
		}
	}
	//getError
	public String getErrorFullname() {
		String srtErrorFullname = null;
		WebElement errorFullname = driver.findElement(errorFullnametext);
		if (errorFullname.isDisplayed() && errorFullname.isEnabled())
			srtErrorFullname = errorFullname.getText();
		return srtErrorFullname;

	}
	
	public String getErrorEmail() {
		String srtErrorEmail = null;
		WebElement errorEmail = driver.findElement(errorEmailtext);
		if (errorEmail.isDisplayed() && errorEmail.isEnabled())
			srtErrorEmail = errorEmail.getText();
		return srtErrorEmail;

	}
	
	public String getErrorPhone() {
		String srtErrorPhone = null;
		WebElement errorPhone = driver.findElement(errorPhonetext);
		if (errorPhone.isDisplayed() && errorPhone.isEnabled())
			srtErrorPhone = errorPhone.getText();
		return srtErrorPhone;

	}
	
	public String getErrorAddress() {
		String srtErrorAddress = null;
		WebElement errorAddress = driver.findElement(errorAddresstext);
		if (errorAddress.isDisplayed() && errorAddress.isEnabled())
			srtErrorAddress = errorAddress.getText();
		return srtErrorAddress;

	}
	
	public String getSuccessSendmail() {
		String srtSuccessSendmail = null;
		WebElement SuccessSendmail = driver.findElement(SuccessSendmailText);
		if (SuccessSendmail.isDisplayed() && SuccessSendmail.isEnabled())
			srtSuccessSendmail = SuccessSendmail.getText();
		return srtSuccessSendmail;

	}
	
	public static void selectMenuItemTest(String str, WebDriver driver) {
		WebElement listElement= driver.findElement(By.xpath("//ul[@class='navbar-nav']"));
		List<WebElement> childElements= listElement.findElements(By.xpath("//ul[@class=\"navbar-nav\"]//li/child::a"));
		for (int i=0; i< childElements.size(); i++) {
			if (childElements.get(i).getText().equals(str)) {
				childElements.get(i).click();
				
				break;
			}
		}	
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
