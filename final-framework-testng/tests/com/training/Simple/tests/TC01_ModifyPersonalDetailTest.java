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
import com.training.pom.LoginPOM;
import com.training.pom.LoginRetailPOM;
import com.training.pom.MyAccountPOM;
import com.training.pom.PersonalDetailsPOM;
import com.training.pom.UserLinkPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

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
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl = properties.getProperty("baseURL");
		
		userlinkPOM = new UserLinkPOM(driver);
		loginRetailPOM = new LoginRetailPOM(driver); 	
		myAccountPOM = new MyAccountPOM(driver);
		personalDetailsPOM=new PersonalDetailsPOM(driver);
		
		userEmailID = properties.getProperty("UserName");
		password = properties.getProperty("Password");
		userFirstName = properties.getProperty("UserFirstName");
		userLastName = properties.getProperty("UserLastName");
		useremail = properties.getProperty("Useremail");
		userTelephone = properties.getProperty("UserTelephone");
		
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
	public void selectLogin()
	{
		
		myAccountPOM.clickEditAccountLink();
		personalDetailsPOM.sendFirstName(userFirstName);
		personalDetailsPOM.senduserLastName(userLastName);
		personalDetailsPOM.senduseremail(useremail);
		personalDetailsPOM.senduserTelephone(userTelephone);
		personalDetailsPOM.clickcontinueBtn();	
		String smsg = personalDetailsPOM.displayMsg(successMsg);
		
		System.out.println(smsg);
			
	} 
	

	
	
}
