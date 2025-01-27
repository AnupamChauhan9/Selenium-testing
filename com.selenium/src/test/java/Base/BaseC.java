package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import qa.utilties.utility;

public class BaseC {
	public Properties prop;
	public Properties testpro;
	public  BaseC()  {
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
	public WebDriver initBrowser(String name ) {
			if (name.equalsIgnoreCase("Chrome")) {
				driv = new ChromeDriver();
			}
			else if(name.equalsIgnoreCase("firefox")) {
				driv = new FirefoxDriver();
			}
			else if(name.equalsIgnoreCase("edge")) {
				driv = new EdgeDriver();
			}
		    
			driv.manage().timeouts().implicitlyWait(Duration.ofSeconds(utility.impli_wait_time));
			driv.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(utility.page_load));
			driv.get(prop.getProperty("url"));
			driv.manage().window().maximize();
			return driv;
		
	}

}
