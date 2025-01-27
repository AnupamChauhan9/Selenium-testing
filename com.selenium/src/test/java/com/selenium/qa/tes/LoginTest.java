package com.selenium.qa.tes;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.ITestContext;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseC;
import qa.utilties.utility;
import testObject.loginPage;

public class LoginTest extends BaseC {
	WebDriver driver;
	loginPage lg;
	
	public LoginTest()
	{
		super();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@BeforeMethod
	public void setup(ITestContext context) {
		
		driver = initBrowser(prop.getProperty("browser"));
		 lg = new loginPage(driver);
		 context.setAttribute("WebDriver", driver);

		
		driver.findElement(By.className("dropdown")).click();
	}
	
	@Test(priority =1,dataProvider = "data")
	public void validCred(String email,String Passowd) {
		lg.clickOnLoginDrop();
		//driver.findElement(By.linkText("Login")).click();
		lg.enterEmail(email);
		//driver.findElement(By.id("input-email")).sendKeys(email);
		lg.enterPassword(Passowd);
		//driver.findElement(By.id("input-password")).sendKeys(Passowd);
		lg.login();
		//driver.findElement(By.xpath("//input[@value = 'Login']")).click();
		AssertJUnit.assertEquals(driver.findElement(By.cssSelector("#content li a")).getText(),testpro.getProperty("successmessage"));
		
	}
	@DataProvider(name = "data")
	public Object supply() {
//		Object[][] data = {{"anupam9837@gmail.com","12345"},
//				{"anupam983@gmail.com","12345"},
//				{"anupam98@gmail.com","12345"}};
		Object[][] data = utility.getDataXl("login");
		return data;
	}
	@Test(priority =2)
	public void  invalidCrede() {
		driver.findElement(By.linkText("Login")).click();;
		driver.findElement(By.id("input-email")).sendKeys(utility.currentDate());
		driver.findElement(By.id("input-password")).sendKeys(testpro.getProperty("invalidpassword"));
		driver.findElement(By.xpath("//input[@value = 'Login']")).click();

		AssertJUnit.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText(),testpro.getProperty("failmessage"));

	}
	@Test(priority =3)
	public void  invalidPasswordCrede() {
		driver.findElement(By.linkText("Login")).click();;
		driver.findElement(By.id("input-email")).sendKeys(utility.currentDate());
		driver.findElement(By.id("input-password")).sendKeys(testpro.getProperty("invalidpassword"));
		driver.findElement(By.xpath("//input[@value = 'Login']")).click();

		AssertJUnit.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText(),testpro.getProperty("failmessage"));

	}
	@Test(priority =4)
	public void  invalidEmailCrede() {
		driver.findElement(By.linkText("Login")).click();;
		driver.findElement(By.id("input-email")).sendKeys(utility.currentDate());
		driver.findElement(By.id("input-password")).sendKeys(testpro.getProperty("invalidpassword"));
		driver.findElement(By.xpath("//input[@value = 'Login']")).click();

		AssertJUnit.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText(),"anupam");

	}
	
}
