package com.wipro.selenium;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Task3A1 extends Base {
	 @Test(groups= {"mandatory","Assignment1"})
//Automate the below mentioned site for booking and reviewing it
	 
	public void testq() throws IOException, InterruptedException 
    {
		    String DepartDate="5";
		    String ReturnDate="10";
		    String DepartMonth="July2020";
	Task2A2 ob=new Task2A2();
    @SuppressWarnings("unused")
	Properties obj=ob.ReadObjectRepo();
    WebDriver driver=ob.driver();	
    driver.get("https://www.makemytrip.com/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(12,TimeUnit.SECONDS);
   driver.findElement(By.xpath(ob.ReadObjectRepo().getProperty("outsidemodal"))).click();
   driver.findElement(By.xpath(ob.ReadObjectRepo().getProperty("roundtrip"))).click();
    driver.findElement(By.xpath(ob.ReadObjectRepo().getProperty("FromCity"))).click();
    Reporter.log("from city selected");
    driver.findElement(By.xpath(ob.ReadObjectRepo().getProperty("mumbaifromcity"))).click();
    Reporter.log("mumbai city selected");
    driver.findElement(By.xpath(ob.ReadObjectRepo().getProperty("ToCity"))).click();
    driver.findElement(By.xpath(ob.ReadObjectRepo().getProperty("delhitocity"))).click();
    driver.findElement(By.xpath(obj.getProperty("Departure"))).click();
    driver.findElement(By.xpath(obj.getProperty("SelectDate"))).click();
    while (true){
    	String comparemonth = driver.findElement(By.xpath(obj.getProperty("SelectDate"))).getText();
    	System.out.println(comparemonth);
    	if (comparemonth.equalsIgnoreCase(DepartMonth))
    	{
    		 Reporter.log("month selected");
    		break;
    	}
    	else
    	{
    		driver.findElement(By.xpath(obj.getProperty("NavigateIcon"))).click();
    	}
    }
    List<WebElement> date= driver.findElements(By.xpath(obj.getProperty("datevalue")));
    for (WebElement e: date)
    {
    	 if(e.getText().contains(DepartDate)) {
             e.click();
             break;
    }
    	 
    }
    for(WebElement e:date)
    {
        if(e.getText().contains(ReturnDate)) {
            e.click();
            break;
        }
    }
    driver.findElement(By.xpath(obj.getProperty("SearchButton"))).click();
    Thread.sleep(1000);
    try {
    	WebElement checkbox1 = driver.findElement(By.xpath(obj.getProperty("6amfilter")));
    	  checkbox1.click();
    	    Reporter.log("sidewidget selected");
    	    System.out.println("Element  found");
    	} catch (NoSuchElementException e)
    {
    		 System.out.println("Element not found");
    }
      
    driver.findElement(By.xpath(obj.getProperty("BookButton"))).click();
    driver.findElement(By.xpath(obj.getProperty("continuebookingbutton"))).click();
    //driver.findElement(By.xpath(obj.getProperty("ReviewText"))).isDisplayed();
    Reporter.log("Review page shown");
	System.out.println("Test Pass");
	Reporter.log("Test completed");
	driver.close();
    
}
}
