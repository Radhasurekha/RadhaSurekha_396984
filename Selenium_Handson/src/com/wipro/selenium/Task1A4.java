package com.wipro.selenium;


import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Task1A4 extends Base{
//Please select your Date of Birth in a Calendar. 
	@Test(groups= {"mandatory","Assignment1"})
    public void test4() throws IOException {
        Task1A4 ob=new Task1A4();
        Properties obj=ob.ReadObjectRepo();
        WebDriver driver=ob.driver();
		driver.get("https://demoqa.com/datepicker/");
		driver.manage().window().maximize();
		Reporter.log("Browser is launched now");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		String dob="05/21/1992";
		WebElement element=driver.findElement(By.id(obj.getProperty("datepick")));
		element.sendKeys(dob);
		element.sendKeys(Keys.ENTER);
		System.out.println("Test Pass");
		Reporter.log("Test4 completed");
		driver.close();	
	}
}