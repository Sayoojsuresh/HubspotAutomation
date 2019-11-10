package com.hub.testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hub.base.Baseclass;
import com.hub.pages.Homepage;
import com.hub.pages.Loginpage;

public class Logintest {
	WebDriver driver;
	Baseclass basepage;
	Properties prop;
	Loginpage loginpage;
	Homepage homepage;
	
	@BeforeMethod
	public void setup() 
	{
		basepage=new Baseclass();
		 prop=basepage.initprop();
		driver= basepage.getbrowser(prop);
		 loginpage=new Loginpage(driver);
		 homepage=new Homepage(driver);
		
	}
	@Test(priority=1)
	public void gettingtitle()
	{
		

		String title=loginpage.gettitle();
		System.out.println(title);

	}

	@Test(priority=2)
	public void login()
	{
		homepage=loginpage.dologin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=3)
	public void signup()
	{
		Assert.assertTrue(loginpage.linkisdisplayed());
		loginpage.dosignup();
	}
	
	@Test(priority=4)
	public void privacylink()
	{
		loginpage.doprivacy(); 
	}
	@AfterMethod
public void teardown()
{
		driver.quit();
}
}
