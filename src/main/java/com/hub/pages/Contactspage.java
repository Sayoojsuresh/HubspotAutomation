package com.hub.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.hub.base.Baseclass;
import com.hub.util.Actionsclass;

public class Contactspage extends Baseclass {
WebDriver driver;
Actionsclass actionsclass;
	
	public  Contactspage(WebDriver driver)
	{
		this.driver=driver;
		actionsclass=new Actionsclass(this.driver);
	}
	
	By createcontacts=By.xpath("//span[contains(text(),'Create contact')]");
	By email=By.xpath("//input[@data-field='email']");
	By Firstname=By.xpath("//input[@data-field='firstname']");
	By Lastname=By.xpath("//input[@data-field='lastname']");
	By jobtitle=By.xpath("//input[@data-field='jobtitle']");
	By Contactsbutton=By.xpath("//div[contains(text(),'Create contact')]");
	
	
	public void createcontact(String Email,String FirstName,String LastName,String JobTitle)
	{
		actionsclass.waitforelement(createcontacts);
	actionsclass.doClickbyactions(createcontacts);
	actionsclass.waitforelement(email);
	actionsclass.dosendkeysbyactions(email,Email);

	actionsclass.dosendkeysbyactions(Firstname,FirstName);

	actionsclass.dosendkeysbyactions(Lastname,LastName);

	actionsclass.dosendkeysbyactions(jobtitle,JobTitle);
		
	
	
		
	}
			
	
	
	
	
}



