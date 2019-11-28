//TC01_To verify whether application allows user to modify the details  in Your Personal Details Page

package com.training.Simple.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.LoginRetailPOM;
import com.training.pom.MyAccountPOM;
import com.training.pom.PersonalDetailsPOM;
import com.training.pom.UserLinkPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

//Define variable and POM
public class TC01_ModifyPersonalDetailTest {
	private WebDriver driver;
	private String baseUrl;
	private String adminURL;
	private UserLinkPOM userlinkPOM;
	private LoginRetailPOM loginRetailPOM;	
	private MyAccountPOM myAccountPOM;
	private PersonalDetailsPOM personalDetailsPOM;
	private String userEmailID;
	private String password;
	private String userFirstName;
	private String userLastName;
	private String useremail;
	private String userTelephone;
	private String successMsg;
	private String expectation;
	private String actual;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass

	public void setUpBeforeClass() throws IOException {
		//Initialize chrome driver and URL 
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl = properties.getProperty("baseURL");
		//Initialize POM variable
		userlinkPOM = new UserLinkPOM(driver);
		loginRetailPOM = new LoginRetailPOM(driver); 	
		myAccountPOM = new MyAccountPOM(driver);
		personalDetailsPOM=new PersonalDetailsPOM(driver);
		//Initialize property file variables
		userEmailID = properties.getProperty("UserName");
		password = properties.getProperty("Password");
		userFirstName = properties.getProperty("UserFirstName");
		userLastName = properties.getProperty("UserLastName");
		useremail = properties.getProperty("Useremail");
		userTelephone = properties.getProperty("UserTelephone");
		
		screenShot = new ScreenShot(driver);
		
	}

	@BeforeMethod
	public void Llogin() throws Exception {
		
		// open the browser 
		driver.get(baseUrl);
		//Open the login page
		userlinkPOM.GotoLoginPage();
		//Provide the login credenital
		loginRetailPOM.sendUserName(userEmailID);
		loginRetailPOM.sendPassword(password);
		//Click on login button
		loginRetailPOM.clickLoginBtn();
		Thread.sleep(1000);
		//user should able to login to the retail application
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		
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
	public void selectLogin() throws Exception
	{
		//Open the Edit your account information page
		myAccountPOM.clickEditAccountLink();
		//Enter the details in all the edit box
		personalDetailsPOM.sendFirstName(userFirstName);
		personalDetailsPOM.senduserLastName(userLastName);
		personalDetailsPOM.senduseremail(useremail);
		personalDetailsPOM.senduserTelephone(userTelephone);
		personalDetailsPOM.clickcontinueBtn();	
		//user should able to modify the personal details
          
		Thread.sleep(1000);
		
		//Verify the message
		String expectation ="Success: Your account has been successfully updated.";
		String actual =  personalDetailsPOM.displayMsg(successMsg);
		
       //Verification should performed
		Assert.assertEquals(expectation,actual);
		
		//Print the Actual message on console
		System.out.println(actual);
		
	} 
	

	
	
}
