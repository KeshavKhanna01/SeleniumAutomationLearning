package com.tutorialsninja.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountSuccessPage {

	WebDriver driver;
		//locators
	private By accCreatedConfirmationMessage = By.xpath("//div[@id='content']/h1");
	
	public AccountSuccessPage(WebDriver driver) {
	this.driver = driver;

}
	public String accountCreatedConfirmationMessage() {
		String actualMessage =driver.findElement(accCreatedConfirmationMessage).getText();
		return actualMessage;
	}
}
