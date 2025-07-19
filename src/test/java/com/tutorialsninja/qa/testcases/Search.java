package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.SearchPage;
import com.tutorialsninja.qa.pages.homePage;

public class Search extends Base {
	SearchPage searchPage;
	public Search() {
		super();
	}
	public WebDriver driver;
	@BeforeMethod
	public void setup() {
		
		driver= initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		
		
	}

	@AfterMethod
	public void tearDown() {
		
		  if (driver != null) {
		        driver.quit();
		    }else {
		        System.out.println("Driver is null in tearDown()");
		    }
	}
	@Test(priority=1)
	
	public  void verifySearchWithValidProduct() {
		
		homePage HomePage = new homePage(driver);
		
		HomePage.search(dataProp.getProperty("validProduct"));
		searchPage= HomePage.clickSearchButton();
		
		//driver.findElement(By.xpath("//button[contains(@class,'btn btn-default btn-lg')]")).click();// or descendant example: //div[@id='search']/descendant::button
		
		Assert.assertTrue(searchPage.displayStatusofValidHpProduct(),"No HP Product is displayed");
}
	@Test(priority=2)
	public void vrifySearchWithInvalidProduct() {
		
		homePage HomePage = new homePage(driver);
		
		HomePage.search(dataProp.getProperty("invalidProduct"));
		searchPage= HomePage.clickSearchButton();
		
		String actualSearchMessage = searchPage.displayStatusofInValidHpProduct();
		Assert.assertEquals(actualSearchMessage,dataProp.getProperty("noProductinSearch"),"Message is not being displayed");
		
	}
	
	@Test(priority=3)
	public void vrifySearchWitoutAnyProduct() {
		//driver.findElement(By.name("search")).sendKeys(""); // not important, directly click on button
		
		homePage HomePage = new homePage(driver);
		searchPage= HomePage.clickSearchButton();
		
		String actualSearchMessage = searchPage.displayStatusofInValidHpProduct();
		Assert.assertEquals(actualSearchMessage,dataProp.getProperty("ProductinSearch"),"Message is not being displayed");
		
	}
}
