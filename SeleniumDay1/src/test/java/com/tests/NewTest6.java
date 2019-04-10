package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewTest6 {
 
	  WebDriver driver;
		@BeforeTest
		public void beforetest()
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Training_b3a.00.39\\workspace\\SeleniumDay1\\driver\\chromedriver.exe");
		   driver =new ChromeDriver();
			driver.get("http://demowebshop.tricentis.com/login");
			  driver.manage().window().maximize();
			  
		}
	  @Test(dataProvider="dp1")
	  public void testValidUsersDemoWebShop(String username,String password) {
		 
		  driver.findElement(By.id("Email")).sendKeys(username);
		  driver.findElement(By.id("Password")).sendKeys(password);
		  driver.findElement(By.xpath("//input[@value='Log in']")).click();
		 /* driver.findElement(By.linkText("Log out")).click();
		  driver.findElement(By.linkText("Log in")).click();*/
		  
		  
	  }
	  @DataProvider(name="dp1")
	  public Object[][] provideData(){
		  return ReadExcel.excelextract();
  }
}
