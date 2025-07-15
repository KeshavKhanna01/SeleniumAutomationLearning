package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.tutorialsninja.qa.utilities.Utilities;

public class Base {
	
	WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	
	public Base() {
		
		 prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"/src/main/java/com/tutorialsninja/qa/config/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
			}catch(Throwable e) {
				e.printStackTrace();
			}
		
		dataProp= new Properties();
		File propFile2 = new File(System.getProperty("user.dir")+"/src/main/java/com/tutorialsninja/qa/testdata/testdata.properties");
		
		try {
		FileInputStream fis2 = new FileInputStream(propFile2);
		dataProp.load(fis2);}
			catch(Throwable e) {
				e.printStackTrace();
		}
		
		
	}
	public WebDriver initializeBrowserAndOpenApplicationURL(String browser) {
		
		
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
			}
			if(browser.equals("safari")) {
				driver = new SafariDriver();
				}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
			driver.get(prop.getProperty("url"));
		return driver;
		}
}


