package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameter {
	@Parameters("url")
	@Test(groups = {"anupam1"})
	public void testParamter(String URL) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();

	
	driver.get(URL);
	
	driver.findElement(By.xpath("//span[text()='My Account']")).click();
	driver.findElement(By.linkText("Login")).click();
	driver.findElement(By.id("input-email")).sendKeys("anupam983734@gmail.com");
	driver.findElement(By.id("input-password")).sendKeys("Anupam@1234",Keys.ENTER);
	Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

}
}
