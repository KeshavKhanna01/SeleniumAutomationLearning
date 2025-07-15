package com.tutorialsninja.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
	WebDriver driver;
	
	//locators
	private By firstName = By.name("firstname");
	private By LastName = By.name("lastname");
	private By Email = By.id("input-email");
	private By Telephone = By.name("telephone");
	private By inputPassword = By.id("input-password");
	private By inputConfirm = By.id("input-confirm");
	private By newsletterOption = By.xpath("//input[@name='newsletter'][@value='1']");
	private By agreeButton = By.name("agree");
	private By continueButton = By.xpath("//input[@value='Continue']");
	private By existingMailWarning = By.xpath("//div[contains(@class,'alert-dismissible')]");
	
	private By privacyPolicyWarning = By.xpath("//div[contains(@class,'alert-dismissible')]");
	private By firstNameWarning = By.xpath("//input[@id='input-firstname']/following-sibling::div");
	private By lastNameWarning = By.xpath("//input[@id='input-lastname']/following-sibling::div");
	private By emailWarning = By.xpath("//input[@id='input-email']/following-sibling::div");
	private By telephoneWarning = By.xpath("//input[@id='input-telephone']/following-sibling::div");
	private By passwordWarning = By.xpath("//input[@id='input-password']/following-sibling::div");
	
	
	public RegisterPage(WebDriver driver) {
	this.driver = driver;

}
	//action
	public void enterFirstName(String firstname) {
		driver.findElement(firstName).sendKeys(firstname);
	}
	public void enterLastName(String lastname) {
		driver.findElement(LastName).sendKeys(lastname);
	}
	public void enterEmail(String email) {
	driver.findElement(Email).sendKeys(email);
	}
	public void enterPhone(String phone) {
		driver.findElement(Telephone).sendKeys(phone);
	}
	public void enterPassword(String password) {
		driver.findElement(inputPassword).sendKeys(password);
	}
	public void confirmPassword(String password) {
		driver.findElement(inputConfirm).sendKeys(password);
	}
	public void clickNewletterOption() {
		driver.findElement(newsletterOption).click();
	}
	
	public void clickAgree() {
		driver.findElement(agreeButton).click();
	}
	public AccountSuccessPage clickContinue() {
		driver.findElement(continueButton).click();
		return new AccountSuccessPage(driver);
	}
	public String alreadyExistingMail() {
	String alreadyExistingMailmessage=	driver.findElement(existingMailWarning).getText();
	return alreadyExistingMailmessage;
	}
	
public String getPrivacyPolicyWarning() {
	String getPrivacyPolicyWarningmessage = driver.findElement(privacyPolicyWarning).getText();
	return getPrivacyPolicyWarningmessage;
}
public String getFirstNameWarning() {
	String message = driver.findElement(firstNameWarning).getText();
	return message;
}
public String getLastNameWarning() {
	String message = driver.findElement(lastNameWarning).getText();
	return message;
}
public String getEmailWarning() {
	String message = driver.findElement(emailWarning).getText();
	return message;
}
public String getTelephoneWarning() {
	String message = driver.findElement(telephoneWarning).getText();
	return message;
}
public String getPasswordWarning() {
	String message = driver.findElement(passwordWarning).getText();
	return message;
}

public AccountSuccessPage registerWithMandatoryFields(String firstname,String lastname,String email,String phone, String password) {
	driver.findElement(firstName).sendKeys(firstname);
	driver.findElement(LastName).sendKeys(lastname);
	driver.findElement(Email).sendKeys(email);
	driver.findElement(Telephone).sendKeys(phone);
	driver.findElement(inputPassword).sendKeys(password);
	driver.findElement(inputConfirm).sendKeys(password);
	driver.findElement(agreeButton).click();
	driver.findElement(continueButton).click();
	return new AccountSuccessPage(driver);
		
}
public AccountSuccessPage registerWithAllFields(String firstname,String lastname,String email,String phone, String password) {
	driver.findElement(firstName).sendKeys(firstname);
	driver.findElement(LastName).sendKeys(lastname);
	driver.findElement(Email).sendKeys(email);
	driver.findElement(Telephone).sendKeys(phone);
	driver.findElement(inputPassword).sendKeys(password);
	driver.findElement(inputConfirm).sendKeys(password);
	driver.findElement(newsletterOption).click();
	driver.findElement(agreeButton).click();
	driver.findElement(continueButton).click();
	return new AccountSuccessPage(driver);
		
}
public boolean displayWarningMessages (String expectedPolicyWarning,String expectedFirstName,String expectedLastName,String expectedEmail,String expectedTelephone,String expectedPassword) {
	
	boolean actualPolicyWarningmessage = getPrivacyPolicyWarning().contains(expectedPolicyWarning);
	boolean actualFirstNameWarning = getFirstNameWarning().contains(expectedFirstName);
	boolean actualLastNameWarning = getLastNameWarning().contains(expectedLastName);
	boolean actualEmailWarning = getEmailWarning().contains(expectedEmail);
	boolean actualTelWarning = getTelephoneWarning().contains(expectedTelephone);
	boolean actualPasswordWarning = getPasswordWarning().contains(expectedPassword);
	
	return actualPolicyWarningmessage && actualFirstNameWarning	&& actualLastNameWarning && 
			actualEmailWarning && actualTelWarning && actualPasswordWarning;
	

}
	
}
	

