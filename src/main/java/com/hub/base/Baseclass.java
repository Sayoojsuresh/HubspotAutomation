package com.hub.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hub.util.Actionsclass;

public class Baseclass {

	WebDriver driver;
	Properties prop;
	public WebDriver getbrowser(Properties prop)
	{
//		WebDriver driver=null;
		String Browser=prop.getProperty("Browser");
		String URL=prop.getProperty("url");
			if(Browser.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","C://Automation//Chromedriver1//chromedriver.exe");
				 driver=new ChromeDriver();
			
			}
			else{
				System.out.println("there is no other browser");
			}
		
		
		driver.get(URL);
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		return driver;
	}
	
	public Properties initprop() 
	{
	
		prop=new Properties();
		try{
		FileInputStream ip=new FileInputStream("C://Users//Sayooj Suresh//workspace//Hubspot//src//main//java//com//hub//config//config.properties");
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return prop;

	}
}
