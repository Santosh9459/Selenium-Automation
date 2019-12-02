//TC017_To Verify whether application allows the admin to delete a order from order list


package com.training.Simple.tests;

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
import com.training.pom.AdmintOrdersPOM;
import com.training.pom.LoginRetailPOM;
import com.training.pom.MyAccountPOM;
import com.training.pom.PersonalDetailsPOM;
import com.training.pom.UserLinkPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC017_DeleteOrder {
	//Define variable and POM
	private WebDriver driver;
	private String adminURL;
	private AdminLoginPOM adminLoginPOM;
	private AdminDashboadPOM adminDashboadPOM;
	private AdmintOrdersPOM admintOrdersPOM;
	private String adminUserName;
	private String adminPassword;
	private String orderId;
	private String sucessMsg;
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
		admintOrdersPOM = new AdmintOrdersPOM(driver);
		//Initialize property file variables
		adminUserName = properties.getProperty("AdminUserName");
		adminPassword = properties.getProperty("AdminPassword");
		orderId =properties.getProperty("OrderID");

		
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
	/*public void tearDown() throws Exception {
		Thread.sleep(1000);		
		//Close the browser
		driver.quit(); 
	} */
	
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
		//Open the Order page
		adminDashboadPOM.SelectOrder();
		//Provide the order id 
		admintOrdersPOM.sendOrderID(orderId);
		//Click on the filter button
		admintOrdersPOM.clickFilterButton();
		//Select the Checkbox
		admintOrdersPOM.clickCheckbox();
		//Click on the delete button
		admintOrdersPOM.clickDeleteButton();	
		
        Thread.sleep(5000);
		//Capture the Pop up window and their message
		Alert al =driver.switchTo().alert();
		System.out.println(al.getText());	
		//Click on Ok button
		al.accept();
		
	    //Capture the success message
		//String orderMsg =admintOrdersPOM.orderModifiedMsg(sucessMsg);
		
		//Print the message on the console
		//System.out.println(orderMsg); 
		
		//String expectation ="Success: You have modified orders!";
		String actual =  admintOrdersPOM.orderModifiedMsg(sucessMsg);

		//Assert.assertEquals(expectation,actual);
		Assert.assertTrue("Success: You have modified orders!".contains(actual));
		
		System.out.println(actual);
		
		
		
	}	

}
