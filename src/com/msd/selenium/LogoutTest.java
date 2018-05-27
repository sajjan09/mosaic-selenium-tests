package com.msd.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LogoutTest {

	private WebDriver driver;
	
	@Before
	public void setUp(){
		System.out.println("In setUp() ");
		//change the gecko driver path		
		System.setProperty("webdriver.gecko.driver","C:\\E\\Shobha\\prof\\Dev-Shobha\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://mosaic-test-app.s3-website.eu-west-2.amazonaws.com/");
	}
	
	@After
	public void teaDown(){
		System.out.println("In tearDown() ");
		driver.quit();
	}
	@Test	
	public void validLogoutTest(){
		WebElement username = driver.findElement(By.xpath("/html/body/div/div/main/form/input[1]"));
		username.sendKeys(new String[] { "shobha" });
		WebElement password = driver.findElement(By.xpath("/html/body/div/div/main/form/input[2]"));
		password.sendKeys(new String[] {"password123"});
		WebElement submit = driver.findElement(By.xpath("/html/body/div/div/main/form/input[3]"));
		submit.click();
		
		WebElement dashboardElement = driver.findElement(By.cssSelector(".h2"));
		System.out.println(dashboardElement.getText());
		
		WebElement todaysRateText = driver.findElement(By.xpath("/html/body/div/div/main/h2"));
		System.out.println(todaysRateText.getText());
		
		//Assuming the signout is working, dashboard should not be visible on the page after the signout
		WebElement signout = driver.findElement(By.xpath("/html/body/nav/ul/li/a"));
		signout.click();
		
		Boolean isDashboardStillVisibleAfterSignOut = driver.getPageSource().contains("Dashboard");
		System.out.println(" isDashboardStillVisibleAfterSignOut - " + isDashboardStillVisibleAfterSignOut);
		Assert.assertFalse("Dashboard text shouldnt be displayed after signout",isDashboardStillVisibleAfterSignOut);
	}
	
}
