package com.crm.vtigerTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.JavaUtils;
import com.crm.vtiger.GenericUtils.PropertyUtil;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateOrgWithIndustry {
	@Test
	public void createOrg() throws Throwable {
		PropertyUtil pu = new PropertyUtil();
		String url = pu.getPropertyKeyValue("url");
		String un = pu.getPropertyKeyValue("username");
		String pw = pu.getPropertyKeyValue("password");
				
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
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("TYSS_"+JavaUtils.getRandomData());
		
		//selecting industry
		WebElement ele = driver.findElement(By.name("industry"));
		wu.selectOptionByValue(ele, "Banking");
		
		//saving the info
		driver.findElement(By.name("button")).click();
		
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
