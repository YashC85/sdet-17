package com.crm.vtigerTests;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.PropertyUtil;
import com.crm.vtiger.GenericUtils.WebDriverUtility;
import com.crm.vtiger.pom.HomePage;
import com.crm.vtiger.pom.LoginPage;
import com.crm.vtiger.pom.ModuleManagerOrganizationPage;
import com.crm.vtiger.pom.OrganizationPage;

public class OrganisationSettingsTest {
	@Test
	public void organisationSettings() throws Throwable
	{
	//
	PropertyUtil pu = new PropertyUtil();
	String url = pu.getPropertyKeyValue("url");
	String un = pu.getPropertyKeyValue("username");
	String pwd = pu.getPropertyKeyValue("password");
	
	//launch the browser
	WebDriver driver = new ChromeDriver();	
	driver.get(url);
	WebDriverUtility wu = new WebDriverUtility(); 
	wu.waitUntilPageLoad(driver);
	
	
	//perform login operation
	LoginPage lp = new LoginPage(driver);
	lp.login(un, pwd);
	
	//clicking organisations link
	HomePage hp = new HomePage(driver);
	hp.clickOnOrganization();

	//clicking organisation settings button
	OrganizationPage op = new OrganizationPage(driver);
	op.clickOnOrganisationSettingsBtn();
	
//	//verification
	ModuleManagerOrganizationPage modManPage = new ModuleManagerOrganizationPage(driver);
	String actualPage =	modManPage.getModuleManagerText();
	Assert.assertTrue(actualPage, true);
	
	
	hp.signOut(driver);
	driver.close();

	}	
	
}
