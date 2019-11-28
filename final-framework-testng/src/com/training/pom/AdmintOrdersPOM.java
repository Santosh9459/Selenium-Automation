package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdmintOrdersPOM {
	
	private WebDriver driver; 
	
	public AdmintOrdersPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-order-id")
	private WebElement orderId; 
	
	@FindBy(id = "button-filter")
	private WebElement filterButton;
	
	@FindBy(xpath="//*[@id='form-order']/div/table/thead/tr/td[1]/input")
	private WebElement selectCheckbox; 
	
	@FindBy(xpath = "//*[@id='button-delete']/i")
	private WebElement deleteButton;
	
	@FindBy(xpath="//*[@id='content']/div[2]/div[1]")
	private WebElement sucessMsg;
	
	
	public void sendOrderID(String orderId) {
		this.orderId.clear();
		this.orderId.sendKeys(orderId);
	}
	
	public void clickFilterButton(){
	     this.filterButton.click();
	}
	
	public void clickCheckbox(){
		this.selectCheckbox.click();
	}
	
	public void clickDeleteButton(){
		this.deleteButton.click();
	}
	
	public String orderModifiedMsg(String sucessMsg ){
	       return this.sucessMsg.getText();
	}
	
}
