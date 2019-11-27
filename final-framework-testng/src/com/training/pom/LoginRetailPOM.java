package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginRetailPOM {
private WebDriver driver; 
	
	public LoginRetailPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	private WebElement userEmailID; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//*[@id='System_nyHsmShk']/div/div[2]/div/form/div/div[2]/input")
	private WebElement loginBtn; 
	
	public void sendUserName(String userEmailID) {
		this.userEmailID.clear();
		this.userEmailID.sendKeys(userEmailID);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}

}
