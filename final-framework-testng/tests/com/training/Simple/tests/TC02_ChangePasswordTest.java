//TC02_To verify whether application allows user to change the password in Change Your Password page

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
import com.training.pom.LoginRetailPOM;
import com.training.pom.MyAccountPOM;
import com.training.pom.PersonalDetailsPOM;
import com.training.pom.UserLinkPOM;
import com.training.pom.YourPasswordPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


	
public class TC02_ChangePasswordTest {
	
	//Define variable and POM
	private WebDriver driver;
	private String baseUrl;
	private String adminURL;
	private UserLinkPOM userlinkPOM;
	private LoginRetailPOM loginRetailPOM;	
	private MyAccountPOM myAccountPOM;
	private YourPasswordPOM yourPasswordPOM;
	
	private String userEmailID;
	private String password;
	private String pswSucsMsg;
	private String userPassword;
	private String enterPassword;
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
		yourPasswordPOM=new YourPasswordPOM(driver);
		//Initialize property file variables
		userEmailID = properties.getProperty("UserName");
		password = properties.getProperty("Password");
		userPassword = properties.getProperty("UserPassword");
		enterPassword = properties.getProperty("EnterPassword");
		
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
		//user should able to login to the retail application
		Thread.sleep(1000);
		
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
	public void changePassword() throws Exception
	{
		//Open the change password page
		myAccountPOM.clickChngPswLink();
		//Provide the password in the edit box
		yourPasswordPOM.enterUserPsw(userPassword);
		yourPasswordPOM.enterConfirmfPsw(enterPassword);	
		//Click on the continue button
		yourPasswordPOM.clickcontinueBtn();
		//user should able to get error message
        Thread.sleep(1000);
        //Verify the message
		String expectation ="Success: Your password has been successfully updated.";
		String actual =  myAccountPOM.pswSuccessMsg(pswSucsMsg);
		//Verification should performed
		Assert.assertEquals(expectation,actual);
		//Print the Actual message on console
		System.out.println(actual);
			
	} 
		
	

}
