package com.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest2 {
  @Test
  public void testKeys() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\Training_b3a.00.39\\workspace\\SeleniumDay1\\driver\\chromedriver.exe");
	  WebDriver driver =new ChromeDriver();
	  driver.get("https://www.cleartrip.com/");
	  driver.manage().window().maximize();
	  Thread.sleep(3000);
	  WebElement from=driver.findElement(By.id("FromTag"));
	 /* from.sendKeys("h");
	  from.sendKeys("y");
	  from.sendKeys("d");*/
	  Actions act1=new Actions(driver);
	  act1.keyDown(from, Keys.SHIFT).perform();
	  act1.sendKeys(from, "h").perform();
	  Thread.sleep(2000);
	  act1.sendKeys("y").perform();
	  Thread.sleep(2000);
	  act1.sendKeys("d").perform();
	  Thread.sleep(5000);
	  act1.sendKeys(Keys.ENTER).perform();
	  
	  WebElement to=driver.findElement(By.id("ToTag"));
	  to.sendKeys("n");
	  to.sendKeys("e");
	  to.sendKeys("w");
	  //Thread.sleep(5000);
	  WebDriverWait wait= new WebDriverWait(driver,10);
	  wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(By.id("ui-id-2"),By.className("list")));
	  WebElement u1=driver.findElement(By.id("ui-id-2"));
	  List<WebElement> list=u1.findElements(By.tagName("li"));
	  
	  for(WebElement e:list)
	  {
		  if(e.getText().contains("DEL"))
		  {
			  e.click();
			  break;
		  }
	  }
	 // Assert.assertTrue(condition);
	 /* Actions act2=new Actions(driver);
	  act2.sendKeys(to,"b").perform();
	  Thread.sleep(2000);
	  act2.sendKeys("a").perform();
	  Thread.sleep(2000);
	  act2.sendKeys("n").perform();
	  Thread.sleep(5000);
	  //act2.sendKeys("g").perform();
	  
	  act2.sendKeys(Keys.ENTER).perform();
	  */
	  
	  
  }
}
