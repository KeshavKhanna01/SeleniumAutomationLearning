package com.tutorialsninja.qa.testcases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.pages.homePage;
import com.tutorialsninja.qa.utilities.Utilities;


public class Login extends Base {
	
	LoginPage loginPage;
	AccountPage accountPage;
	
	public Login() {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver= initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		
		homePage HomePage = new homePage(driver);
		loginPage = HomePage.navigateToLoginPage();
		
	}
	

	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	@Test(priority =1,dataProvider="validCredentials")
	public void verifyLoginWithValidCredentials(String email,String password) {
		
		accountPage = loginPage.login(email,password);

		Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformation(),"Edit your account information");
	}
		
	@DataProvider(name="validCredentials")
	public Object[][] supplyTestData() {
		Object [][] data = (Object[][]) Utilities.getTestDataFromExcel("Sheet1");
				
		return data;
	}
	@Test(priority =2)
		public void verifyLoginWithInvalidCredentials() {
			
			loginPage.login(Utilities.generateTimeStamp(),dataProp.getProperty("invalidPassword"));
			
			//String actualMessage = loginPage.getEmailWarningNotMatchingMessage();
			//String expectedMessage = dataProp.getProperty("emailPasswordNoMatch");
			Assert.assertTrue(loginPage.getEmailWarningNotMatchingMessage().contains(dataProp.getProperty("emailPasswordNoMatch")),"Expected message is not being displayed");
			
		
	}
		
	@Test(priority =3)
		public void verifyLoginWithInvalidEmailAndValidPassword() {
			loginPage.login(Utilities.generateTimeStamp(),dataProp.getProperty("invalidPassword"));
			
//			loginPage.enterEmailAddress(Utilities.generateTimeStamp());
//			loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
//			loginPage.clickLoginButton();
			
			String actualMessage = loginPage.getEmailWarningNotMatchingMessage();
			String expectedMessage = dataProp.getProperty("emailPasswordNoMatch");
			Assert.assertTrue(actualMessage.contains(expectedMessage),"Expected message is not being displayed");
			
		
	}
		
	@Test(priority =4)
		public void verifyLoginWithValidEmailAndInalidPassword() {
	
		   	loginPage.login(Utilities.generateTimeStamp(),dataProp.getProperty("invalidPassword"));
			
			String actualMessage = loginPage.getEmailWarningNotMatchingMessage();
			String expectedMessage = dataProp.getProperty("emailPasswordNoMatch");
			Assert.assertTrue(actualMessage.contains(expectedMessage),"Expected message is not being displayed");
			
			
		
	}
		
	@Test(priority =5)
		public void verifyLoginWithoutProvidingCredentials() {
			

			loginPage.clickLoginButton();
			
			String actualMessage = loginPage.getEmailWarningNotMatchingMessage();
			String expectedMessage = dataProp.getProperty("emailPasswordNoMatch");
			Assert.assertTrue(actualMessage.contains(expectedMessage),"Expected message is not being displayed");
			
		
	}
		
		
	
}
