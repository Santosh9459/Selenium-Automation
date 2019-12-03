//To verify whether application allows admin to add category in categories page

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
import com.training.pom.AdminAddProdPOM;
import com.training.pom.AdminDashboadPOM;
import com.training.pom.AdminLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

//Define and Initialize variable and POM
public class TC038_AdminAddCategory {

	private WebDriver driver;
	private String adminURL;
	private AdminLoginPOM adminLoginPOM;
	private AdminDashboadPOM adminDashboadPOM;
	private AdminAddCategoryPOM adminAddCategoryPOM;
	
	private String adminUserName;
	private String adminPassword;
	private String catNameTextBox;
	private String descriptionBox;
	private String catMetaTagTile;
	private String metaTagDescription;	
	private String succssMsg;
	
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
		adminAddCategoryPOM = new AdminAddCategoryPOM(driver);
		
		//Initialize property file variables
		adminUserName = properties.getProperty("AdminUserName");
		adminPassword = properties.getProperty("AdminPassword");		
		catNameTextBox =properties.getProperty("CatNameTextBox");
		descriptionBox =properties.getProperty("DescriptionBox");
		catMetaTagTile = properties.getProperty("CatMetaTagTile");
		metaTagDescription = properties.getProperty("MetaTagDescription");
		
		////Declare Implicit wait
		String impWait = properties.getProperty("implicitWait").toString();
		
		//Define and initialize screenshot variable
		screenShot = new ScreenShot(driver);		
		
	}

	@BeforeMethod
	public void Llogin() throws Exception {
		
		//Open the browser 
		driver.get(adminURL);
		
		//Declare implicit wait
		driver.manage().timeouts().implicitlyWait(impWait, TimeUnit.MINUTES);
		
		//Provide the login credenital
		adminLoginPOM.enterUserName(adminUserName);
		adminLoginPOM.enterPassword(adminPassword);
		
		//Click on login button
		adminLoginPOM.clickLoginBtn();	
		
		//user should able to login to the retail application as an admin
			
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);	
		
		//Capture final screenshot
		screenShot.captureScreenShot("Verify Add Category");	
		
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
		//Click on Category link	
		adminDashboadPOM.selectCategoryLink();
		
		//Click on Add new icon
		adminAddCategoryPOM.addNewButton();
		
		//Enter Valid credentials in various field of General tab
		adminAddCategoryPOM.enterCategName(catNameTextBox);
		adminAddCategoryPOM.enterDescriptionText(descriptionBox);
		adminAddCategoryPOM.enterMetaTagTile(catMetaTagTile);
		adminAddCategoryPOM.enterMetaTagDesc(metaTagDescription);
		
		//Click on Data Tab
		adminAddCategoryPOM.clikDataTab();
				
		//Click on Design Tab
		adminAddCategoryPOM.clikDesignTab();
				
		//Click on Save button
		adminAddCategoryPOM.clikSaveBtn();
				
		//Display the message of category being added
		adminAddCategoryPOM.categoryaddedMsg(succssMsg);
        		
	    //Capture the success message
		String categrorytMsg = adminAddCategoryPOM.categoryaddedMsg(succssMsg);
		
		//Print the message on the console
		System.out.println(categrorytMsg); 
		
		//verify the message for modify category
		if(categrorytMsg.contains("Success: You have modified categories!")){
			System.out.println("Expected Text is obtained");
		}else{
			System.out.println("Expected Text is not obtained");
		}
				
	}	
}
