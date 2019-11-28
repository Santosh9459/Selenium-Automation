package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPOM {

	private WebDriver driver; 
	
	public AdminLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement adminUserName; 
	
	@FindBy(id="input-password")
	private WebElement adminPassword;
	
	@FindBy(xpath="//*[@id='content']/div/div/div/div/div[2]/form/div[3]/button")
	private WebElement adminLoginBtn; 
	
	public void enterUserName(String adminUserName) {
		this.adminUserName.clear();
		this.adminUserName.sendKeys(adminUserName);
	}
	
	public void enterPassword(String adminPassword) {
		this.adminPassword.clear(); 
		this.adminPassword.sendKeys(adminPassword); 
	}
	
	public void clickLoginBtn() {
		this.adminLoginBtn.click(); 
	}
}
