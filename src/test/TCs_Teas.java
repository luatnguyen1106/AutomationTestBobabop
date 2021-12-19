package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.Teas_Page;

public class TCs_Teas extends AbstractClass{
	private  WebDriver driver;
	public Teas_Page TeasKTPage;
	
	
	@BeforeMethod
	public void setUp() {
		driver = getDriver();
		Teas_Page.selectMenuItemTest("Teas", driver);
	}
	
	
	@Test(priority = 1)
	public void CheckProduct_KemTuyet() throws Exception {
		//div[@class="row gutter-10 gutter-md-20-md"]//div/child::a[@class="thumbnail minheight"]
		TeasKTPage = new Teas_Page(driver);
		Teas_Page.selectMenuItemTest("Kem Tuyết", driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		String str = "Kem Tuyết";
		WebElement listElement= driver.findElement(By.xpath("//div[@class=\"row gutter-10 gutter-md-20-md\"]"));
		List<WebElement> childElements= listElement.findElements(By.xpath("//div[@class=\"row gutter-10 gutter-md-20-md\"]//div/child::a[@class=\"thumbnail minheight\"]//h5"));
		
		for (int i=0; i< childElements.size(); i++) {
			if (childElements.get(i).getText().contains(str)) {
				System.out.println("passed! " +childElements.get(i).getText()+" "+(i+1));
			}
			else {
				System.out.println("failed! " +childElements.get(i).getText()+" "+(i+1));
			}
		}
		
	}
	
	@Test(priority = 2)
	public void CheckProduct_TraSua_Page1() throws Exception {
		//div[@class="row gutter-10 gutter-md-20-md"]//div/child::a[@class="thumbnail minheight"]
		TeasKTPage = new Teas_Page(driver);
		Teas_Page.selectMenuItemTest("Trà Sữa", driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)", "");
		Thread.sleep(2000);
		String str = "Trà Sữa";	
		WebElement listElement= driver.findElement(By.xpath("//div[@class=\"row gutter-10 gutter-md-20-md\"]"));
		List<WebElement> childElements= listElement.findElements(By.xpath("//div[@class=\"row gutter-10 gutter-md-20-md\"]//div/child::a[@class=\"thumbnail minheight\"]//h5"));
		
		
		for (int i=0; i< childElements.size(); i++) {
			
			if (childElements.get(i).getText().contains(str)) {
				System.out.println("passed! " +childElements.get(i).getText()+" "+(i+1));
				
			}
			else {
				System.out.println("failed! " +childElements.get(i).getText()+" "+(i+1));
			}
			
		}
		
	}
	
	@Test(priority = 3)
	public void CheckProduct_TraSua_Page2() throws Exception {
		//div[@class="row gutter-10 gutter-md-20-md"]//div/child::a[@class="thumbnail minheight"]
		TeasKTPage = new Teas_Page(driver);
		Teas_Page.selectMenuItemTest("Trà Sữa", driver);
		WebElement nextButton = driver.findElement(By.xpath("//a[@class=\"next page-numbers\"]"));
		nextButton.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)", "");
		Thread.sleep(2000);
		String str = "Trà Sữa";	
		WebElement listElement= driver.findElement(By.xpath("//div[@class=\"row gutter-10 gutter-md-20-md\"]"));
		List<WebElement> childElements= listElement.findElements(By.xpath("//div[@class=\"row gutter-10 gutter-md-20-md\"]//div/child::a[@class=\"thumbnail minheight\"]//h5"));
		
		
		for (int i=0; i< childElements.size(); i++) {
			
			if (childElements.get(i).getText().contains(str)) {
				System.out.println("passed! " +childElements.get(i).getText()+" "+(i+1));
				
			}
			else {
				System.out.println("failed! " +childElements.get(i).getText()+" "+(i+1));
			}
			
		}
		
	}
	@Test(priority = 4)
	public void CheckProduct_SuiBot() throws Exception {
		//div[@class="row gutter-10 gutter-md-20-md"]//div/child::a[@class="thumbnail minheight"]
		TeasKTPage = new Teas_Page(driver);
		Teas_Page.selectMenuItemTest("Trà Sủi Bọt", driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		String str = "Sủi Bọt";
		WebElement listElement= driver.findElement(By.xpath("//div[@class=\"row gutter-10 gutter-md-20-md\"]"));
		List<WebElement> childElements= listElement.findElements(By.xpath("//div[@class=\"row gutter-10 gutter-md-20-md\"]//div/child::a[@class=\"thumbnail minheight\"]//h5"));
		
		for (int i=0; i< childElements.size(); i++) {
			if (childElements.get(i).getText().contains(str) || childElements.get(i).getText().toLowerCase().equalsIgnoreCase(str.toLowerCase())) {
				System.out.println("passed! " +childElements.get(i).getText() + " "+(i+1));
			}
			else {
				System.out.println("failed! " +childElements.get(i).getText() + " "+(i+1));
//				System.out.println(childElements.get(i).getText().toLowerCase());
//				System.out.println(str.toLowerCase());
			}
		}
		
	}
	
}
