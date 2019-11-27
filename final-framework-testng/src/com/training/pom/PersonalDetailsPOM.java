package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetailsPOM {
	
private WebDriver driver; 
	
	public PersonalDetailsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-firstname")
	private WebElement userFirstName; 
	
	@FindBy(id="input-lastname")
	private WebElement userLastName;
	
	@FindBy(id="input-email")
	private WebElement useremail;
	
	@FindBy(id="input-telephone")
	private WebElement userTelephone;
	
	@FindBy(xpath="//*[@id='edit_account_form']/div/div[2]/input")
	private WebElement continueBtn; 
	
	@FindBy(xpath="//*[@id='System_nyHsmShk']/div")
	private WebElement successMsg;
	
	public void sendFirstName(String userFirstName) {
		this.userFirstName.clear();
		this.userFirstName.sendKeys(userFirstName);
	}
	
	public void senduserLastName(String userLastName) {
		this.userLastName.clear();
		this.userLastName.sendKeys(userLastName); 
	}
	
	public void senduseremail(String useremail) {
		this.useremail.clear(); 
		this.useremail.sendKeys(useremail); 
	}
	
	public void senduserTelephone(String userTelephone) {
		this.userTelephone.clear(); 
		this.userTelephone.sendKeys(userTelephone); 
	}
	
	public void clickcontinueBtn() {
		this.continueBtn.click(); 
	}
	
	public String displayMsg(String successMsg ){
	       return this.successMsg.getText();
	}

}
