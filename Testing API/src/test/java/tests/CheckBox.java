package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBox {
	@Test
	public void test() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
		//Assert.assertTrue(driver.findElement(By.cssSelector("#discount-checkbox div input")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("#discount-checkbox div input")).isSelected());
		driver.findElement(By.cssSelector("#discount-checkbox div input")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("#discount-checkbox div input")).isSelected());

		System.out.println(driver.findElement(By.cssSelector("#discount-checkbox div input")).isSelected());
		System.out.println(driver.findElements(By.cssSelector("#discount-checkbox div input")).size());
	}
}

