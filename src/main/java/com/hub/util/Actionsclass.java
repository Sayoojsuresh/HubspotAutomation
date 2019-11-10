package com.hub.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actionsclass {
WebDriver driver;

public Actionsclass(WebDriver driver)
{
	this.driver=driver;
}
	
	public WebElement getElement(By locator)
	{
		WebElement element=null;
		getwait(locator);
		try{
			element=driver.findElement(locator);			
		}
		catch(Exception e)
		{
			System.out.println("some exception occured while "+locator);
		}
		return element;
	}
	
	public void getwait(By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}
	
	public boolean linkdisplayed(By locator)
	{
		return(getElement(locator).isSelected());
	}
	
	public void dosendkeys(By locator,String value)
	{
		try{
			getElement(locator).sendKeys(value);
		}
		catch(Exception e)
		{
			System.out.println("some exception occured while send keys to "+locator);
		}
	}
	
	public void doclick(By locator)
	{
		try{
			getElement(locator).click();
		}
		catch(Exception e)
		{
			System.out.println("some exception occured while clicking the"+locator);
		}
	}
		public void doClickbyactions(By locator)
		{
			Actions actions=new Actions(driver);
			actions.click(getElement(locator)).build().perform();
		}
		
	
	public void dosendkeysbyactions(By locator,String key)
	{
		Actions actions=new Actions(driver);
		actions.click(getElement(locator)).build().perform();
		actions.sendKeys(key).build().perform();;
	}
	
	public void waitforelement(By locator)
	{
		WebDriverWait wait= new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
					
}
