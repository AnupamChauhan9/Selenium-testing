package com.selenium.qa.tes;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Base.BaseC;
import qa.utilties.utility;

import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends BaseC {
	  public RegisterTest() {
	        super();
	    }
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		
		 driver = initBrowser(prop.getProperty("browser"));
		driver.findElement(By.className("dropdown")).click();
	}
	@Test
	public void validCredi() {
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Anupam");
		driver.findElement(By.id("input-lastname")).sendKeys("chauhan");
		driver.findElement(By.id("input-email")).sendKeys(utility.currentDate());
		driver.findElement(By.id("input-telephone")).sendKeys("9847456354");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		AssertJUnit.assertEquals(driver.findElement(By.cssSelector("#content h1")).getText(),"Your Account Has Been Created!");

	}
	@Test(priority =2)
	public void invalidcred() {
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Anupam");
		driver.findElement(By.id("input-lastname")).sendKeys("chauhan");
		driver.findElement(By.id("input-email")).sendKeys("anupam9837@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("9847456354");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		AssertJUnit.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText(),"Warning: E-Mail Address is already registered!");
	}
	@AfterMethod
	
	public void tearDown() {
		driver.quit();
	}
	

}
