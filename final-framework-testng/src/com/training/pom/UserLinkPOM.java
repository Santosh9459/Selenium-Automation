package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLinkPOM {
private WebDriver driver; 
	
	public UserLinkPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='Menu_Wmt3OMY3']/nav/ul/li[2]/a")
	private WebElement userLink; 
	
	@FindBy(xpath="//span[contains(text(),'LOGIN / REGISTER')]")
	private WebElement loginRegister;
			
	
	public void GotoLoginPage() {
		
		Actions loginSelect = new Actions(driver);
		loginSelect.moveToElement(userLink).build().perform();		
		loginRegister.click(); 
	} 

}
