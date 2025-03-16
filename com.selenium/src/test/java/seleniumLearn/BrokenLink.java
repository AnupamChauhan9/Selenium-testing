package seleniumLearn;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
public class BrokenLink {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.get("http://www.deadlinkcity.com");
		List<WebElement> el = driver.findElements(By.xpath("//a"));
		System.out.println(el.size());
		String baseurl = driver.getCurrentUrl();
		for (WebElement e :el) {
			System.out.println("********************");
			String url =  e.getDomAttribute("href");
			if(url==null || url.isEmpty()) {
				System.out.println("wrong");
				continue;
			}
			
			try {
				URI uri = new URI(url);
				URL ur = uri.toURL();
				
				HttpURLConnection hub =(HttpURLConnection)(ur.openConnection());
				hub.connect();
				if(hub.getResponseCode()>=400) {
					System.out.println(url +"invalid url");
				}
			}
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						
			catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		// TODO Auto-generated method stub

	}

}
