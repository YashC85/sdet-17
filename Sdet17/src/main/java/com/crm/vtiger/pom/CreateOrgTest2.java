package com.crm.vtiger.pom;

import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.JavaUtils;

public class CreateOrgTest2 extends BaseClass{
	@Test
	public void createOrg() throws Throwable
	{
	//fetch the data
		String OrgName = eu.getExcelData("sheet1","TC_01","OrgName")+JavaUtils.getRandomData();
		
//	String orgName = eu.getExcelData("Sheet1", "TC_01", "OrgName");
//	String indusName = eu.getExcelData("sheet1", "TC_02", "IndustryType")+JavaUtils.getRandomData();
//	wu.waitUntilPageLoad(driver);
	
	System.out.println(OrgName);
//	System.out.println(indusName);
	//navigate to organization
//	hp = new HomePage(driver);
//	hp.clickOnOrganization();
//	
//	//navigate to createOrganization 
//	OrganizationPage op = new OrganizationPage(driver);
//	op.clickOnCreateOrganisationImg();
//	
//	//enter Mandatory fields
//	CreateOrganizationPage cp = new CreateOrganizationPage(driver);
//	cp.createOrganisation(orgName, indusName);
	

			
			
			
}
}