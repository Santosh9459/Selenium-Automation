package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboadPOM {
	
			
		private WebDriver driver; 
			
			public AdminDashboadPOM(WebDriver driver) {
				this.driver = driver; 
				PageFactory.initElements(driver, this);
			}
			
			@FindBy(xpath="//*[@id='menu-sale']/a")
			private WebElement salesIcontLink; 
			
			@FindBy(xpath="//*[@id='menu-sale']/ul/li[1]/a")
			private WebElement selectOrderLink; 
			
			
			public void SelectOrder() {
				
				Actions salesSelect = new Actions(driver);
				salesSelect.moveToElement(salesIcontLink).build().perform();		
				selectOrderLink.click(); 
			
	}

}
