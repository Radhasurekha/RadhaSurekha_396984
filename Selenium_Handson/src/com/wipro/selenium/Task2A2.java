package com.wipro.selenium;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvException;

import org.testng.Reporter;
@SuppressWarnings("unused")
public class Task2A2 extends Base {
	 @Test(groups= {"mandatory","Assignment1"})
// Validate invalid password validation, forgot password
	public void test4() throws IOException 
    {
	Task2A2 ob=new Task2A2();
    Properties obj=ob.ReadOlayProperties();
    WebDriver driver=ob.driver();	
	driver.get("https://www.olay.co.uk/en-gb");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    driver.findElement(By.xpath(ob.ReadObjectRepo().getProperty("signin"))).click();
    driver.findElement(By.xpath(ob.ReadObjectRepo().getProperty("signinemail"))).sendKeys(ReadOlayProperties().getProperty("invalidemail"));
    driver.findElement(By.xpath(ob.ReadObjectRepo().getProperty("signinpassword"))).sendKeys(ReadOlayProperties().getProperty("invalidpass"));
    driver.findElement(By.xpath(ob.ReadObjectRepo().getProperty("signinsubmit"))).click();
    driver.findElement(By.xpath(ob.ReadObjectRepo().getProperty("invaliderror")));
    driver.findElement(By.xpath(ob.ReadObjectRepo().getProperty("forgotpassward"))).click();
    driver.findElement(By.xpath(ob.ReadObjectRepo().getProperty("resetpasspage")));
    Reporter.log("invali and forgotpassword completed");
    driver.close();
    
    

    }
	}
