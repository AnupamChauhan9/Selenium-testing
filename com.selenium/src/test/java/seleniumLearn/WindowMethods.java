package seleniumLearn;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
public class WindowMethods {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.manage().window().maximize();
		driver.navigate().to("https://omayo.blogspot.com/");
		WebElement el =driver.findElement(By.id("multiselect1"));
		Select select = new Select(el);
		//System.out.println(select.getAllSelectedOptions());
//		select.selectByIndex(3);
//		select.selectByValue("Swift");
//		List<WebElement> el2 =driver.findElements(By.xpath("//select[@id='multiselect1']/option"));
//		//List<WebElement> options = 
//		for(WebElement e :el2) {
//			e.click();
//		}
		List<WebElement> all = select.getOptions();
		for(int i =0;i<all.size();i++) {
			select.selectByIndex(i);
		}
		
		
		
		// TODO Auto-generated method stub

	}

}
