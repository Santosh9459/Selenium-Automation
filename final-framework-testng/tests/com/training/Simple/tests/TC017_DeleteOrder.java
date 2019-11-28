package com.training.Simple.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
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
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		adminURL = properties.getProperty("adminURL");
		
		adminLoginPOM = new AdminLoginPOM(driver);
		adminDashboadPOM = new AdminDashboadPOM(driver);
		admintOrdersPOM = new AdmintOrdersPOM(driver);
	
		adminUserName = properties.getProperty("AdminUserName");
		adminPassword = properties.getProperty("AdminPassword");
		orderId =properties.getProperty("OrderID");

		
		screenShot = new ScreenShot(driver);
		
	}

	@BeforeMethod
	public void Llogin() {
		
		// open the browser 
		driver.get(adminURL);
		
		adminLoginPOM.enterUserName(adminUserName);
		adminLoginPOM.enterPassword(adminPassword);
		adminLoginPOM.clickLoginBtn();		
	
	}
	
	/*@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	} */
	
	@BeforeTest
	public void SetUp() throws Exception{
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
	}

	@Test	
	public void selectLogin() throws InterruptedException
	{
		adminDashboadPOM.SelectOrder();
		admintOrdersPOM.sendOrderID(orderId);
		admintOrdersPOM.clickFilterButton();
		admintOrdersPOM.clickCheckbox();
		admintOrdersPOM.clickDeleteButton();	
		
        Thread.sleep(5000);
		
		Alert al =driver.switchTo().alert();
		System.out.println(al.getText());
	
		al.accept();
	
		String orderMsg =admintOrdersPOM.orderModifiedMsg(sucessMsg);
		
		
		System.out.println(orderMsg); 
		
	}	

}
