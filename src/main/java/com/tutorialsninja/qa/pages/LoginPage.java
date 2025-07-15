package com.tutorialsninja.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
//	Locators
	
	private By emailAddressField = By.id("input-email");
	private By passwordField = By.id("input-password");
	private By loginButton = By.xpath("//input[@value='Login']");
	
	private By emailPasswordNotMatching = By.xpath("//div[contains(@class,'alert-dismissible')]");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Actions
	public void enterEmailAddress(String emailText) {
		driver.findElement(emailAddressField).sendKeys(emailText);
		
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
		
	}
	public AccountPage clickLoginButton() {
		driver.findElement(loginButton).click();
		return new AccountPage(driver);
		
	}
	
	public AccountPage login(String emailText,String password) {
		driver.findElement(emailAddressField).sendKeys(emailText);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
		return new AccountPage(driver);
		
	}
	
	public String getEmailWarningNotMatchingMessage() {
		String warningText = driver.findElement(emailPasswordNotMatching).getText();
		return warningText;
	}
}
