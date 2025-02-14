package First;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyFirst {

	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.edge.driver", "C:\\Users\\skar1\\Downloads\\edgedriver_win32\\msedgedriver.exe");
		driver=new EdgeDriver();
		driver.get("google.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@Test
	public void Test1()
	{
		String actualtitle=driver.getTitle();
		String expecttitle="Amazon.com. Spend less. Smile more.";
		Assert.assertEquals(actualtitle, expecttitle);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
