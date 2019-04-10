package com.tests;

import javax.swing.text.Document;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest3 {
  @Test
  public void testvisa() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\Training_b3a.00.39\\workspace\\SeleniumDay1\\driver\\chromedriver.exe");
	  WebDriver driver =new ChromeDriver();
	  driver.get("https://www.hdfcbank.com/");
	  driver.manage().window().maximize();
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("document.getElementById('netsafe').click()");
	  //js.executeScript("window.scrollBy(0,1000)");
	  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	  String title=(String)js.executeScript("return document.title");
	  System.out.println(title);
	  driver.get("http://demowebshop.tricentis.com/login");
	  js.executeScript("document.getElementById('Email').value='jp123@gmail.com'");
  }
}
