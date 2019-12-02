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
			
			@FindBy(xpath="//*[@id='menu-catalog']/a")
			private WebElement catalogIconLink; 
			
			@FindBy(xpath="//*[@id='menu-catalog']/ul/li[2]/a")
			private WebElement selectProductLink;
			
			@FindBy(xpath="//*[@id='menu-catalog']/ul/li[1]/a")
			private WebElement selectCatgryLink; 
			
			
			
			public void SelectOrder() {
				
				Actions salesSelect = new Actions(driver);
				salesSelect.moveToElement(salesIcontLink).build().perform();		
				selectOrderLink.click(); 			
	        }
			
			public void selectCategories(){
				
				Actions categorySelect= new Actions(driver);
				categorySelect.moveToElement(catalogIconLink).build().perform();		
				selectProductLink.click(); 		
			}
			
           public void selectCategoryLink(){
				
				Actions categorySelect= new Actions(driver);
				categorySelect.moveToElement(catalogIconLink).build().perform();		
				selectCatgryLink.click(); 		
			}

}
