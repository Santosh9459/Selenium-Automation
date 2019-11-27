package com.training.Simple.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
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

public class TC03_PasswordMismatch {
	private WebDriver driver;
	private String baseUrl;
	private String adminURL;
	private UserLinkPOM userlinkPOM;
	private LoginRetailPOM loginRetailPOM;	
	private MyAccountPOM myAccountPOM;
	private YourPasswordPOM yourPasswordPOM;
	
	private String userEmailID;
	private String password;
	private String errorMsg;
	private String userPassword;
	private String confirmPassword;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl = properties.getProperty("baseURL");
		
		userlinkPOM = new UserLinkPOM(driver);
		loginRetailPOM = new LoginRetailPOM(driver); 	
		myAccountPOM = new MyAccountPOM(driver);
		yourPasswordPOM=new YourPasswordPOM(driver);
		
		userEmailID = properties.getProperty("UserName");
		password = properties.getProperty("Password");
		userPassword = properties.getProperty("UserPassword");
		confirmPassword = properties.getProperty("ConfirmPassword");
		
		screenShot = new ScreenShot(driver);
		
	}

	@BeforeMethod
	public void Llogin() {
		
		// open the browser 
		driver.get(baseUrl);
		
		userlinkPOM.GotoLoginPage();
		loginRetailPOM.sendUserName(userEmailID);
		loginRetailPOM.sendPassword(password);
		loginRetailPOM.clickLoginBtn();
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	} 
	
	@BeforeTest
	public void SetUp() throws Exception{
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
	}

	@Test	
	public void changePassword()
	{
		
		myAccountPOM.clickChngPswLink();
		yourPasswordPOM.enterUserPsw(userPassword);
		yourPasswordPOM.ConfirmPassword(confirmPassword);
		yourPasswordPOM.clickcontinueBtn();
		
		String msg = yourPasswordPOM.displayErrorMsg(errorMsg);		
		
		System.out.println(msg);
			
	} 

}
