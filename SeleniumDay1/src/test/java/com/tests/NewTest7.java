package com.tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
//import org.apache.poi.hpsf.Date;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class NewTest7 {
	ExtentHtmlReporter htmlreporter;
	ExtentReports reports;
	ExtentTest logger;
	WebDriver driver;
	@BeforeTest
	public void beforeTest()
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss-ms");
		htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/extent-reports/"+sdf.format(new Date())+".html");
		reports=new ExtentReports();
		reports.attachReporter(htmlreporter);
		reports.setSystemInfo("host","localhost training lkm");
		reports.setSystemInfo("username", "aswani.kumar.avilala");
		htmlreporter.config().setTheme(Theme.DARK);
		htmlreporter.config().setReportName("report for demo webshop");
	}
	
  @Test
  public void testpass() {
	  logger=reports.createTest("test pass");
	  logger.log(Status.PASS,"THIS TEST IS PASSED");
	  
  }
	
  @Test
  public void testfail() {
	  logger=reports.createTest("test fail");
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\Training_b3a.00.39\\workspace\\SeleniumDay1\\driver\\chromedriver.exe");
	  driver =new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/login");
		driver.findElement(By.id("Email")).sendKeys("kriya123@gmail.com");
		  driver.findElement(By.id("Pass")).sendKeys("siya678@gmail.com");
	  
	//Assert.assertTrue(false);
	  
  }
	
  @Test
  public void testskip() {
	  logger=reports.createTest("test skip");
	  throw new SkipException("the test is skipped");
	  
	  
  }
	
  @AfterMethod
  public void afterMethod(ITestResult result) {
	  if(result.getStatus()==ITestResult.FAILURE)
	  {
		  //logger.log(Status.FAIL,MarkupHelper.createLabel( "this tEST IS SKIPPED",ExtentColor.RED));
		  logger.log(Status.FAIL,MarkupHelper.createLabel( "this test"+result.getMethod().getMethodName()+" is failed",ExtentColor.RED));
	 TakesScreenshot capture=(TakesScreenshot) driver;
	 File src=capture.getScreenshotAs(OutputType.FILE);
	 String capturePath=System.getProperty("user.dir")+"/extent-reports/capture/"+result.getMethod().getMethodName()+".png";
	  try {
		  FileUtils.copyFile(src,new File(capturePath));
		  logger.addScreenCaptureFromPath(capturePath, "demo web shop screen");
		  logger.log(Status.FAIL,result.getThrowable().getMessage());
	  }catch(IOException e) {
		  e.printStackTrace();}
	  }
	  
	  
	  
	  else if(result.getStatus()==ITestResult.SKIP)
	  {
		  logger.log(Status.SKIP, "this test is skipped");
		 // logger.log(Status.SKIP,MarkupHelper.createLabel( "this tEST n   IS SKIPPED",ExtentColor.BLUE));
	  }
  }
	
  @AfterTest
  public void afterTest() {
	  reports.flush();
	  
  }
}
