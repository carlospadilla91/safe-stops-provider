package com.safeStopsProvider.SafeStopsProvider.web;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserTest {
	
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
	
	@Test(priority = 1)
	public void registerUser() {
		driver.get("http://localhost:8080/register");
		
		WebElement email = driver.findElement(By.id("email"));
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement submit = driver.findElement(By.id("submit"));
		
		email.sendKeys("email@email.com");
		username.sendKeys("user");
		password.sendKeys("password");
		
		submit.click();
		
		new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.urlToBe("http://localhost:8080/login"));
		
		assertEquals(driver.getCurrentUrl(), "http://localhost:8080/login");
		
	}
	
	@Test(priority = 2)
	public void loginUser() {
		driver.get("http://localhost:8080/login");
		
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement submit = driver.findElement(By.id("submit"));
		
		username.sendKeys("user");
		password.sendKeys("password");
		
		submit.click();
		
		new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.urlToBe("http://localhost:8080/safeStops"));
		
		assertEquals(driver.getCurrentUrl(), "http://localhost:8080/safeStops");
	}

}
