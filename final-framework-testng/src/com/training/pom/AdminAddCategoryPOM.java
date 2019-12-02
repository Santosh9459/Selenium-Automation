package com.training.pom;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AdminAddCategoryPOM {

private WebDriver driver; 
	
	public AdminAddCategoryPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//*[@id='content']/div[1]/div/div/a[1]")
	private WebElement addNewBtn;
	
	@FindBy(id="input-name1")
	private WebElement catNameTextBox; 
	
	@FindBy(xpath="//div[@class='note-editable panel-body']")
	private WebElement descriptionBox;
	
	@FindBy(xpath="//input[@id='input-meta-title1']")
	private WebElement catMetaTagTile;	
	
	@FindBy(xpath="//textarea[@id='input-meta-description1']")
	private WebElement metaTagDescription;
	
	@FindBy(xpath="//a[contains(text(),'Data')]")
	private WebElement dataTab;
	
	@FindBy(xpath="//a[contains(text(),'Design')]")
	private WebElement designTab;	
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement succssMsg;
	
	
	
	public void addNewButton(){
		this.addNewBtn.click();
	}
	
	public void enterCategName(String catNameTextBox){
		this.catNameTextBox.clear();
		this.catNameTextBox.sendKeys(catNameTextBox);
	}
	
	public void enterDescriptionText(String descriptionBox){
		this.descriptionBox.clear();
		this.descriptionBox.sendKeys(descriptionBox);
	}
	
	public void enterMetaTagTile(String catMetaTagTile){
		this.catMetaTagTile.clear();
		this.catMetaTagTile.sendKeys(catMetaTagTile);
	}
	
	public void enterMetaTagDesc(String metaTagDescription){
		this.metaTagDescription.clear();
		this.metaTagDescription.sendKeys(metaTagDescription);
	}
	
	public void clikDataTab(){
		this.dataTab.click();
	}
	
	public void clikDesignTab(){
		this.designTab.click();
	}

	public void clikSaveBtn(){
		this.saveBtn.click();
	}
	
	public String categoryaddedMsg(String succssMsg ){
	       return this.succssMsg.getText();
	} 
	
	
}
