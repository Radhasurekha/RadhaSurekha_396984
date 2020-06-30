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
public class Task2A1 extends Base{
//Automate the below mentioned site for Registration and Login
	enum countries {UK,Germany,Spain};
		    @Test(groups= {"mandatory","Assignment1"})
		    @DataProvider(name = "RegisterandLoginData")     
		      public static Object[][] credentials() {     
		           return new Object[][] { { "radhavasoip@gmail.com","Qwerty@1","Qwerty@1","14","5","1992"}};
		    }
		    @Test(dataProvider="RegisterandLoginData",priority=0)
		    public void test7(String email,String pass,String confirmpass,String day,String month,String year) throws IOException, InterruptedException, CsvException
		    {
		    	  Task2A1 ob =new Task2A1();
		    	  WebDriver driver=ob.driver();
				    driver =ob.driver();
				    Properties obj=ob.ReadObjectRepo();
		   		    
		    	for(countries login : countries.values()) {
					
					switch(login) {
					case UK :
						driver.get("https://www.olay.co.uk/en-gb");
				        driver.manage().window().maximize();
				        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				        ob.registerOlay(email, pass, confirmpass, day, month, year, driver);
				        ob.signoutOlay(driver);
				        ob.signinOlay(email, pass, driver);
				        ob.signoutOlay(driver);
				        Reporter.log("UK registration completed");
						break;
					case Spain:
						 driver.get("https://www.olay.es/es-es");
					        driver.manage().window().maximize();
					        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
					        //data will be taken from properties file and the method is implemented in base class
					        ob.registerOlaySpain(driver);
					        Properties p=ob.ReadOlayProperties();
					        String Email=p.getProperty("email"),Pass=p.getProperty("pass");
					        ob.signinOlay(Email, Pass, driver);
					        ob.signoutOlay(driver);
					        Reporter.log("Spain registration completed");
					        break;
					case Germany:
						  driver.get("https://www.olaz.de/de-de");
					        driver.manage().window().maximize();
					        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
					        String[] od=ob.ReadOlayData("olayuser");
					        String fn=od[1],sn=od[2],Email1=od[3],Pass1=od[4],ConfirmPass=od[5],Day=od[6],Month=od[7],Year=od[8],strabe=od[9],postle=od[10],ort=od[11];
					        ob.registerOlayGermany(fn,sn,Email1,Pass1,ConfirmPass,Day,Month,Year,strabe,postle,ort, driver);
					        ob.signoutOlay(driver);
					        ob.signinOlay(Email1, Pass1, driver);
					        ob.signoutOlay(driver);
					        Reporter.log("Germany Registration completed");
					        break;
										
					default :
						System.out.println("Please provide valid country");
					}
		    	}
		    }
					
					 @DataProvider(name = "LoginDetails")     
				      public static Object[][] Details() {     
				           return new Object[][] { { "radhavas1@gmail.com","Qwerty@1"},{ "radhavas1@gmail.com","Qwerty@1"}};
				    }
				    @Test(dataProvider="LoginDetails",priority=2)
				    public void signinvalidation(String email,String pass) throws IOException
				    
				    {   
				    	 Task2A1 ob=new Task2A1();
				    	 WebDriver driver=ob.driver();
						    driver =ob.driver();
						    Properties obj=ob.ReadObjectRepo();
						    
				        driver.get("https://www.olay.co.uk/en-gb");
				        driver.manage().window().maximize();
				        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				        driver.findElement(By.xpath(ob.ReadObjectRepo().getProperty("signin"))).click();
				        driver.findElement(By.xpath(ob.ReadObjectRepo().getProperty("signinemail"))).sendKeys(email);
				        driver.findElement(By.xpath(ob.ReadObjectRepo().getProperty("signinpassword"))).sendKeys(pass);
				        driver.findElement(By.xpath(ob.ReadObjectRepo().getProperty("signinsubmit"))).click();
				        Reporter.log("Login completed");
				        driver.close();
				    }  
				    
				      
}
		    
