package First;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObject.PageObjects;
import CommonClass.CommonMethods;

public class MyFirst {

	WebDriver driver;
	PageObjects pageobject=new PageObjects();
	CommonMethods commonmethods;
	
	String actualtitle;
	String expecttitle;
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		System.setProperty("webdriver.edge.driver", "C:\\Users\\skar1\\OneDrive - Hitachi Vantara\\Desktop\\edge\\msedgedriver.exe");
		driver=new EdgeDriver();
		commonmethods=new CommonMethods(driver);
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
	}
	@Test
	 void titleValidation()
	{
		actualtitle=driver.getTitle();
		expecttitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		Assert.assertTrue(actualtitle.contains(expecttitle));
	}
	
	@Test
	 void validate_bestseller()
	{
		commonmethods.click(pageobject.all_btn);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		commonmethods.click(pageobject.best_sellers_btn);
		actualtitle=commonmethods.getText(pageobject.best_seller_text);
		expecttitle="Amazon Bestsellers";
		Assert.assertEquals(actualtitle, expecttitle);
	}
	
	
	@Test
	void validate_Item()
	{
		commonmethods.input(pageobject.search,"iphone");
		commonmethods.click(pageobject.search_btn);
		actualtitle= commonmethods.getText(pageobject.search_text);
		expecttitle="iphone";
		Assert.assertTrue(actualtitle.contains(expecttitle));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
