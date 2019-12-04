package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyOrderPOM {
private WebDriver driver; 
	
	public MyOrderPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//tbody//tr[1]//td[7]")
	private WebElement viewBtn;
	
	
	@FindBy(xpath="//a[@class='btn btn-danger tb_no_text']")
	private WebElement returnBtn;
	
	@FindBy(xpath="//div[@class='col-sm-10']//div[1]//label[1]//input[1]")
	private WebElement retReasRadioBtn;
	
	
	@FindBy(xpath="//*[@id='return_request_form']/fieldset[2]/div[5]/div/label[1]")
	private WebElement yesRadioBtn;	
	
	@FindBy(id="input-comment")
	private WebElement commentBox; 	
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement submitBtn;	
	
	@FindBy(xpath="//div[@class='tb_text_wrap tb_sep']")
	private WebElement submitMsg;	
	
	
	public void clikViewButton(){
		this.viewBtn.click();
	}
	
	public void clikReturnBtn(){
		this.returnBtn.click();
	}
	
	public void clikReturnReason(){
		this.retReasRadioBtn.click();
	}
	
	public void clikRadioBtn(){
		this.yesRadioBtn.click();
	}
	
	
	public void enterComment(String commentBox){
		this.commentBox.clear();
		this.commentBox.sendKeys(commentBox);
	}
	
	public void clikSubmitBtn(){
		this.submitBtn.click();
	}
	
	public String dispSubmitMsg(String submitMsg ){
	       return this.submitMsg.getText();
	} 
	

}
