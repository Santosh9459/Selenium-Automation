//RTC_068 -To Verify whether application allows admin to add multiple product by entering valid credentials in mandatory fields only

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

import com.training.generics.ScreenShot;
import com.training.pom.AdminAddProdPOM;
import com.training.pom.AdminDashboadPOM;
import com.training.pom.AdminLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC68_AddMultipleProdWithMandatoryField {
	
	//Define variable and POM
	private WebDriver driver;
	private String adminURL;
	private AdminLoginPOM adminLoginPOM;
	private AdminDashboadPOM adminDashboadPOM;
	private AdminAddProdPOM adminAddProdPOM;
	private String adminUserName;
	private String adminPassword;
	
	private String prodName;
	private String metaTagTitle;
	private String modelTextBox;
	private String priceTextBox;
	
	private int impWait;
	private String successMessage;
	
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
		prodName =properties.getProperty("ProdName");
		metaTagTitle = properties.getProperty("MetaTagTitle");
		modelTextBox = properties.getProperty("ModelTextBox");
		priceTextBox = properties.getProperty("PriceTextBox");
				
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
		Thread.sleep(1000);
	
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);		
		
		//Capture the final screenshot 
		screenShot.captureScreenShot("Verify AddProduct with RewardPoint");
		
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
    
	//Test to add product using Mandatory field only
	@Test
	public void addProductMandatoryField() throws InterruptedException
	{
		//Select product from Category Icon	
		adminDashboadPOM.selectCategories();
		
		// Click on Add New icon
		adminAddProdPOM.addNewProduct();
				
		// Enter Valid credentials in Product Name of General tab
		adminAddProdPOM.enterProdName(prodName);
		adminAddProdPOM.enterMetaTitle(metaTagTitle);
				
		//Click on Data tab
		adminAddProdPOM.clickDataTab();
				
		// Enter valid credentials in various field under Data Tab
		adminAddProdPOM.enterModel(modelTextBox);
		adminAddProdPOM.enterPrice(priceTextBox);
		
		
		
		// Click on Links tab
		adminAddProdPOM.clikLinksTab();
				
		//Select Category from displayed category list
		adminAddProdPOM.selectCategory();		
		//adminAddProdPOM.clikcategorylist();
		
						
		//Click on Save Button
		adminAddProdPOM.clikSaveButton();		
         
		
	    //Capture the success message
		String productMsg =adminAddProdPOM.productaddedMsg(successMessage);
		
		
		//Print the message on the console
		System.out.println(productMsg); 
		
		
		//Verify the Message
		if(productMsg.contains("Success: You have modified products!")){
			System.out.println("Expected Text is obtained");
		}else{
			System.out.println("Expected Text is not obtained");
		}
		
			
	}	

}
