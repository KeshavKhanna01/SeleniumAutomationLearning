package com.tutorialsninja.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

	WebDriver driver;
	
	//locators
	
	private By validHpProduct = By.linkText("HP LP3065");
	private By invalidProduct = By.xpath("//div[@id='content']/h2/following-sibling::p");
	
	public SearchPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean displayStatusofValidHpProduct() {
		boolean status = driver.findElement(validHpProduct).isDisplayed();
		return status;
	}
	 public String displayStatusofInValidHpProduct() {
		 String x =driver.findElement(invalidProduct).getText();
		 return x;
	 }
}
