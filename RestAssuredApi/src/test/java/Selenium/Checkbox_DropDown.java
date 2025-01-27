package Selenium;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class Checkbox_DropDown {
public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		List<WebElement> el = driver.findElements(By.cssSelector("input[class =form-check-input][type=checkbox]"));
		for(WebElement i:el) {
			i.click();
		}
}
}
