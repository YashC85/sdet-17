package com.crm.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModuleManagerOrganizationPage {
	public ModuleManagerOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Module Manager")
	private WebElement ModuleManagerBtn;

	public WebElement getModuleManagerBtn() {
		return ModuleManagerBtn;
	} 
	
	public String getModuleManagerText()
	{
		return ModuleManagerBtn.getText();
	}

}
