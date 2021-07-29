package com.crm.vtigerTests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
public class CreateContactWithOrganisationTest {

public static void main(String[] args) throws InterruptedException{
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("http://localhost:8888/index.php?action=Login&module=Users");
	
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	
	WebElement ele = driver.findElement(By.name("salutationtype"));
	Select s = new Select(ele);
	s.selectByIndex(1);
	
	driver.findElement(By.name("firstname")).sendKeys("Yash");
	driver.findElement(By.name("lastname")).sendKeys("Chauhan");
	driver.findElement(By.xpath("//img[@alt='Select']")).click();
	
	String parent = driver.getWindowHandle();
	System.out.println(parent);
	
	Set<String> child = driver.getWindowHandles();
	System.out.println(child);
	child.remove(parent);
	
	for(String b:child) {
		driver.switchTo().window(b);
		driver.findElement(By.id("search_txt")).sendKeys("TYSS_01");
		driver.findElement(By.linkText("TYSS_01")).click();		
	}
	driver.switchTo().window(parent);
	
	Thread.sleep(3000);
	driver.findElement(By.name("button")).click();

	Thread.sleep(3000);
	WebElement logo = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions a = new Actions(driver);
	a.moveToElement(logo).perform();

	Thread.sleep(5000);
	driver.findElement(By.linkText("Sign Out")).click();
	Thread.sleep(2000);
	driver.quit();

}
}