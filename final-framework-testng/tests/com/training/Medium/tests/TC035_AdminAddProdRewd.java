//TC_035 To verify whether application allows admin to add product with the rewards point

package com.training.Medium.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminAddProdPOM;
import com.training.pom.AdminDashboadPOM;
import com.training.pom.AdminLoginPOM;
import com.training.pom.AdmintOrdersPOM;
import com.training.pom.LoginRetailPOM;
import com.training.pom.MyAccountPOM;
import com.training.pom.PersonalDetailsPOM;
import com.training.pom.UserLinkPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

//Define variable and POM
public class TC035_AdminAddProdRewd {
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
	private String quantityTextBox;
	private String quantity;
	private String price;
	private String pointsTextBox;
	private String startDate;
	private String endDaate;
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
		quantityTextBox = properties.getProperty("QuantityTextBox");
		quantity = properties.getProperty("Quantity");
		price = properties.getProperty("Price");
		pointsTextBox = properties.getProperty("PointsTextBox");
		
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
    
	@Test
	public void selectLogin() throws InterruptedException
	{
		//Select product from Category Icon	
		adminDashboadPOM.selectCategories();
		
		// Click on Add New icon
		adminAddProdPOM.addNewProduct();
		Thread.sleep(1000);
		
		// Enter Valid credentials in Product Name of General tab
		adminAddProdPOM.enterProdName(prodName);
		adminAddProdPOM.enterMetaTitle(metaTagTitle);
		Thread.sleep(2000);
		
		//Click on Data tab
		adminAddProdPOM.clickDataTab();
		Thread.sleep(1000);
		
		// Enter valid credentials in various field under Data Tab
		adminAddProdPOM.enterModel(modelTextBox);
		adminAddProdPOM.enterPrice(priceTextBox);
		adminAddProdPOM.enterQuantity(quantityTextBox);
		Thread.sleep(2000);
		
		// Click on Links tab
		adminAddProdPOM.clikLinksTab();
		Thread.sleep(1000);
		
		//Select Category from displayed category list
		adminAddProdPOM.selectCategory();
		Thread.sleep(2000);
		
		/*Select a = new Select(driver.findElement(By.xpath("//div[@id='tab-links']//li[1]")));
		//a.selectByIndex(2);
		a.selectByVisibleText("INDIAN");
		Thread.sleep(2000); */
		
		// Click on Attribute tab
		adminAddProdPOM.clikAttributeTab();
		Thread.sleep(2000);
		
		
		// Click on Option tab
		adminAddProdPOM.clikOptionTab();
		Thread.sleep(2000);
		
		// Click on Reccuring tab
		adminAddProdPOM.clikRecurringTab();
		Thread.sleep(2000);
		
		// Click on Discount tab
		adminAddProdPOM.clikDiscountTab();
		Thread.sleep(1000);
		
		// Click on Add discount icon
		adminAddProdPOM.clikAddDiscount();
		Thread.sleep(1000);
		
		//Enter valid credentials in various filed of discound tab
		adminAddProdPOM.enterQuantity1(quantity);
		adminAddProdPOM.enterPrice1(price);
		adminAddProdPOM.enterStartDate(startDate);
		adminAddProdPOM.enterEndDate(endDaate);
		Thread.sleep(5000);		
		
		//Click on Special Tab
		adminAddProdPOM.clikSpecialTab();
		Thread.sleep(2000);
		
		//Click on Image Tab
		adminAddProdPOM.clikImageTab();
		Thread.sleep(2000);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,10000)");
		Thread.sleep(2000);
		
		//Click on Rewards Point Tab
		adminAddProdPOM.clikRewardPointsTab();
		Thread.sleep(1000);		
		adminAddProdPOM.enterRewardPoints(pointsTextBox);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,10000)");
		Thread.sleep(2000);		
		
		//Click on Design Tab
		adminAddProdPOM.clikDesignTab();
		Thread.sleep(1000);
		
		//Click on Save Button
		adminAddProdPOM.clikSaveButton();		
        Thread.sleep(5000);
    
		
	    //Capture the success message
		String productMsg =adminAddProdPOM.productaddedMsg(successMessage);
		
		
		//Print the message on the console
		System.out.println(productMsg); 
		
		
		//Verify the Message
		if(productMsg.contains(" Success: You have modified products! ")){
			System.out.println("Expected Text is obtained");
		}else{
			System.out.println("Expected Text is not obtained");
		}
		
			
	}	

}
