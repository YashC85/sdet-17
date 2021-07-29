package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.crm.vtiger.pom.LoginPage;

public class Repository {
		
	@Test
	public void repoTest()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		
		LoginPage repo = PageFactory.initElements(driver, LoginPage.class);
		
		driver.navigate().refresh();
//		repo.getUsername().sendKeys("admin");
//		repo.getPassword().sendKeys("admin");
//		repo.getLoginBtn().click();
		
		//		OR
		
		repo.login("admin", "admin");
		driver.close();		
	}
}
