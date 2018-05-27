package com.msd.selenium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CurrencyRatesTest{
	private WebDriver driver;
	private Map<String, Double> ratesMapFromApi;
	
	@Before
	public void setUp(){
		System.out.println("In setUp() ");
		//change the gecko driver path		
		System.setProperty("webdriver.gecko.driver","C:\\E\\Shobha\\prof\\Dev-Shobha\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://mosaic-test-app.s3-website.eu-west-2.amazonaws.com/");
	
		ratesMapFromApi = new HashMap<String, Double>();
		ratesMapFromApi.put("AUD",1.7619);
		ratesMapFromApi.put("BGN",2.2342);
		ratesMapFromApi.put("BRL",4.8611);
		ratesMapFromApi.put("CAD",1.7279);
		ratesMapFromApi.put("CHF",1.3243);
		ratesMapFromApi.put("CNY",8.5231);
		ratesMapFromApi.put("CZK",29.432);
		ratesMapFromApi.put("DKK",8.5087);
		ratesMapFromApi.put("EUR",1.1423);
		ratesMapFromApi.put("HKD",10.463);
		ratesMapFromApi.put("HRK",8.4424);
		ratesMapFromApi.put("HUF",365.43);
		ratesMapFromApi.put("IDR",18820.0);
		ratesMapFromApi.put("ILS",4.7466);
		ratesMapFromApi.put("INR",90.416);
		ratesMapFromApi.put("ISK",141.42);
		ratesMapFromApi.put("JPY",145.9);
		ratesMapFromApi.put("KRW",1438.9);
		ratesMapFromApi.put("MXN",26.146);
		ratesMapFromApi.put("MYR",5.3081);
		ratesMapFromApi.put("NOK",10.839);
		ratesMapFromApi.put("NZD",1.9285);
		ratesMapFromApi.put("PHP",70.186);
		ratesMapFromApi.put("PLN",4.9223);
		ratesMapFromApi.put("RON",5.2887);
		ratesMapFromApi.put("RUB",82.812);
		ratesMapFromApi.put("SEK",11.643);
		ratesMapFromApi.put("SGD",1.788);
		ratesMapFromApi.put("THB",42.598);
		ratesMapFromApi.put("TRY",6.3003);
		ratesMapFromApi.put("USD",1.3337);
		ratesMapFromApi.put("ZAR",16.671);
	      
	}
	
	@After
	public void teaDown(){
		System.out.println("In tearDown() ");
		driver.quit();
	}
	@SuppressWarnings("deprecation")
	@Test	
	public void validCcyRatesTest() throws Exception{
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
		Thread.sleep(5000);	
		// Grab the table
		WebElement table = driver.findElement(By.tagName("tbody"));

		// copy ccy and rate into a map to compare with the API values
		Map <String, Double> actualRatesMap = new HashMap<>();
		
		// Now get all the TR elements from the table
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		// And iterate over them, getting the cells
		for (WebElement row : allRows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			String ccyFromTheRow = (String)cells.get(0).getText(); // ccy cell
			String rateFromTheRow = (String)cells.get(1).getText();	 // rate cell
			double actualRate = Double.parseDouble(rateFromTheRow);
			actualRatesMap.put(ccyFromTheRow, actualRate);
			
		}
		System.out.println("After for loop actualRatesMap size is " + actualRatesMap.size());
	
		// compare both api map and actual results have same number of currencies/rates
		Assert.assertEquals("Comparing the No of currencies", ratesMapFromApi.size(), actualRatesMap.size());
		
		// compare rate for each ccy
		for (Map.Entry<String, Double> entry : ratesMapFromApi.entrySet()) {
		    String ccy = entry.getKey();
		    Double rateFromApi = entry.getValue();
		    Double actualRate = actualRatesMap.get(ccy);
		    Assert.assertNotNull("Rates for ccy: " + ccy, actualRate);
		    Assert.assertEquals("Rates for ccy: "+ ccy, rateFromApi, actualRate, 0.0d);
		}
	}
}
		
	


	 

	


