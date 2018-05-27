package com.msd.selenium;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest{
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
	public void validLoginTest(){
		WebElement username = driver.findElement(By.xpath("/html/body/div/div/main/form/input[1]"));
		username.sendKeys(new String[] { "shobha" });
		WebElement password = driver.findElement(By.xpath("/html/body/div/div/main/form/input[2]"));
		password.sendKeys(new String[] {"password123"});
		WebElement submit = driver.findElement(By.xpath("/html/body/div/div/main/form/input[3]"));
		submit.click();
		
		WebElement dashboardElement = driver.findElement(By.cssSelector(".h2"));
		Assert.assertTrue(dashboardElement.getText().contains("Dashboard"));
		System.out.println(dashboardElement.getText());
		
		WebElement todaysRateText = driver.findElement(By.xpath("/html/body/div/div/main/h2"));
		Assert.assertTrue(todaysRateText.getText().contains("Today's rates"));
		System.out.println(todaysRateText.getText());
	}
	/**
	 * In the above test shobha/password123 logged in successfully. If we use same user but different password 
	 * then dashboard shouldnt be displayed
	 */
	@Test
	public void invalidLoginTest(){
		WebElement username = driver.findElement(By.xpath("/html/body/div/div/main/form/input[1]"));
		username.sendKeys("shobha");
		WebElement password = driver.findElement(By.xpath("/html/body/div/div/main/form/input[2]"));
		password.sendKeys("!!@##123456");
		WebElement submit = driver.findElement(By.xpath("/html/body/div/div/main/form/input[3]"));
		submit.click();
		WebElement dashboardElement = driver.findElement(By.cssSelector(".h2"));
		Assert.assertFalse("Dashboard page should not be displayed for invalid password!!" ,dashboardElement.getText().contains("Dashboard"));
		System.out.println("Cannot find " + dashboardElement.getText());
	}
	
}
		
	


	 

	


