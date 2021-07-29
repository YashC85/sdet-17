package com.crm.vtigerTests;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.JavaUtils;
import com.crm.vtiger.GenericUtils.JsonUtil;
import com.crm.vtiger.GenericUtils.PropertyUtil;
import com.crm.vtiger.GenericUtils.WebDriverUtility;
import com.crm.vtiger.pom.CreateOrganizationPage;
import com.crm.vtiger.pom.HomePage;
import com.crm.vtiger.pom.LoginPage;
import com.crm.vtiger.pom.OrganisationInformationPage;
import com.crm.vtiger.pom.OrganizationPage;

public class CreateOrgWithIndustryTest {
	@Test
	public void createOrganisationTest() throws Throwable, ParseException 
	{
		PropertyUtil pu = new PropertyUtil();
		String url = pu.getPropertyKeyValue("url");
		String un = pu.getPropertyKeyValue("username");
		String pwd = pu.getPropertyKeyValue("password");
		
//		JsonUtil ju = new JsonUtil();
//		String url = ju.readDataFromJson("url");
//		String un = ju.readDataFromJson("username");
//		String pwd = ju.readDataFromJson("password");
		
		ExcelUtility eu = new ExcelUtility();
		String organisationName = eu.getExcelData("Sheet1", 3, 2)+JavaUtils.getRandomData();
		String indus = eu.getExcelData("Sheet1", 3, 3);
		
		//launch the browser
		WebDriver driver = new ChromeDriver();
		WebDriverUtility wu = new WebDriverUtility();
		wu.waitUntilPageLoad(driver);
		
		//get URL
		driver.get(url);
		
		//login to application
		LoginPage lp = new LoginPage(driver);
//		lp.getUsername();		//<--this will just click on login after entering only username
//		lp.getLoginBtn();		//<-- this will just click on login button without entering un and pwd
		lp.login(un, pwd);
		
		//navigate to Organization 
		wu.waitUntilPageLoad(driver);
				
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganization();
		
		//navigate to createOrganizationPage
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOnCreateOrganisationImg();
		
		//entering fields and saving
		CreateOrganizationPage cp = new CreateOrganizationPage(driver);
		cp.createOrganisation(organisationName, indus);
		
		//Verification
		OrganisationInformationPage orgInfoPage = new OrganisationInformationPage(driver);
		String actualOrgInfo = orgInfoPage.getOrganisationText();
	
		Assert.assertTrue(actualOrgInfo.contains(organisationName));
		
		//performing sign-out
		hp.signOut(driver);
		driver.close();
	
	}

}
