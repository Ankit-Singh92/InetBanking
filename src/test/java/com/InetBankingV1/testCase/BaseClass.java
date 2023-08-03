package com.InetBankingV1.testCase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.InetBankingV1.utilities.ReadConfig;
import com.InetBankingV1.utilities.XLUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	/*
	 * Reading the data from the config.propertiesfile
	 * from read config class 
	 */
	ReadConfig readconfig = new ReadConfig();
	public String url = readconfig.getApplicationUrl();
	public String username = readconfig.getUserName();
	public String password = readconfig.getPassword();

	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String browser) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger = Logger.getLogger("InetBanking");
			PropertyConfigurator.configure("log4j.properties");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get(url);
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger = Logger.getLogger("InetBanking");
			PropertyConfigurator.configure("log4j.properties");
			driver.get(url);
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			logger = Logger.getLogger("InetBanking");
			PropertyConfigurator.configure("log4j.properties");
			driver.get(url);
			break;
		default:
			System.out.println("Invalid browser name");
			break;
		}
	}

	
	  @AfterClass public void tearDown() {
		  driver.quit(); 
		  }
	 

	public void captureScreenShot(WebDriver driver, String tname) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshot/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");

	}
	
	//method to read the data from excel file .............................
	@DataProvider(name="Logindata")
	String[][] getData() throws IOException
	{
		
		String path=System.getProperty("user.dir")+"/src/test/java/com/InetBankingV1/testData/LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "sheet1");
		int colcount=XLUtils.getCellCount(path, "sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for (int i=1;i<=rownum;i++) {
			for (int j=0;j<colcount;j++) {
				
				logindata[i-1][j]=XLUtils.getCellData(path, "sheet1", i,j);
			}
		}
		return logindata;
	}

}
