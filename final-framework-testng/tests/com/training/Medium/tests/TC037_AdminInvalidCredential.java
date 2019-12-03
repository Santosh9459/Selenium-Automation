//To verify whether application denies admin getting logged in upon entering invalid credentials in required field

package com.training.Medium.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminAddProdPOM;
import com.training.pom.AdminDashboadPOM;
import com.training.pom.AdminLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

//Define variable and POM
public class TC037_AdminInvalidCredential {
	private WebDriver driver;
	private String adminURL;
	private AdminLoginPOM adminLoginPOM;
	private String adminUserName;
	private String adminPassword;
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
		
		//Initialize property file variables
		adminUserName = properties.getProperty("InvalidUserName");
		adminPassword = properties.getProperty("InvalidPassword");
		
		//Declare Implicit wait
		String impWait = properties.getProperty("implicitWait").toString();
	    
		////Define and initialize screenshot variable
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
		driver.quit(); 
	} 
	
	@BeforeTest
	public void SetUp() throws Exception{
		
		//Initialize and load the properties file
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
	}

	@Test	
	public void selectLogin() throws InterruptedException
	{
		//enter credentials in Username textbox	
		adminLoginPOM.enterUserName(adminUserName);
		
		//enter credentials in Password textbox
		adminLoginPOM.enterPassword(adminPassword);
		
		//click on Login button
		adminLoginPOM.clickLoginBtn();
		
		//display the invalid credential message
		adminLoginPOM.invalidCredMsg(invalidMessage);        
		
	    //Capture the success message
		String invalidMsg =adminLoginPOM.invalidCredMsg(invalidMessage);		
		
		//Print the message on the console
		System.out.println(invalidMsg); 
		
		//Verify the Invalid Credential message
		if(invalidMsg.contains(" Success: You have modified products! ")){
			System.out.println("Expected Text is obtained");
		}else{
			System.out.println("Expected Text is not obtained");
		}		
		
		
	}	
	
}
