package com.InetBankingV1.testCase;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;

import com.InetBankingV1.pageObject.LoginPage;
import junit.framework.Assert;

public class Tc_LoginGDDT_002 extends BaseClass {

	@Test (dataProvider = "Logindata")
	public void loginDDT(String user, String Psd) {
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		lp.setPassword(Psd);
		lp.clickLoginBtn();
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			
		}else {
			
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
		}

	}
// User define Re-usable method ..................
	boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}	
	}
	
}
