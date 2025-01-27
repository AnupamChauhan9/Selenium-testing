package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DropDownDynamicAuto {
	public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
	driver.findElement(By.id("autosuggest")).sendKeys("ind");
	Thread.sleep(2000);
	List<WebElement> options = driver.findElements(By.cssSelector("ul .ui-menu-item a"));
	for (WebElement option:options) {
		if (option.getText().equalsIgnoreCase("india")) {
			option.click();
			System.out.println(option.getText());
			driver.quit();
			break;
		}
	}


}
}
