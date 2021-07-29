package com.crm.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * @return the createOrganisationLink
	 */
	@FindBy(xpath="//img[@title=\"Create Organization...\"]")
	private	WebElement CreateOrganisationLink;
	
	/**
	 *@return the organisation settings button 
	 */
	@FindBy(xpath="//img[@title=\"Organizations Settings\"]")
	private	WebElement OrganisationSettingsBtn;
	
	public WebElement getOrganisationSettingsBtn() {
		return OrganisationSettingsBtn;
	}

	public WebElement getCreateOrganisationLink() {
		return CreateOrganisationLink;
	}

	public void clickOnOrganisationSettingsBtn() 
	{
		OrganisationSettingsBtn.click();
	}
	
	public void clickOnCreateOrganisationImg() 
	{
		CreateOrganisationLink.click();
	}
	
}