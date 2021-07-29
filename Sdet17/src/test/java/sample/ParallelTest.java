package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ParallelTest {
	WebDriver driver;
	@Test
	void logoTest() throws InterruptedException {
		driver = new ChromeDriver();
		
//		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.get("https://google.com/");
		WebElement logo = driver.findElement(By.xpath("//img[@src='/webres_6051af48107ce6.31500353/themes/default/images/login/logo.png']"));
		Assert.assertTrue(logo.isDisplayed());
		Thread.sleep(5000);
	}

	@Test
	void homePageTitle() throws InterruptedException{
		driver = new ChromeDriver();
		
//		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.get("https://facebook.com/");
//		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		driver.getTitle();
		Thread.sleep(5000);
	}
	
	@AfterTest
	void tearDown() {
	driver.quit();
	}

	}
