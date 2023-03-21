package com.safeStopsProvider.SafeStopsProvider.web;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageTest {
	
	public WebDriver driver;
	
	@BeforeTest
	public void setup() throws Exception {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
	
	@Test
	public void getLandingPage() {
		driver.get("http://localhost:8080");
		WebElement element = driver.findElement(By.tagName("p"));
		String expected = "Hit the road safely!";
		assertEquals(element.getText(), expected);
	}

}
