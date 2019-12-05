package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminProductRetrunPOM {
	
private WebDriver driver; 
	
	public AdminProductRetrunPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='content']/div[1]/div/div/a")
	private WebElement addNewButton; 
	
	@FindBy(xpath="//input[@id='input-order-id']")
	private WebElement orderId;
	
	@FindBy(xpath="//input[@id='input-customer']")
	private WebElement customer;
	
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailTextBox;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	private WebElement telephone;
	
	@FindBy(xpath="//input[@id='input-product']")
	private WebElement prodcut;
	
	@FindBy(xpath="//input[@id='input-model']")
	private WebElement model;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement saveButton;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement successMessage;
	
	@FindBy(xpath="//div[@id='container']//tbody//tr[1]//td[1]")
	private WebElement retProdCheckbox;
	
	@FindBy(xpath="//button[@class='btn btn-danger']")
	private WebElement deleteButton;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement retrunMsg;
	
	@FindBy(xpath="//*[@id='content']/div[2]/div[1]")
	private WebElement errorMsg;
	
	
	
	public void clikAddNewButton(){
	     this.addNewButton.click();
	}
	
	public void enterOrderID(String orderId) {
	this.orderId.clear();
	this.orderId.sendKeys(orderId);
   }
	
	public void enterCustomer(String customer) {
		this.customer.clear();
		this.customer.sendKeys(customer);
	   }
	
	public void enterFirstName(String firstName) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
	   }
	
	public void enterLastName(String lastName) {
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
	   }
	
	public void enterEmail(String emailTextBox) {
		this.emailTextBox.clear();
		this.emailTextBox.sendKeys(emailTextBox);
	   }
	
	public void enterTelephone(String telephone) {
		this.telephone.clear();
		this.telephone.sendKeys(telephone);
	   }
	
	public void enterProdcut(String prodcut) {
		this.prodcut.clear();
		this.prodcut.sendKeys(prodcut);
	   }
	
	public void enterModel(String model) {
		this.model.clear();
		this.model.sendKeys(model);
	   }
	
	public void clikSaveButton(){
	     this.saveButton.click();
	}
	
	public String returnModifiedMsg(String successMessage ){
	       return this.successMessage.getText();
	} 
	
	public void selectCheckbox(){
	     this.retProdCheckbox.click();
	}
	
	public void clikDeleteButton(){
	     this.deleteButton.click();
	}
	
	public String returnMessage(String retrunMsg ){
	       return this.retrunMsg.getText();
	} 	
	
	public String errorMessage(String errorMsg ){
	       return this.errorMsg.getText();
	} 	
	

}
