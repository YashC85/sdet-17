package com.crm.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import bsh.This;

public class LoginPage {			//Rule 1: create separate java class for every single page in an application
	
	public LoginPage(WebDriver driver) //Rule 4: create a single argument constructor to initialize the element.
	{
		PageFactory.initElements(driver, this);
	}

	@FindBys({@FindBy(name="user_name"), @FindBy(xpath="//input[@type='text']")})		//Rule 2: Go to every page in app and identify all the elements using @FindBy / @FindAll / @FindBys and store them in specific Page(class in POM)
	private WebElement username;
	
	@FindBy(name="user_password")
	private WebElement password;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	/**
	 * 
	 * @return the usernameEdit
	 */
	public WebElement getUsername() {		//Rule 3: As per POM, declare all the elements as private and provide public getters to give read access to all the test scripts
		return username;
	}

	/**
	 * 
	 * @return the passwordEdit
	 */
	public WebElement getPassword() {
		return password;
	}

	/**
	 * 
	 * @return the loginBtn
	 */
	public WebElement getLoginBtn() {
		return loginBtn;
	}

	/**
	 * Business logic to Login
	 * @param username
	 * @param password
	 */
	public void login(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
	}
}