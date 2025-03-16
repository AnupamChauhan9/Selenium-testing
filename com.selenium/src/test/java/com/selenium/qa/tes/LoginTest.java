package com.selenium.qa.tes;
import org.testng.annotations.AfterMethod;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.ITestContext;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.BaseC;
import qa.utilties.utility;
import testObject.loginPage;

public class LoginTest extends BaseC {
	WebDriver driver;
	loginPage lg;
	Iterator<Cookie> itr ;
	
	

	
	public LoginTest()
	{
		super();
	}
	
	//String [] nameBrowser = {prop.getProperty("browser1"),prop.getProperty("browser2")};
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Parameters("browser")
	@BeforeMethod

	public void setup(ITestContext context,String browser) throws IOException, Throwable {
		
		//driver = seleniumGrid(browser);
		driver = initBrowser(browser);
		//driver = initBrowser(prop.getProperty("browser1"));
		 lg = new loginPage(driver);
		 context.setAttribute("WebDriver", driver);
		 Set<Cookie> n =driver.manage().getCookies();
		 itr = n.iterator();
		 while(itr.hasNext()){
			 System.out.println(itr.next());
		 }
		 
		
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
		System.out.println(System.getProperty("log4j.configurationFile"));
		File file = new File("src/test/resources/log4j2.xml");
		System.out.println("File exists: " + file.exists());

		AssertJUnit.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText(),"anupam");
		
	}
	
}
