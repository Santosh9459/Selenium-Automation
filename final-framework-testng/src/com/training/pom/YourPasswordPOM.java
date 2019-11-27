package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourPasswordPOM {
	
private WebDriver driver; 
	
	public YourPasswordPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-password")
	private WebElement userPassword; 
	
	@FindBy(id="input-confirm")
	private WebElement confirmPassword;
	
	@FindBy(id="input-confirm")
	private WebElement enterPassword;
	
	@FindBy(xpath="//*[@id='System_s3bhXNDb']/form/div/div[2]/input")
	private WebElement continueBtn; 
	
	@FindBy(xpath="//*[@id='System_s3bhXNDb']/form/fieldset/div[2]/div/div")
	private WebElement errorMsg;
	
	public void enterUserPsw(String userPassword) {
		this.userPassword.clear();
		this.userPassword.sendKeys(userPassword);
	}
	
	public void ConfirmPassword(String confirmPassword) {
		this.confirmPassword.clear();
		this.confirmPassword.sendKeys(confirmPassword); 
	}
	
	public void enterConfirmfPsw(String enterPassword) {
		this.enterPassword.clear();
		this.enterPassword.sendKeys(enterPassword); 
	}
	
	
	public void clickcontinueBtn() {
		this.continueBtn.click(); 
	}
	
	public String displayErrorMsg(String errorMsg ){
	       return this.errorMsg.getText();
	}
	
}
