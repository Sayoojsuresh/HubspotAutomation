package com.hub.testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hub.base.Baseclass;
import com.hub.pages.Contactspage;
import com.hub.pages.Homepage;
import com.hub.pages.Loginpage;
import com.hub.util.Excelutil;

public class Contactstest {
Properties prop;
WebDriver driver;
Baseclass basepage;
Loginpage loginpage;
Homepage homepage;
Contactspage contactspage;
	
	@BeforeMethod
	public  void setup()
	{
		
		basepage=new Baseclass();
		prop=basepage.initprop();
		driver=basepage.getbrowser(prop);
		loginpage=new Loginpage(driver);
	homepage=	loginpage.dologin(prop.getProperty("username"), prop.getProperty("password"));
	contactspage=homepage.doclickcontacts();
	
	
		
	}
	@DataProvider
	public Object[][] gettestdata()
	{
		Object data[][]=Excelutil.getdata("contacts");
		return data;
	}
	
	@Test(priority=1,dataProvider="gettestdata")
	public void addcontacts(String Email,String FirstName,String LastName,String JobTitle)
	{
		
		contactspage.createcontact(Email, FirstName, LastName, JobTitle);
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
