package com.wipro.selenium;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvException;
public class Task1A2 extends Base{
//Please fill this contact form using CSS and Xpath.
	@Test(groups= {"mandatory","Assignment1"})
    public void test2() throws IOException, CsvException {
    Task1A2 ob=new Task1A2();
    Properties obj=ob.ReadObjectRepo();
    WebDriver driver=ob.driver();
	driver.get("https://demoqa.com/html-contact-form/");
	driver.manage().window().maximize();
	Reporter.log("Browser is launched now");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	String fn="",sn="",country="",subject="";	
	String[] str=ob.ReadData("normal");
	fn=str[1];sn=str[2];country=str[3];subject=str[4];
	System.out.println(str.length);
	
	driver.findElement(By.xpath(obj.getProperty("firstname"))).sendKeys(fn);
	driver.findElement(By.xpath(obj.getProperty("secondname"))).sendKeys(sn);
	driver.findElement(By.xpath(obj.getProperty("country"))).sendKeys(country);
	driver.findElement(By.xpath(obj.getProperty("subjectLine"))).sendKeys(subject);
	String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
	driver.findElement(By.linkText(obj.getProperty("googlelink"))).sendKeys(selectLinkOpeninNewTab);
	driver.findElement(By.linkText(obj.getProperty("googlelink2"))).sendKeys(selectLinkOpeninNewTab);
	driver.findElement(By.xpath(obj.getProperty("Submitbutton"))).click();
	System.out.println("Test pass");
	Reporter.log("Test 2 completed");
	driver.close();
	}

}

