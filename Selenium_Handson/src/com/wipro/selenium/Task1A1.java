package com.wipro.selenium;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.Reporter;
public class Task1A1 extends Base{

//Create a xpath or Css path for this Selectable Item and Click on each of the Items and print the Item Name
		    @Test(groups= {"mandatory","Assignment1"})
		    public void test1() throws IOException 
		    {
		    	Task1A1 ob=new Task1A1();
		        Properties obj=ob.ReadObjectRepo();
		        WebDriver driver=ob.driver();	
		        driver.get("https://demoqa.com/selectable/");
		        Reporter.log("Browser is launched now");
		        driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				
				//List of items
				List<WebElement> list=driver.findElements(By.xpath(obj.getProperty("SelectableItem")));
				for (WebElement webElement : list) {
		            String name = webElement.getText();
		            System.out.println(name);
		            Reporter.log(name);
				}
				System.out.println("Test Pass");
				Reporter.log("Test1 completed");
				driver.close();
		    
		    }
				
		    
	
}


	
