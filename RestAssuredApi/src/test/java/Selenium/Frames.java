package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {
	public static void main(String[] args)  {
		 
		WebDriver driver=new ChromeDriver();
		//in frame method we can directlty pass id and name as string and indexing we can also do
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='frame_1.html']")));
		driver.findElement(By.cssSelector("input[name='mytext1']")).sendKeys("annupam");
	}
	
}
