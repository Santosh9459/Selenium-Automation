package com.training.Medium.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC037_DataproviderInvalidCredeinatil {
	
	private WebDriver driver;
	private String adminURL;
	private AdminLoginPOM adminLoginPOM;
	//private String adminUserName;
	//private String adminPassword;
	private String Username;
	private String Password;
	private String invalidMessage;	
	private int impWait;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		
		//Initialize chrome driver and URL
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		adminURL = properties.getProperty("adminURL");
		
		//Initialize POM variable
		adminLoginPOM = new AdminLoginPOM(driver);
		
				
		Username = properties.getProperty("excelfile1","sheet1");
		Password = properties.getProperty("excelfile1","sheet1");
		
		//Declare Implicit wait
		String impWait = properties.getProperty("implicitWait").toString();
	    
		//Define and initialize screenshot variable
		screenShot = new ScreenShot(driver);		
		
	}

	@BeforeMethod
	public void Llogin() throws Exception {
		
		//Open the browser 
		driver.get(adminURL);
		
		//Declare implicit wait
		driver.manage().timeouts().implicitlyWait(impWait, TimeUnit.MINUTES);
			
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);	
		
		//Capture the final screenshot
		screenShot.captureScreenShot("Verify InvalidCredential Mesaage");
		
		//Close the browser
		//driver.quit(); 
	} 
	
	@BeforeTest
	public void SetUp() throws Exception{
		
		//Initialize and load the properties file
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
	}
	
	
	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String Username, String Password) {
		
		adminLoginPOM.enterUserName(Username);
		adminLoginPOM.enterPassword(Password);
		adminLoginPOM.clickLoginBtn();
		
		String invalidMsg =adminLoginPOM.invalidCredMsg(invalidMessage);
		System.out.println(invalidMsg);
		
	}

	


}
