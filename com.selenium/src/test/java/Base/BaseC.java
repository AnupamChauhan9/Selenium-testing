package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import qa.utilties.utility;

public class BaseC {

	public Properties prop;
	public Properties testpro;
	public Logger logger = LogManager.getLogger(this.getClass());
	public  BaseC()  {
	    
	    logger.info("This is an INFO message.");
        System.setProperty("log4j.configurationFile", "src/test/resources/log4j2.xml");
        System.setProperty("log4j.debug", "true");


		System.out.println(System.getProperty("log4j.configurationFile"));


		testpro = new Properties();
		 prop= new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\qa\\config\\config.properties");
		File testpropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\cqa\\testdata\\testdata.properties");

		try {
			FileInputStream fis = new FileInputStream(propFile);
			FileInputStream tst = new FileInputStream(testpropFile);
			testpro.load(tst);
			prop.load(fis);
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		
	}
	WebDriver driv;
	public WebDriver  seleniumGrid(String name) throws URISyntaxException, MalformedURLException {
	
        URI hubUri = new URI("http://172.31.112.1:4444");
        URL url = hubUri.toURL();
				 if(name.equals("chrome")) {
					 ChromeOptions option = new ChromeOptions();

					 driv = new RemoteWebDriver(url,option);
				 }
					  
					  
				
				 else if(name.equals("edge")) {
					 EdgeOptions options = new EdgeOptions();
		                driv = new RemoteWebDriver(url, options);
		                
				 }
				 driv.manage().timeouts().implicitlyWait(Duration.ofSeconds(utility.impli_wait_time));
					driv.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(utility.page_load));

					driv.get(prop.getProperty("url"));
					driv.manage().window().maximize();
			
		return driv;
	}
	public WebDriver initBrowser(String name ) {
			if (name.equalsIgnoreCase("Chrome")) {
				ChromeOptions option = new ChromeOptions();
				//option.addArguments("--headless");
				driv = new ChromeDriver(option);
			}
			else if(name.equalsIgnoreCase("firefox")) {
				driv = new FirefoxDriver();
			}
			else if(name.equalsIgnoreCase("edge")) {
				driv = new EdgeDriver();
			}
		    
			driv.manage().timeouts().implicitlyWait(Duration.ofSeconds(utility.impli_wait_time));
			driv.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driv.manage().window().maximize();
			driv.get(prop.getProperty("url"));
			driv.manage().timeouts();
			
			
			return driv;
			
		
	}

}
