package com.crm.vtigerTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.PropertyUtil;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateContWithIndustry {
	@Test
	public void createOrg() throws Throwable {
		PropertyUtil pu = new PropertyUtil();
		String url = pu.getPropertyKeyValue("url");
		String un = pu.getPropertyKeyValue("username");
		String pw = pu.getPropertyKeyValue("password");
				
		
		String fn = pu.getPropertyKeyValue("firstname");
		String ln = pu.getPropertyKeyValue("lastname");
				
		//open the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//waiting
		WebDriverUtility wu = new WebDriverUtility();
		wu.waitUntilPageLoad(driver);
		
		//entering url
		driver.get(url);
		
		//entering un and pwd
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pw);
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to Organisation page
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		//entering the fields
		WebElement ele = driver.findElement(By.name("salutationtype"));
		wu.selectOptionByValue(ele, "Mr.");
		driver.findElement(By.name("firstname")).sendKeys(fn);
		driver.findElement(By.name("lastname")).sendKeys(ln);
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		//selecting the organisation
		wu.switchToWindow(driver, "Accounts");
		driver.findElement(By.id("search_txt")).sendKeys("TYSS_01");
		driver.findElement(By.linkText("TYSS_01")).click();	
		
	
		wu.switchToWindow(driver, "Contacts");
		driver.findElement(By.name("button")).click();
		
		//mouse hovering to logout section
		Thread.sleep(4000);
		WebElement elem = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a = new Actions(driver);
		a.moveToElement(elem).perform();

		//sign out and close
//		Thread.sleep(5000);
		WebElement we = driver.findElement(By.linkText("Sign Out"));
		wu.waitAndClick(we);
		driver.quit();
		
	}
}