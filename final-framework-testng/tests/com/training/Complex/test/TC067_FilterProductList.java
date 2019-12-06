//To Verify whether application allows the admin to filter the product details with multiple values

package com.training.Complex.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AdminAddProdPOM;
import com.training.pom.AdminDashboadPOM;
import com.training.pom.AdminLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC067_FilterProductList {
	
	//Define variable and POM
	private WebDriver driver;
	private String adminURL;
	private AdminLoginPOM adminLoginPOM;
	private AdminDashboadPOM adminDashboadPOM;
	private AdminAddProdPOM adminAddProdPOM;
	private String adminUserName;
	private String adminPassword;
	
	private String productName;
	private String price;
	private String status;
	private String model;
	private String quantity;
	private String image;
	
	private int impWait;
	private String prodListMessage;
	
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
		adminAddProdPOM = new AdminAddProdPOM(driver);
		
		//Initialize property file variables
		adminUserName = properties.getProperty("AdminUserName");
		adminPassword = properties.getProperty("AdminPassword");
		productName =properties.getProperty("ProductName");
		price = properties.getProperty("Price");
		status = properties.getProperty("Status");
		model = properties.getProperty("Model");
		quantity = properties.getProperty("Quantity");
		image = properties.getProperty("Image");
		
		//Declare Implicit wait
		String impWait = properties.getProperty("implicitWait").toString();
			
		screenShot = new ScreenShot(driver);	
		
	}

	@BeforeMethod
	public void Llogin() throws Exception {
		
		//Open the browser 
		driver.get(adminURL);
		driver.manage().timeouts().implicitlyWait(impWait, TimeUnit.MINUTES);
		
		//Provide the login credential
		adminLoginPOM.enterUserName(adminUserName);
		adminLoginPOM.enterPassword(adminPassword);
		
		//Click on login button
		adminLoginPOM.clickLoginBtn();	
		
		//user should able to login to the retail application as an admin
		
	
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);		
		
		//Capture the final screenshot 
		screenShot.captureScreenShot("Verify Product List using Filter Criteria");
		
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
    
	//Test to filter the product list by giving provided details
	@Test
	public void productList() throws InterruptedException 
	{
		// Click on Catelog icon and select product link
		adminDashboadPOM.selectCategories();
		
		// Enter valid credentials in Product Name textbox
		adminAddProdPOM.enterfilterProductName(productName);
		
		// Enter Valid credentials in Price textbox
		adminAddProdPOM.enterFilterPrice(price);
		
		// Select values from Status list box
		adminAddProdPOM.selectFilterStatus(status);
		
		// Enter Valid credentials in Model textbox
		adminAddProdPOM.enterFilterModel(model);
		
		// Enter Valid credentials in Quantity textbox
		adminAddProdPOM.enterFilterQuantity(quantity);
		
		//Select values from Image list box
		adminAddProdPOM.selectFilterImage(image);
		
		// Click on Filter button
		adminAddProdPOM.clikFilterButton();
		
		//Select the message text box
		adminAddProdPOM.filterProductMsg(prodListMessage);		
		
		////Capture the success message
		String filterMsg = this.adminAddProdPOM.filterProductMsg(prodListMessage);
		
		//Print the message on the console
		System.out.println(filterMsg);
		
		//Verify the Message
		if(filterMsg.contains("Showing")){
			System.out.println("Expected Text is obtained");
		}else{
			System.out.println("Expected Text is not obtained");
		
	         }	
	
	}
	
	
	}
