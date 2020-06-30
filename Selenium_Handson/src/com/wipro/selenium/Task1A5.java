package com.wipro.selenium;


import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Please select the All the menu options one by one  https://demoqa.com/selectmenu/ 

public class Task1A5 extends Base{
	@Test(groups= {"mandatory","Assignment1"})
    public void test5() throws IOException {
        Task1A5 ob=new Task1A5();
        Properties obj=ob.ReadObjectRepo();
        WebDriver driver=ob.driver();
        driver.get("https://demoqa.com/selectmenu/");
        driver.manage().window().maximize();
        Reporter.log("Browser is launched now");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        WebElement speed=driver.findElement(By.xpath(obj.getProperty("selectspeed")));
        speed.click();
        List<WebElement> l=driver.findElements(By.xpath(obj.getProperty("speeddropdownselect")));
        for(WebElement e:l)
        {
            if(e.getText().equalsIgnoreCase("Faster"))
                e.click();
        }
        System.out.println(speed.getText());
        Assert.assertTrue(speed.getText().equalsIgnoreCase("FASTER"));
        
        WebElement file=driver.findElement(By.xpath(obj.getProperty("selectfile")));
        file.click();
        List<WebElement> fl=driver.findElements(By.xpath(obj.getProperty("filedropdownselect")));
        for(WebElement e:fl)
        {
            if(e.getText().equalsIgnoreCase("ui.jQuery.js"))
                e.click();
        }
        System.out.println(file.getText());
        Assert.assertTrue(file.getText().equalsIgnoreCase("ui.jQuery.js"));
        
        WebElement no=driver.findElement(By.xpath(obj.getProperty("selectnumber")));
        no.click();
        List<WebElement> nl=driver.findElements(By.xpath(obj.getProperty("numberdropdownselect")));
        for(WebElement e:nl)
        {
            if(e.getText().equalsIgnoreCase("3"))
                e.click();
        }
        System.out.println(no.getText());
        Assert.assertTrue(no.getText().equalsIgnoreCase("3"));
        WebElement title=driver.findElement(By.xpath(obj.getProperty("selecttitle")));
        title.click();
        List<WebElement> tl=driver.findElements(By.xpath(obj.getProperty("titledropdownselect")));
        for(WebElement e:tl)
        {
            if(e.getText().equalsIgnoreCase("Dr."))
                e.click();
        }
        System.out.println(title.getText());
        Assert.assertTrue(title.getText().equalsIgnoreCase("Dr."));
        System.out.println("Test Pass");
        Reporter.log("Test5 completed");
        driver.close();
    }
}		
		



