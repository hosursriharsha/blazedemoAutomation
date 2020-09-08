package com.blazedemo.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
 protected static WebDriver driver;
 protected static String browser;
 
 @BeforeTest
 public void launchBrowser() {
	 if(browser.equalsIgnoreCase("Chrome")) {
		 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 }
 }

 
 @BeforeSuite
 private void getBrowser(ITestContext context) {
	 browser= context.getCurrentXmlTest().getLocalParameters().get("browser");
 }
 
 protected boolean isElementDisplayed(String element) {
	 return locateElement(element).isDisplayed();
 }
 
 protected WebElement locateElement(String element) {
	 WebElement webelement=null;
	 if(element.startsWith("id")) {
		 webelement= driver.findElement(By.id(element.split("=")[1]));
	 }
	 else if(element.startsWith("xpath")) {
		 webelement= driver.findElement(By.xpath(element.split("xpath=")[1]));
	 }
	 return webelement;
 }
 
 
 protected String getValue(String key) {
	 Properties property=new Properties();
	 try {
		 property.load(new FileInputStream(System.getProperty("user.dir") + "/src/test/java/resources/locator.properties"));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	 return property.getProperty(key);
 }
 
 protected void selectByVisibleText(String element,String text) {
	 Select select=new Select(locateElement(element));
	 select.selectByVisibleText(text);
 }
 
 protected void clickElement(String element) {
	 locateElement(element).click();
 }
 
 protected void sendKeys(String element,String text) {
	 locateElement(element).sendKeys(text);
 }
 
 protected void scrollAndClick(String element,int noOfTimes) {
	 for(int i=1;i<=noOfTimes;i++) {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,200)");
	 }
	 clickElement(element);
	 }
 
 protected void launchURL() {
	driver.get("https://blazedemo.com/index.php"); 
 }
 
 protected String returnSelectedOption(String element) {
	 Select select=new Select(locateElement(element));
	 return select.getFirstSelectedOption().getText();
 }
}
