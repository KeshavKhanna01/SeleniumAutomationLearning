package com.tutorialsninja.qa.testcases;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.pages.homePage;
import com.tutorialsninja.qa.utilities.Utilities;

public class Register extends Base{
	public Register() {
		super();
	}
WebDriver driver;
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;
	
	@BeforeMethod
	public void setup() {
		driver= initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		homePage HomePage = new homePage(driver);
		registerPage=HomePage.navigateToRegisterPage();
		}

	@AfterMethod
	public void tearDown() {
	
		driver.quit();
	}
	
	@Test(priority=1)
	public void VerifyRegisteringAnAccountWithMandatoryFields() throws InterruptedException {
		
		accountSuccessPage= registerPage.registerWithMandatoryFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Utilities.generateTimeStamp(), dataProp.getProperty("cell"), prop.getProperty("validPassword"));
		
		Thread.sleep(2000);

//	    String actualMessage = accountSuccessPage.accountCreatedConfirmationMessage();
//	    System.out.print(actualMessage);
		Assert.assertEquals(accountSuccessPage.accountCreatedConfirmationMessage(),dataProp.getProperty("accountSuccessfullyCreatedMessage"), "Account not created");
		
		
	}
	@Test(priority=2)
	public void VerifyRegisteringAnAccountWithAllFields() {
		
		accountSuccessPage = registerPage.registerWithAllFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Utilities.generateTimeStamp(), dataProp.getProperty("cell"), prop.getProperty("validPassword"));
			

	   // String actualMessage = accountSuccessPage.accountCreatedConfirmationMessage();
		Assert.assertEquals(accountSuccessPage.accountCreatedConfirmationMessage(),dataProp.getProperty("accountSuccessfullyCreatedMessage"), "Account not created");
	
		
	}
	@Test(priority=3)
	public void VerifyRegisteringAnAccountWithExistingEmailAddress() {
		
		registerPage.registerWithAllFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), prop.getProperty("validEmail"), dataProp.getProperty("cell"), prop.getProperty("validPassword"));
		
//	    String actualWarning = registerPage.alreadyExistingMail();
//	    System.out.print(actualWarning);
	    
		Assert.assertTrue(registerPage.alreadyExistingMail().contains(dataProp.getProperty("duplicateEmailWarnig")),"Warning Message Not Displayed");
	
		
	}
	
	@Test(priority=4)
	public void VerifyRegisteringAnAccountWithoutFillingAnyDetails() {
		
		
		registerPage.clickContinue();
		
		registerPage.displayWarningMessages(dataProp.getProperty("privacyPolicyWarning"), dataProp.getProperty("firstNameWarning"), dataProp.getProperty("lastNameWarning"), dataProp.getProperty("emailAddressWarning"), dataProp.getProperty("telephoneWarning"), dataProp.getProperty("passwordWarning"));
		
	
//		
//		String actualFirstNamewarning= registerPage.getFirstNameWarning();
//		Assert.assertEquals(actualFirstNamewarning,dataProp.getProperty("firstNameWarning"),"First Name warning not displayed");
//		
//		String actualLastNamewarning= registerPage.getLastNameWarning();
//		Assert.assertEquals(actualLastNamewarning,dataProp.getProperty("lastNameWarning"),"Last Name warning not displayed");
//		
//		String actualEmailWarning= registerPage.getEmailWarning();
//		Assert.assertEquals(actualEmailWarning,dataProp.getProperty("emailAddressWarning"),"Email warning not displayed");
//		
//		String TelephoneWarning= registerPage.getTelephoneWarning();
//		Assert.assertEquals(TelephoneWarning,dataProp.getProperty("telephoneWarning"),"Telephone warning not displayed");
//			
//		String PasswordWarning= registerPage.getPasswordWarning();
//		Assert.assertEquals(PasswordWarning,dataProp.getProperty("passwordWarning"),"Password warning not displayed");
		
		
	}

}
