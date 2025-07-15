package com.tutorialsninja.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {

	WebDriver driver;
	
	//Objects
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	private By registerOption = By.linkText("Register");
	
	private By searchOption = By.name("search");
	
	private By searchButton = By.xpath("//button[contains(@class,'btn btn-default btn-lg')]");
	
	public homePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void clickOnMyAccount() {
		myAccountDropMenu.click();
	}
	
	public LoginPage selectLoginOption() {
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public LoginPage navigateToLoginPage() { // combined method to navigate to Login page
		myAccountDropMenu.click();
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegisterOption() {
		driver.findElement(registerOption).click();
		return new RegisterPage(driver);
}
	public RegisterPage navigateToRegisterPage() { // combined method to navigate to Login page
		myAccountDropMenu.click();
		driver.findElement(registerOption).click();
		return new RegisterPage(driver);
	}
	
	public void search(String product) {
		driver.findElement(searchOption).sendKeys(product);

	}
	public SearchPage clickSearchButton() {
		driver.findElement(searchButton).click();
		return new SearchPage(driver);
	}
}