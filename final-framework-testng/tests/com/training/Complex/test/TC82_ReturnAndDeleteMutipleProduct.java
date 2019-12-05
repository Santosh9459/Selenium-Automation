package com.training.Complex.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminDashboadPOM;
import com.training.pom.AdminLoginPOM;
import com.training.pom.AdminProductRetrunPOM;
import com.training.pom.AdmintOrdersPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC82_ReturnAndDeleteMutipleProduct {
	
	private WebDriver driver;
	private String adminURL;
	private AdminLoginPOM adminLoginPOM;
	private AdminDashboadPOM adminDashboadPOM;
	private AdminProductRetrunPOM adminProductRetrunPOM;
	private String adminUserName;
	private String adminPassword;
	
	private String orderId;
	private String customer;
	private String firstName;
	private String lastName;
	private String emailTextBox;
	private String telephone;
	private String prodcut;
	private String model;	
	private String successMessage;
	private String retrunMsg;
	
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
		adminDashboadPOM = new AdminDashboadPOM(driver);
		adminProductRetrunPOM = new AdminProductRetrunPOM(driver);
		//Initialize property file variables
		adminUserName = properties.getProperty("AdminUserName");
		adminPassword = properties.getProperty("AdminPassword");
		orderId =properties.getProperty("ORDERID");
		customer =properties.getProperty("Customer");
		firstName =properties.getProperty("FirstName");
		lastName =properties.getProperty("LastName");
		emailTextBox =properties.getProperty("EmailTextBox");
		telephone =properties.getProperty("Telephone");
		prodcut =properties.getProperty("Prodcut");
		model =properties.getProperty("Model");
		orderId =properties.getProperty("ORDERID");

		//Declare Implicit wait
		String impWait = properties.getProperty("implicitWait").toString();
		
		screenShot = new ScreenShot(driver);
		
	}

	@BeforeMethod
	public void Llogin() throws Exception {
		
		//Open the browser 
		driver.get(adminURL);
		//Provide the login credenital
		adminLoginPOM.enterUserName(adminUserName);
		adminLoginPOM.enterPassword(adminPassword);
		//Click on login button
		adminLoginPOM.clickLoginBtn();	
		//user should able to login to the retail application as an admin
		Thread.sleep(1000);
	
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);		
		//Capture the final screenshot 
		screenShot.captureScreenShot("Verify Return Product with Scuccess");
		
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

	@Test	
	public void verifyReturnproduct() throws InterruptedException
	{
		adminDashboadPOM.SelectReturn();
		adminProductRetrunPOM.clikAddNewButton();
		adminProductRetrunPOM.enterOrderID(orderId);
		adminProductRetrunPOM.enterCustomer(customer);
		adminProductRetrunPOM.enterFirstName(firstName);
		adminProductRetrunPOM.enterLastName(lastName);
		adminProductRetrunPOM.enterEmail(emailTextBox);
		adminProductRetrunPOM.enterTelephone(telephone);
		adminProductRetrunPOM.enterProdcut(prodcut);
		adminProductRetrunPOM.enterModel(model);
		adminProductRetrunPOM.clikSaveButton();
		adminProductRetrunPOM.returnModifiedMsg(successMessage);
		
		String succMsg = adminProductRetrunPOM.returnModifiedMsg(successMessage);
		
		System.out.println(succMsg);
		
		
		adminProductRetrunPOM.selectCheckbox();
		Thread.sleep(5000);
		adminProductRetrunPOM.clikDeleteButton();
		
		//Capture the Pop up window and their message
		Alert al =driver.switchTo().alert();
		System.out.println(al.getText());	
		//Click on Ok button
		al.accept();
		
		
		String retmsg = adminProductRetrunPOM.returnMessage(retrunMsg);
		
		System.out.println(retmsg);
		
		if(retmsg.contains("Success: You have modified returns!")){
			System.out.println("Expected Text is obtained");
		}else{
			System.out.println("Expected Text is not obtained");
		}
		
	    
	}

}
