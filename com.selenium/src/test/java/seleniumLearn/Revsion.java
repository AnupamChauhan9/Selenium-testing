package seleniumLearn;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Revsion {
	WebDriver driver;
	Actions action;
	@BeforeMethod
	public void setup() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("----disable-save-password-bubble");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
		//driver.get("https://omayo.blogspot.com/");
		
		//driver.get("https://r.search.yahoo.com/rdclks/dWU9M2YycmM4cGpxOWI2dCZ1dD0xNzM4ODQ1NDA1NzUyJnVvPTcxMDU2MTgzMzE0Mzc0Jmx0PTImcz0xJmVzPVVkYUx1YmkxRDFOMHJmWnpfRkNTeE9BR0V6aVpCaThhMGI5ZlJzUXNJRU5uM1k4c0NJRnpaOVltZm5nRkp0TTBPTWVlZ2toNW5DNDBOVzAt/RV=2/RE=1741437406/RO=14/RU=https%3a%2f%2fwww.bing.com%2faclick%3fld%3de8lIImrclJaAz1IwSJtZT6EDVUCUyOolBOJd12TclRcE9LjoHVIU77n2L5pqfWrR7vUKVDZnmojYh2y3pkg7-hvuJpdcPHv38b4xy70Dgoz4IuPHYfGh-zXLHjsEvKL1HcUED7eQOczirz-MEuATTWnQpk_eCXi8PXrSdSiuOeT6fdplzyvlNcAHSCeo-buDzrzexjOg%26u%3daHR0cHMlM2ElMmYlMmZwaXhlbC5ldmVyZXN0dGVjaC5uZXQlMmYxNjMxJTJmY3ElM2Zldl9zaWQlM2QzJTI2ZXZfbG4lM2RmbGlnaHQlMjUyMGJvb2tpbmclMjZldl9seCUzZGt3ZC03MTA1NjcwNTgyNzg0MyUzYWxvYy05MCUyNmV2X2NyeCUzZCUyNmV2X210JTNkZSUyNmV2X24lM2RvJTI2ZXZfbHR4JTNkJTI2ZXZfcGwlM2QlMjZldl9wb3MlM2QlMjZldl9kdmMlM2RjJTI2ZXZfZHZtJTNkJTI2ZXZfcGh5JTNkMTUwMDAzJTI2ZXZfbG9jJTNkJTI2ZXZfY3glM2QxNjAwMDg3ODYlMjZldl9heCUzZDgyNjI5NDc4NCUyNmV2X2VmaWQlM2QlM2FHJTNhcyUyNnVybCUzZGh0dHBzJTI1M0ElMjUyRiUyNTJGd3d3Lm1ha2VteXRyaXAuY29tJTI1MkZmbGlnaHRzJTI1M0ZjbXAlMjUzRFNFTSUyNTdDRCUyNTdDREYlMjU3Q0IlMjU3Q0JyYW5kJTI1N0NCcmFuZC1CcmFuZEV4YWN0X0RUJTI1N0NCX01fTWFrZW15dHJpcF9TZWFyY2hfRXhhY3QlMjU3Q0JyYW5kX1RvcF81X0V4YWN0JTI1N0NSU0ElMjU3QyUyNTI2c19rd2NpZCUyNTNEQUwhMTYzMSEzISFlISFvISFmbGlnaHQlMjUyNTIwYm9va2luZyUyNTI2ZWZfaWQlMjUzRCUyNTNBRyUyNTNBcyUyNm1zY2xraWQlM2RhNGMxOTE1YWU1M2YxNTFiMmQwMGY2ZmU0OWUxM2ZiNg%26rlid%3da4c1915ae53f151b2d00f6fe49e13fb6/RK=2/RS=KVTzjMeYkHzmsiSUdobXQYr0TBE-;_ylt=AwrKHFzdrKRn8AIA.IC7HAx.;_ylu=Y29sbwNzZzMEcG9zAzEEdnRpZAMEc2VjA292LXRvcA--;_ylc=X3IDMgRydAMw?IG=0aca1c5c1c6141ceb7013d4f1dc58a67");
		action = new Actions(driver);
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		

		}
	@Test
	public void WebdriverMethods() throws InterruptedException {
		String el = driver.findElement(By.xpath("//h5")).getText();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		//switchto
		//window handle needs for swithcong
		System.out.println(driver.getWindowHandles());
		Assert.assertEquals(driver.getTitle(),"OrangeHRM","kya haal hai");
		
	}
	@Test(priority =2,groups= {"sanity"})
	public void takeScreenShot() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='username']"))).sendKeys("Admin");
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']"))).sendKeys("admin123");
		
		//Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//input[@name='password']"))).click().sendKeys("admin123");
		action.moveToElement(driver.findElement(By.xpath("//button[contains(@type,'submit')]"))).click().perform();
		//driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
		wait.until(ExpectedConditions.urlContains("dashboard"));
		//driver.navigate().back();
		//driver.navigate().forward();
		//driver.navigate().refresh();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File filetemp = ts.getScreenshotAs(OutputType.FILE);
		File src = new File(System.getProperty("user.dir")+"\\ScreenShots\\full.png");
		Files.copy(filetemp, src);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				File file = driver.findElement(By.className("oxd-layout-context")).getScreenshotAs(OutputType.FILE);
				File curr = new File(System.getProperty("user.dir")+"\\ScreenShots\\element.png");
				Files.copy(file, curr);
		//js.executeScript("location.reload()");
		//js.executeScript("window.history.go(-1)");  // Back
		//js.executeScript("window.history.go(1)"); 
		
	}
	@Test
	public void alert() throws AWTException {
		action.moveToElement(driver.findElement(By.id("alert1"))).click().perform();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1000));
		//wait.until(ExpectedConditions.alertIsPresent());
		Robot robot = new Robot();
		//robot.mouseMove(50, 3000);
		
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
	}
	@Test
	public void dropDown() {
		//we can use select class other wiser will just use loop
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3000));
		WebElement ele = driver.findElement(By.cssSelector("span[class=\"commonModal__close\"]"));
		driver.findElement(By.cssSelector("div[aria-haspopup=listbox] input[type='text']")).sendKeys("Delhi");
		

		wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
		//driver.switchTo().alert().dismiss();
		List<WebElement> el = driver.findElements(By.xpath("//ul[@role='listbox']/li//span/span"));
		for(WebElement e : el) {
			if (e.getText().equals("Hindon Airport")) {
				e.click();
				break;
			}
		}
	}
	@Test(groups= {"somke"})
	@Parameters({"username","password"})
	public void handleAuth(String name,String pass) {
		
		
		
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
