package com.InetBankingV1.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties prop;
	public ReadConfig(){
		File src=new File("./Configuration\\Config.properties");
		try {
		FileInputStream fis=new FileInputStream(src);
		 prop=new Properties();
		 prop.load(fis);	
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public String getApplicationUrl() {
		String url=	 prop.getProperty("url");
	    return url;
	}
	
	public String getUserName()	{
		
		String username=prop.getProperty("username");
		return username;
		
	}
	public String getPassword()	{
		
		String psd=prop.getProperty("password");
		return psd;
		
	}
	public String getCustomerId(){
	String custid=	prop.getProperty("customerid");
		return custid;
		
	}
	
	
	
}
