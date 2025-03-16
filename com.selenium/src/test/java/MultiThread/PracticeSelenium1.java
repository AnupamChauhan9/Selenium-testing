package MultiThread;

import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.BaseC;
import qa.utilties.utility;
import testObject.loginPage;
public class PracticeSelenium1 {
	WebDriver driver; 
	//@BeforeTest
	public void setUp() {

		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");

	}
	
	// image link do not have linktest like we have in achoer tesxt 
	// we use linkTExt or partialLinktext
	@Test
	public void handlingCheckBox (){
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
		List<WebElement> lstDrop = driver.findElements(By.xpath("(//div[@class= 'form-group'])[4]/div/input"));
		for (WebElement el:lstDrop) {
			el.click();
		}
	}
	@Test
	public void handleAlerts() {
		// for handling alert we have alert class 
		//✔ Simple Alerts – OK button only.

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
		Alert alert  = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.accept();
		//same with the conformation and prompt alert and we can also pass the text into the alert with th\
		// help of sendKeys
	}
	public void frameAndIframesAndNestedFrames() {
		//frames is older model in which they divide page into sections
		// but in case of iframes we can create 
		//Used to embed another independent webpage inside the current page.
		//we need to switch from it to the frames to perfoem anything 
		// switchTO.frame(name,id,index,webelement ),parentFrame(),defaultContent(),explicitly wait we can do as well
		
	}
	@Test
	public void dropDown() {
		//with select class standard
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement el = driver.findElement(By.cssSelector("#colors"));
		Select options = new Select(el);
		List<WebElement> total = options.getOptions();
		for(int i =0;i<total.size();i++) {
			options.selectByIndex(i);
		}
		//hidden dropdown in which list of dropsown value are not visible in 
		//html// dynmic dropdown/Autosuggestuon
		//first we will reomve the blurr property from event listener
		
		
		 
		
	}
	@Test
	public void dynamicDrop() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//input[contains(@name,'user')]")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[contains(@name,'pass')]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[contains(@type,'sub')]")).click();
		driver.findElement(By.xpath("(//a[@class = 'oxd-main-menu-item'])[2]")).click();
		driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[3]")).click();
		driver.findElement(By.xpath("//div/span[contains(text(),'Account')]")).click();
		
		
		
	}
	@Test
	public void staticTable() {
		driver.get("https://testautomationpractice.blogspot.com/");

		List<WebElement> tR= driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
		int rowSize= tR.size();
		List<WebElement> tC= driver.findElements(By.xpath("//table[@name='BookTable']//tr/td"));
		
		int colSize= tC.size();
		for(int i= 1; i < rowSize;i++) {
			for(int j = 1;j<colSize;j++) {
				if(i ==4 &&j ==2) {
					System.out.println(driver.findElement(By.xpath("//table[@name='BookTable']//tr[4]/td[2]")).getText());
				}
			}
			
		}
		driver.quit();


		
		
	}
	@Test
	public void dynamic() {
		String s  = "Showing 1951 to 1958 of 1958 (296 Pages)";
		System.out.println(s.substring(30,33));
		System.out.println(s.lastIndexOf(" Pages"));
		System.out.println(s.lastIndexOf("(")+1);
		
		System.out.println(s.substring(s.lastIndexOf("("+2,s.lastIndexOf(" Pages"))));
		
	}
	@Test
	public void actions() throws InterruptedException {
		// Action is inteface that requires .Build (Action is an interface representing a single compiled action sequence.
//)But Actions is class 
		//to perform mouse and keyboard
		//mouse hover ,right click (content click),click and hold left(clickandHold),relesae 
		//dragandDrop(ele ,el2).perform
		//.build if we are using mutilpe scenarios
		//sendKeys(key.arrow)
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.id("alertBtn"))).clickAndHold().perform();
		actions.release().perform();
		driver.switchTo().alert().accept();
		Action dragAndHold = actions.clickAndHold(driver.findElement(By.id("draggable"))).moveToElement(driver.findElement(By.id("droppable"))).build();
		dragAndHold.perform();
		Thread.sleep(1000);
		actions.release().perform();
		//passing the key with Keys.Enter shit with lower
		actions.moveToElement(driver.findElement(By.id("name"))).click().keyDown(Keys.SHIFT).sendKeys("anupam").keyUp(Keys.SHIFT).perform();
		
	}
	public void Js() {
		
	}
	@Test
	public void uplaodfiles() {
		
		driver.findElement(By.id("singleFileInput")).sendKeys("C:\\Users\\anupa\\OneDrive\\Desktop\\ancestortag name.txt");
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("(//form//button[@type = 'submit'])[1]"))).click().perform();
	}
	@Test
	public void scrrenshot() throws IOException {
		
		File ts = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String Path = System.getProperty("user.dir")+"\\ScreenShots\\"+"test.png";
		System.out.println(System.getProperty("user.dir"));
		File str = new File(Path);
        FileUtils.copyFile(ts, str);
        //full csreen shot can only be supported by firefox
        WebElement el = driver.findElement(By.cssSelector("#HTML1"));
        File f = el.getScreenshotAs(OutputType.FILE);
        File dsF = new File(System.getProperty("user.dir")+"\\ScreenShots\\Section.png");
        FileUtils.copyFile(f, dsF);
        

	}
	@Test
	public void ChromeOptionFunctiosn() {
		ChromeOptions options = new ChromeOptions();
		//headless
		options.addArguments("--headless");
		//ssl certificate acceptance
		options.setAcceptInsecureCerts(true);
		//incognito 
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		driver.get("https://testautomationpractice.blogspot.com/");
		System.out.println(driver.getTitle());
		driver.quit();
		
		
	}
	public void handleBrokenLink() {
		
	}
}
