package com.training.pom;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminAddProdPOM {
private WebDriver driver; 
	
	public AdminAddProdPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='content']/div[2]/div/div[1]/h3")
	private WebElement productList;
	
	@FindBy(xpath="//*[@id='content']/div[1]/div/div/a")
	private WebElement addNewIcon;
	
	@FindBy(xpath="//*[@id='content']/div[2]/div/div[1]/h3")
	private WebElement addProdPage;
	
	@FindBy(id="input-name1")
	private WebElement prodName;
	
	@FindBy(id="input-meta-title1")
	private WebElement metaTagTitle;
	
	@FindBy(xpath="//*[@id='form-product']/ul/li[2]/a")
	private WebElement dataTab;
	
	@FindBy(xpath="//*[@id='tab-data']/div[1]/label")
	private WebElement modelField;
	
	@FindBy(id="input-model")
	private WebElement modelTextBox;
	
	@FindBy(id="input-price")
	private WebElement priceTextBox;
	
	@FindBy(id="input-quantity")
	private WebElement quantityTextBox;
	
	@FindBy(xpath="//*[@id='form-product']/ul/li[3]/a")
	private WebElement linksTab;
	
	@FindBy(id="input-category")
	private WebElement categoryTextBox;
	
	@FindBy(xpath="//div[@id='tab-links']//li[1]")
	private WebElement categorylist; 
	
	
	@FindBy(xpath="//*[@id='form-product']/ul/li[4]/a")
	private WebElement attributeTab;
	
	@FindBy(xpath="//*[@id='form-product']/ul/li[5]/a")
	private WebElement optionTab;
	
	@FindBy(xpath="//*[@id='form-product']/ul/li[6]/a")
	private WebElement recurringTab;
	
	@FindBy(xpath="//*[@id='form-product']/ul/li[7]/a")
	private WebElement discountTab;
	
	@FindBy(xpath="//*[@id='discount']/tfoot/tr/td[2]/button")
	private WebElement addDiscountBtn;
	
	@FindBy(name="product_discount[0][quantity]")
	private WebElement quantity;
	
	@FindBy(name="product_discount[0][price]")
	private WebElement price;
	
	@FindBy(name="product_discount[0][date_start]")
	private WebElement startDate;
	
	@FindBy(name="product_discount[0][date_end]")
	private WebElement endDate;	
	
	@FindBy(xpath="//*[@id='form-product']/ul/li[8]/a")
	private WebElement specialTab;
	
	@FindBy(xpath="//*[@id='form-product']/ul/li[9]/a")
	private WebElement imageTab;
	
	@FindBy(xpath="//*[@id='form-product']/ul/li[10]/a")
	private WebElement rewardPointsTab;
	
	@FindBy(id="input-points")
	private WebElement pointsTextBox;
	
	
	@FindBy(xpath="//*[@id='form-product']/ul/li[11]/a")
	private WebElement designTab;
	
	@FindBy(xpath="//*[@id='content']/div[1]/div/div/button")
	private WebElement saveButton;	
	
	@FindBy(xpath="//*[@id='content']/div[2]/div[1]")
	private WebElement successMessage;
	
	
	
	@FindBy(xpath="//input[@id='input-name']")
	private WebElement filteProductName;
	
	@FindBy(xpath="//input[@id='input-price']")
	private WebElement filterPrice;
	
	@FindBy(xpath="//select[@id='input-status']")
	private WebElement filterStatus;
	
	@FindBy(xpath="//input[@id='input-model']")
	private WebElement filterModel;
	
	@FindBy(xpath="//input[@id='input-quantity']")
	private WebElement filterQuantity;	
	
	@FindBy(xpath="//select[@id='input-image']")
	private WebElement filterImage;
	
	@FindBy(xpath="//button[@id='button-filter']")
	private WebElement filterButton;
	
	@FindBy(xpath="//div[@class='col-sm-6 text-right']")
	private WebElement productListMsg;
	
	
	
	public void addNewProduct(){
		this.addNewIcon.click();
	}
	
	public void enterProdName(String prodName){
		this.prodName.clear();
		this.prodName.sendKeys(prodName);
	}
	
	public void enterMetaTitle(String metaTagTitle){
		this.metaTagTitle.clear();
		this.metaTagTitle.sendKeys(metaTagTitle);
	}
	
	public void clickDataTab(){
		this.dataTab.click();
	}
	
	public void enterModel(String modelTextBox){
		this.modelTextBox.clear();
		this.modelTextBox.sendKeys(modelTextBox);
	}
	
	public void enterPrice(String priceTextBox){
		this.priceTextBox.clear();
		this.priceTextBox.sendKeys(priceTextBox);
	}
	
	public void enterQuantity(String quantityTextBox){
		this.quantityTextBox.clear();
		this.quantityTextBox.sendKeys(quantityTextBox);
	}
	
	public void clikLinksTab(){
		this.linksTab.click();
	}
	
	public void selectCategory() throws InterruptedException{
		this.categoryTextBox.click();
		
		
		this.categoryTextBox.sendKeys(Keys.DOWN);
		Thread.sleep(3000);
		
		this.categoryTextBox.sendKeys("INDIAN");
		Thread.sleep(3000);
		
		this.categoryTextBox.sendKeys(Keys.INSERT);
		Thread.sleep(3000);
				
	} 
	
	public void clikcategorylist(){
		this.categorylist.click();
	}
	
	public void clikAttributeTab(){
		this.attributeTab.click();
	}
	
	public void clikOptionTab(){
		this.optionTab.click();
	}
	
	public void clikRecurringTab(){
		this.recurringTab.click();
	}
	
	public void clikDiscountTab(){
		this.discountTab.click();
	}
	
	public void clikAddDiscount(){
		this.addDiscountBtn.click();
	}
	
	public void enterQuantity1(String quantity){
		this.quantity.clear();
		this.quantity.sendKeys(quantity);
	}
	
	public void enterPrice1(String price){
		this.price.clear();
		this.price.sendKeys(price);
	}
	
	
	public void enterStartDate(String startDate){    
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		  LocalDate localDate = LocalDate.now();
		  this.startDate.sendKeys(dtf.format(localDate));
		}
	
	public void enterEndDate(String endDaate){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = new Date();
		Calendar cl = Calendar.getInstance();
		cl.setTime(dt);;
		cl.add(Calendar.DAY_OF_YEAR, 1);
		dt=cl.getTime();
		String str = df.format(dt);
		this.endDate.sendKeys(str);
	}
	
	public void clikSpecialTab(){
		this.specialTab.click();
	}
	
	public void clikImageTab(){
		this.imageTab.click();
	}
	
	public void clikRewardPointsTab(){
		this.rewardPointsTab.click();
	}
	
	public void enterRewardPoints(String pointsTextBox){
		this.pointsTextBox.clear();
		this.pointsTextBox.sendKeys(pointsTextBox);
	}	
	
	public void clikDesignTab(){
		this.designTab.click();
	}
	
	public void clikSaveButton(){
		this.saveButton.click();
	}
	
	public String productaddedMsg(String successMessage ){
	       return this.successMessage.getText();
	}
	
	public void enterfilterProductName(String ProductName){
		this.filteProductName.clear();
		this.filteProductName.sendKeys(ProductName);
	}
	
	public void enterFilterPrice(String Price){
		this.filterPrice.clear();
		this.filterPrice.sendKeys(Price);
	}
	
	public String selectFilterStatus(String Status) throws InterruptedException{
		this.filterStatus.click();
		Select a = new Select(this.filterStatus);
		a.selectByVisibleText("Enabled");
		return a.toString();							
	} 
	
	public void enterFilterModel(String Model){
		this.filterModel.clear();
		this.filterModel.sendKeys(Model);
	}
	
	public void enterFilterQuantity(String Quantity){
		this.filterQuantity.clear();
		this.filterQuantity.sendKeys(Quantity);
	}
	
	public String selectFilterImage(String Image) throws InterruptedException{
		this.filterImage.click();
		Select a = new Select(this.filterImage);
		a.selectByVisibleText("Enabled");
		return a.toString();							
	} 
	
	public void clikFilterButton(){
		this.filterButton.click();
	}
	
	public String filterProductMsg(String prodListMessage ){
	       return this.productListMsg.getText();
	}
}
