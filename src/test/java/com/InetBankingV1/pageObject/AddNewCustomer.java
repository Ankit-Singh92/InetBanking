package com.InetBankingV1.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {
	
	WebDriver driver;
	public AddNewCustomer(WebDriver driver){	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='addcustomerpage.php']")
	WebElement linkaddnewcustomer;
	
	@FindBy(name="name")
	@CacheLookup
     WebElement txt_Customername;
	 @FindBy(name="rad1")
	 @CacheLookup
	 WebElement txtgender;
	 @FindBy(id="dob")
	 @CacheLookup
	 WebElement txtdob;
	 @FindBy(name="addr")
	 WebElement txtaddress;
	 @FindBy(name="city")
	 WebElement txtcity;
	 @FindBy(name="state")
	 WebElement txtstate;
	 @FindBy(name="pinno")
	  WebElement txtpinno;
	 @FindBy(name="telephoneno")
	 WebElement txtmobilenumber;
	 @FindBy(name="emailid")
	 WebElement txtemailid;
	 @FindBy(name="password")
	 WebElement txtpassword;
	 @FindBy(name="sub")
	 WebElement btnsubmit;
	 
	 public void linkAddCustomer() {
		 linkaddnewcustomer.click();
	 }
	 
	 
	 public void setCustomerName(String custname) {
		 
		 txt_Customername.sendKeys(custname);
	 }
	 public void selectCustomerGender() {	 
		 txtgender.click();
	 }
	
	public void setCustomerDOB(String date,String month,String year) {
		txtdob.sendKeys(date);
		txtdob.sendKeys(month);
		txtdob.sendKeys(year);
	}
	
	public void customerAddress(String addrerss) {
		txtaddress.sendKeys(addrerss);
	}
	public void customerCity(String city) {
		txtcity.sendKeys(city);	
	}
	public void customerState(String state) {
		txtstate.sendKeys(state);	
	}
	public void customerPin(String pin) {
		txtpinno.sendKeys(String.valueOf(pin));	
	}
	public void customerMobileNumber(String phonnumber) {
		txtmobilenumber.sendKeys(String.valueOf(phonnumber));	
	}
	public void customerEmailId(String emailid) {
		txtemailid.sendKeys(String.valueOf(emailid));	
	}
	public void customerPassword(String password) {
		txtpassword.sendKeys(String.valueOf(password));	
	}
	
	public void clickSubmitBtn() {
	
	btnsubmit.click();
	}
	
	
}




