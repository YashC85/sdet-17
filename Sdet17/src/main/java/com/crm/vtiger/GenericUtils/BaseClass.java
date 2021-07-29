package com.crm.vtiger.GenericUtils;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.vtiger.pom.HomePage;
import com.crm.vtiger.pom.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public WebDriverUtility wu = new WebDriverUtility();
	public ExcelUtility eu = new ExcelUtility();
	public PropertyUtil pu = new PropertyUtil();
	public HomePage hp;
	
	@BeforeSuite		// here we write code to connect to DB 
	public void configBS()
	{
		System.out.println("connect to DataBase");
	}
	
	@BeforeClass		// here we write code to open the browser
	public void configBC(String browserName)
	{
		if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
	}
	
	@BeforeMethod		// here we setup the variables and provide them values
	public void setup() throws Throwable
	{
		String url = pu.getPropertyKeyValue("url");
		String un = pu.getPropertyKeyValue("username");
		String pwd = pu.getPropertyKeyValue("password");
		driver.get(url);
		
		//login to application
		LoginPage lp = new LoginPage(driver);
		lp.login(un, pwd);		
	}
	
	@AfterMethod		//it will execute just after @Test
	public void tearDown()
	{
		hp.signOut(driver);
	}
	
	@AfterClass			// here we write code to close the driver
	public void configAC() 
	{
		driver.close();
	}

	@AfterSuite			// this will execute at last
	public void configAS()
	{
		System.out.println("Close the connection to DataBase");
	}
}
