package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Teas_Page {
	private WebDriver driver;
	
	private By topicKTText = By.xpath("//h2[@class=\"heading\"]");
	
	public Teas_Page(WebDriver driver) {
		this.driver= driver;
	}
	
	public String gettopicKT() {
		String srttopicKT = null;
		WebElement topicKT = driver.findElement(topicKTText);
		if (topicKT.isDisplayed() && topicKT.isEnabled())
			srttopicKT = topicKT.getText();
		return srttopicKT;

	}
	
	public static void selectMenuItemTest(String str, WebDriver driver) {
		WebElement listElement= driver.findElement(By.xpath("//ul[@class='navbar-nav']"));
		List<WebElement> childElements= listElement.findElements(By.xpath("//ul[@class=\"navbar-nav\"]//li/child::a"));
		for (int i=0; i< childElements.size(); i++) {
			if (childElements.get(i).getText().equals(str)) {
				childElements.get(i).click();
				System.out.println("Menu:" +str);
				break;
			}
		}	
	}
}
