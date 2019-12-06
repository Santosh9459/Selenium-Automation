//RT_083 - To verify whether application displays error message upon entering invalid details while returning product

package com.training.Complex.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminDashboadPOM;
import com.training.pom.AdminLoginPOM;
import com.training.pom.AdminProductRetrunPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC83_VerifyErrorMsgonReturnProd {
	
	//Define variable and POM
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
	private String errorMsg;
	
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
		orderId =properties.getProperty("ORDERID2");
		customer =properties.getProperty("Customer2");
		firstName =properties.getProperty("FirstName2");
		lastName =properties.getProperty("LastName2");
		emailTextBox =properties.getProperty("EmailTextBox2");
		telephone =properties.getProperty("Telephone2");
		prodcut =properties.getProperty("Prodcut2");
		model =properties.getProperty("Model2");
		orderId =properties.getProperty("ORDERID2");

		//Declare Implicit wait
		String impWait = properties.getProperty("implicitWait").toString();
		
		//Initialize Screen Shot 
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
		screenShot.captureScreenShot("Verify Return Product with error message");
		
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

	//Test to verify Error message upon entering invalid details
	@Test	
	public void verifyReturnproduct() throws InterruptedException
	{ 
		// click on Sales icon and select Return link
		adminDashboadPOM.SelectReturn();
		
		// click on Add new icon
		adminProductRetrunPOM.clikAddNewButton();
		
		//// enter valid credential in Order ID textbox
		adminProductRetrunPOM.enterOrderID(orderId);
		
		//// enter valid credential in Customer textbox
		adminProductRetrunPOM.enterCustomer(customer);
		
		//enter valid credential in First Name textbox
		adminProductRetrunPOM.enterFirstName(firstName);
		
		//enter valid credential in Last Name textbox
		adminProductRetrunPOM.enterLastName(lastName);
		
		//enter valid credential in E-Mail textbox
		adminProductRetrunPOM.enterEmail(emailTextBox);
		
		//enter valid credential in Phone textbox
		adminProductRetrunPOM.enterTelephone(telephone);
		
		//enter valid credential in Product textbox
		adminProductRetrunPOM.enterProdcut(prodcut);
		
		//enter valid credential in Model textbox
		adminProductRetrunPOM.enterModel(model);
		
		//Click on Save icon
		adminProductRetrunPOM.clikSaveButton();
		
		//Capture the text message
		String errmsg = adminProductRetrunPOM.errorMessage(errorMsg);
		
		//Print the message on console
		System.out.println(errmsg);
		
		//Verify the Message
		if(errmsg.contains("Warning: Please check the form carefully for errors!")){
			System.out.println("Expected Text is obtained");
		}else{
			System.out.println("Expected Text is not obtained");
		}
		
	    
	}


}
