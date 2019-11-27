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
	
	public void clickEditAccountLink() {
		this.editAccountLink.click(); 
	}

}
