package com.crm.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility{
	WebDriverUtility wu;
	
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="accountname")
	private WebElement OrganizationName;

	@FindBy(name="industry")
	private WebElement IndustryDropDown;
	
	@FindBy(name="button")
	private WebElement saveButton;
	
	/**
	 * 
	 * @return the OrganizationName
	 */
	public WebElement getOrganizationName() {
		return OrganizationName;
	}
	
	/**
	 * 
	 * @return the IndustryName
	 */
	public WebElement getIndustryName() {
		return IndustryDropDown;
	}
	
	/**
	 * 
	 * @return the IndustryName
	 */
	public WebElement getSaveBtn() {
		return saveButton;
	}
	

	
	/**
	 * this will enter the OrganizationName
	 * @param orgName
	 */
	public void createOrganisation(String orgName, String industryType)
	{
		OrganizationName.sendKeys(orgName);
		selectOptionByVisibleText(IndustryDropDown, industryType);
		saveButton.click();
	}
	
	/**
	 * This will select the Industry Name
	 * @param orgName
	 * @param industryName
	 */
//	public void EnterIndustryName(String indusName)
//	{
//		wu.selectOptionByVisibleText(IndustryDropDown, indusName);
//	}

}
