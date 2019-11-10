package com.hub.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hub.util.Actionsclass;

public class Loginpage {
	
	WebDriver driver;
	Actionsclass actionsclass;
	
	public Loginpage(WebDriver driver){
		this.driver=driver;
		actionsclass=new Actionsclass(driver); 
	}

	By Email=By.id("username");
	By Password=By.id("password");
	By loginbtn=By.id("loginBtn");
	By signup=By.xpath("//*[contains(text(),'Sign up')]");
	By privacylink=By.xpath("//*[contains(text(),'Privacy Policy')]");
	By 	Rememberme=By.cssSelector("span.private-checkbox__dash");
	
	
	public Homepage dologin(String username,String password)
	{
		actionsclass.dosendkeys(Email, username);
		actionsclass.dosendkeys(Password, password);
		actionsclass.doclick(loginbtn);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Homepage(driver);
		}
//public void selected()
//{
//	actionsclass.doclick(locator);
//}
//	
	public String gettitle()
	{
		
		return(driver.getTitle());
		}
	
	public boolean linkisdisplayed()
	{
		return(actionsclass.linkdisplayed(signup));
	}
	
	public SignUp dosignup()
	{	
		
	
		actionsclass.doclick(signup);
		return new SignUp(driver);
	
	}
	
	
	public void doprivacy()
	{
		actionsclass.doclick(privacylink);
	}
}
