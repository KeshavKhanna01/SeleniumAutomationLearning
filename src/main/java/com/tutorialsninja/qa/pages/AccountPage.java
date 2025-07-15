package com.tutorialsninja.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
	WebDriver driver;
	
	//locators
	private By editYourAccountInformation = By.linkText("Edit your account information");
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		
	}
	//action
	public boolean getDisplayStatusOfEditYourAccountInformation() {
		boolean displayStatus = driver.findElement(editYourAccountInformation).isDisplayed();
		return displayStatus;
	}
}
