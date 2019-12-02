//TC035_To Verify whether application allows the user to return ordered product


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
import com.training.pom.AdminAddCategoryPOM;
import com.training.pom.AdminDashboadPOM;
import com.training.pom.AdminLoginPOM;
import com.training.pom.LoginRetailPOM;
import com.training.pom.MyAccountPOM;
import com.training.pom.MyOrderPOM;
import com.training.pom.UserLinkPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

//Define and Initialize variable and POM
public class TC036_VerifyReturnOrderProd {
	private WebDriver driver;
	private String baseUrl;
	private UserLinkPOM userlinkPOM;
	private LoginRetailPOM loginRetailPOM;	
	private MyOrderPOM myOrderPOM;
	
	private String userName;
	private String password;
	private String commentBox;	
	private String submitMsg;
	
	private int impWait;
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
		myOrderPOM = new MyOrderPOM(driver);
		
		//Initialize property file variables
		userName = properties.getProperty("UserName");
		password = properties.getProperty("Password");		
		commentBox =properties.getProperty("CommentBox");
		
		//Declare Implicit wait
		String impWait = properties.getProperty("implicitWait").toString();		
		
		//Define and initialize screenshot variable
		screenShot = new ScreenShot(driver);		
		
	}

	@BeforeMethod
	public void Llogin() throws Exception {
		
		//Open the browser 
		driver.get(baseUrl);
		
		driver.manage().timeouts().implicitlyWait(impWait, TimeUnit.MINUTES);
		//Open the login page
		userlinkPOM.GotoLoginPage();
		
		//Provide the login credenital
		loginRetailPOM.sendUserName(userName);
		loginRetailPOM.sendPassword(password);
		
		//Click on login button
		loginRetailPOM.clickLoginBtn();
		Thread.sleep(1000);
		
		//user should able to login to the retail application
	
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		
		//Capture the final screenshot		
		screenShot.captureScreenShot("Verify Return Order");
		
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
		//Click on MY ORDERS link	
		userlinkPOM.GotoMyOrder();
		Thread.sleep(1000);
		
		//Click on view icon
		myOrderPOM.clikViewButton();
		Thread.sleep(1000);
		
		//Click on Return icon
		myOrderPOM.clikReturnBtn();
		Thread.sleep(1000);
		
		//Click on valid Reason for Return radio button
		myOrderPOM.clikReturnReason();
		Thread.sleep(1000);
		
		//Click radio button of Product is opened category
		myOrderPOM.clikRadioBtn();
		Thread.sleep(1000);
		
		// Enter reason for return in Faulty or other details textbox
		myOrderPOM.enterComment(commentBox);
		Thread.sleep(1000);
		
		//Click on Submit button
		myOrderPOM.clikSubmitBtn();
		Thread.sleep(1000);
		
		//Display the message for return request
		myOrderPOM.dispSubmitMsg(submitMsg);          
		Thread.sleep(1000);	
		
		
	    //Capture the success message
		String returnMsg = myOrderPOM.dispSubmitMsg(submitMsg);		
		
		//Print the message on the console
		System.out.println(returnMsg); 
		
		//Verify the message for return order product
		if(returnMsg.contains("Thank you for submitting your return request. ")){
			System.out.println("Expected Text is obtained");
		}else{
			System.out.println("Expected Text is not obtained");
		}
		
				
	}	

}
