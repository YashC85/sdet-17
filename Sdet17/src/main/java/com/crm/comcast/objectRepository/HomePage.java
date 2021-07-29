package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Organizations")
	public WebElement organizationLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	public WebElement adminstativeIMG;
	
	@FindBy(linkText="Sign Out")
	public WebElement signOutLink;

	/**
	 * 
	 * @return Organisation Link
	 */
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	/**
	 * 
	 * @return the add Organization Link
	 */
	public WebElement getAdminstativeIMG() {
		return adminstativeIMG;
	}

	/**
	 * 
	 * @return the sign-out button
	 */
	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	public void clickOnOrganization()
	{
		organizationLink.click();
	}
	
	public void signOut()
	{
		mouseHover(driver, adminstativeIMG);
		signOutLink.click();
	}
	
	

}