package com.crm.vtigerTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.PropertyUtil;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class MassEdit {
@Test
public void massEditPage() throws Throwable {
	//getting the values from external file
		PropertyUtil pu = new PropertyUtil();
		String url = pu.getPropertyKeyValue("url");
		String un = pu.getPropertyKeyValue("username");
		String pwd = pu.getPropertyKeyValue("password");
		
	//opening the browser
		WebDriver driver = new ChromeDriver();	

	//entering the url
		driver.get(url);
	
	//waiting for the element to load
		WebDriverUtility wu = new WebDriverUtility();
		wu.waitUntilPageLoad(driver);
	
	//entering un and pwd	
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
	
	//clicking organization and settings button
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.id("19")).click();
		driver.findElement(By.xpath("//input[@value=\"Mass Edit\"]")).click();

	//mouse hovering to logout section
		Thread.sleep(4000);
		WebElement elem = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a = new Actions(driver);
		a.moveToElement(elem).perform();

	//sign out and close
		Thread.sleep(5000);
		WebElement we = driver.findElement(By.linkText("Sign Out"));
		wu.waitAndClick(we);
				
		driver.close();	
		
	}
}