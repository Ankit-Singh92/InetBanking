package com.InetBankingV1.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "uid")
	@CacheLookup
	WebElement txt_username;

	@FindBy(name = "password")
	@CacheLookup
	WebElement txt_password;

	@FindBy(name = "btnLogin")
	WebElement btn_Login;
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement lnkLogout;

	public void setUserName(String username) {
		txt_username.sendKeys(username);
	}

	public void setPassword(String password) {
		txt_password.sendKeys(password);
	}

	public void clickLoginBtn() {
		btn_Login.click();
	}
	public void clickLogout()
	{
		lnkLogout.click();
	}

}
