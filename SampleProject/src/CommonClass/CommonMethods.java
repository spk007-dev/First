package CommonClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonMethods {

	WebDriver driver;
	WebElement el;
	
	public CommonMethods(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void click(String element)
	{
		el=driver.findElement(By.xpath(element));
		el.click();
	}
	public String getText(String element)
	{
		el=driver.findElement(By.xpath(element));
		return el.getText();
	}
	public void input(String element,String text)
	{
		el=driver.findElement(By.xpath(element));
		el.sendKeys(text);
	}
	
}
