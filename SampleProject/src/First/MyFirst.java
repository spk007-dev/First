package First;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageObject.PageObjects;
import CommonClass.CommonMethods;

public class MyFirst {

	WebDriver driver;
	PageObjects pageobject;
	CommonMethods commonmethods;
	
	String actualtitle;
	String expecttitle;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.edge.driver", "C:\\Users\\skar1\\Downloads\\edgedriver_win32\\msedgedriver.exe");
		driver=new EdgeDriver();
		driver.get("www.amazon.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@Test(priority = 1)
	 void titleValidation()
	{
		actualtitle=driver.getTitle();
		expecttitle="Amazon.com. Spend less. Smile more.";
		Assert.assertEquals(actualtitle, expecttitle);
	}
	
	@Test(priority = 2)
	 void validate_bestseller()
	{
		commonmethods.click(pageobject.all_btn);
		commonmethods.click(pageobject.best_sellers_btn);
		actualtitle=commonmethods.getText(pageobject.best_seller_text);
		expecttitle="Amazon Bestsellers";
		Assert.assertEquals(actualtitle, expecttitle);
	}
	
	@Test(priority = 3)
	void validate_Item()
	{
		commonmethods.input(pageobject.search,"iphone");
		actualtitle= commonmethods.getText(pageobject.search_text);
		expecttitle="iphone";
		Assert.assertEquals(actualtitle, expecttitle);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
