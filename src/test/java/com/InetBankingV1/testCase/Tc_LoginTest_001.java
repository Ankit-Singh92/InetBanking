package com.InetBankingV1.testCase;

import java.io.IOException;

import org.testng.annotations.Test;

import com.InetBankingV1.pageObject.LoginPage;

import junit.framework.Assert;

public class Tc_LoginTest_001 extends BaseClass {
	
	
	@Test
	public void loginTest() throws IOException{
		logger.info("login Pa"
				+ "ge Url Opened");
		LoginPage login=new LoginPage(driver);
		login.setUserName(username);
		logger.info("username Entered successfully");
		login.setPassword(password);
		logger.info("password Entered successfully");
		login.clickLoginBtn();
		logger.info("successfully clicked on LoginButton");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Test Case Pass");
		}else {
			captureScreenShot(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Test Case failed");
		}
	}
}
