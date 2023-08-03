package com.InetBankingV1.testCase;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.InetBankingV1.pageObject.AddNewCustomer;
import com.InetBankingV1.pageObject.LoginPage;

import junit.framework.Assert;

public class TC_AddNewCustomerTest extends BaseClass{
	
	
	@Test
	public void Tc_AddNewCustomer_001() throws InterruptedException, IOException {
		/*
		 *Login to the Application
		*/
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickLoginBtn();
		logger.info("Loggin Successfull");
		Thread.sleep(5000);
		/*
		 * Add New customer Details Mentioned 
		 * */
		AddNewCustomer addnewcustomer=new AddNewCustomer(driver);
		addnewcustomer.linkAddCustomer();
		logger.info("Add Customer Linked clicked");
		addnewcustomer.setCustomerName("Jhone S");
		addnewcustomer.selectCustomerGender();
		addnewcustomer.setCustomerDOB("15", "08", "1992");
		addnewcustomer.customerAddress("BTM Layout 14th main");
		addnewcustomer.customerCity("bangalore");
		addnewcustomer.customerState("Karnatka");
		addnewcustomer.customerPin("560076");
	addnewcustomer.customerMobileNumber("0000000000");
	
	String email=randomeString()+"@gmail.com";
	addnewcustomer.customerEmailId(email);
	addnewcustomer.customerPassword("Abcd@123");
	addnewcustomer.clickSubmitBtn();
	logger.info("customer Details Entered Successfully");
	
	 if(driver.getPageSource().contains("Customer Registered Successfully!!!")) {
		 
		 Assert.assertTrue(true);
		 logger.info("Test Case passed");
	 }else {
		 captureScreenShot(driver,"Tc_AddNewCustomer_001");
		 Assert.assertTrue(false);
		 logger.info("Test Case passed");
	 }
	
	}
	//User define method to generate the dynamic email id 
	
	String randomeString() {
		String generatedString=RandomStringUtils.randomAlphanumeric(8);
		return generatedString;	
	}
	
	
	
	

}
