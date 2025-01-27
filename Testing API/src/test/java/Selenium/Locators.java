package Selenium;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;




public class Locators {



	public static void main(String[] args) throws InterruptedException {

	// TODO Auto-generated method stub

	//implicit wait - 2 seconds time out


	//System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");

	WebDriver driver = new ChromeDriver();

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	driver.get("https://rahulshettyacademy.com/locatorspractice/");
//
//	driver.findElement(By.id("inputUsername")).sendKeys("rahul");
//
//	driver.findElement(By.name("inputPassword")).sendKeys("hello123");
//
//	driver.findElement(By.className("signInBtn")).click();
//
//	System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
//
//driver.findElement(By.linkText("Forgot your password?")).click();
//
//	Thread.sleep(1000);
//
//	driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
//
//	driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");
//
//	driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
//

//
//	System.out.println(driver.findElement(By.cssSelector("form p")).getText());
//
//	driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
//
//	Thread.sleep(1000);

	driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");

	driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(getPassword(driver));
	driver.findElement(By.cssSelector("div button:first-child")).click();
	Thread.sleep(1000);

	driver.findElement(By.id("chkboxOne")).click();

	driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
	Assert.assertEquals(driver.findElement(By.cssSelector("div p:nth-child(3)")).getText(), "You are successfully logged in.");
	driver.quit();
	





	}
	public static String getPassword(WebDriver driver) throws InterruptedException{
		
		driver.findElement(By.linkText("Forgot your password?")).click();
	driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");
		
driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253");
Thread.sleep(1000);	
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		String text =  driver.findElement(By.cssSelector("form p.infoMsg")).getText();
		System.out.println(text);
		String first = text.split("'")[1];
		String finl = first.split("'")[0];

	return finl;



	}


	}



