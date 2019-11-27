package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPOM {
	
private WebDriver driver; 
	
	public MyAccountPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='System_nyHsmShk']/align/ul/li[1]/a")
	private WebElement editAccountLink; 
	
	@FindBy(xpath="//*[@id='System_nyHsmShk']/align/ul/li[2]/a")
	private WebElement changePasswordLink; 
	
	@FindBy(xpath="//*//*[@id='System_nyHsmShk']/div")
	private WebElement pswSucsMsg;
	
	public void clickEditAccountLink() {
		this.editAccountLink.click(); 
	}
	
	public void clickChngPswLink() {
		this.changePasswordLink.click(); 
	}
	
	public String pswSuccessMsg(String pswSucsMsg ){
	       return this.pswSucsMsg.getText();
	}

}
