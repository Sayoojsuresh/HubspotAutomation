package com.hub.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hub.base.Baseclass;
import com.hub.util.Actionsclass;

public class Homepage extends Baseclass{
	
	WebDriver driver;
	Actionsclass actionsclass;
	

	public Homepage(WebDriver driver) {
		this.driver=driver;
		actionsclass=new Actionsclass(driver);
	}
	
	By textpresent=By.xpath("//*[text()='Sales Dashboard']");
	By username=By.xpath("//*[text()='XYZ']");
	By contactslink=By.xpath("(//*[@id='nav-primary-contacts-branch'])[1]");
	By contacts=By.xpath("(//*[contains(text(),'Contacts')]//parent::div)[1]");
	
	
	public String dochecktext()
	{
		actionsclass.getwait(textpresent);
		WebElement text=actionsclass.getElement(textpresent);
		String s= text.getText();
		return s;
	}
	
	public String docheckusername()
	{
		WebElement a=actionsclass.getElement(username);
		String k=a.getText();
		return k;
	}
	
	public Contactspage doclickcontacts()
	{
		actionsclass.doclick(contactslink);
		actionsclass.doclick(contacts);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return new Contactspage(driver);
	}

	
	

}
