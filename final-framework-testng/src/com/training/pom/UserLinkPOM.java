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
	
	@FindBy(xpath="//*[@id='Menu_Wmt3OMY3']/nav/ul/li[2]/ul/li[3]/a/span")
	private WebElement myOrderLink;
	
	public void GotoLoginPage() {
		
		Actions loginSelect = new Actions(driver);
		loginSelect.moveToElement(userLink).build().perform();		
		loginRegister.click(); 
	} 
   
public void GotoMyOrder() {
		
		Actions loginSelect = new Actions(driver);
		loginSelect.moveToElement(userLink).build().perform();		
		myOrderLink.click(); 
	} 
}
