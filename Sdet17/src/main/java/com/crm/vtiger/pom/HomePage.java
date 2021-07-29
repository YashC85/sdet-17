package com.crm.vtiger.pom;

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
	private WebElement organizationLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;

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
	public WebElement getAdminstratorImg() {
		return adminstratorImg;
	}

	/**
	 * 
	 * @return the sign-out button
	 */
	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	
	
	
	/**
	 * It will click on organization link
	 */
	
	public void clickOnOrganization()
	{
		organizationLink.click();
	}
	
	/**
	 * It will mouseHover to Administrative button and click on signOut button
	 */
	public void signOut(WebDriver driver)
	{
		mouseHover(driver, adminstratorImg);
		signOutLink.click();
	}
	
	

}