package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Assertions {
	WebDriver driver;
	@BeforeTest
	@Parameters("url")

	public void setUp(String URL) {
    driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get(URL);
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
		
	}
	@Test(priority= 1,groups = {"regression"})
	public void loginWithInvalid() {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("anupam983734@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("12345",Keys.ENTER);
		String a = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		Assert.assertEquals(a, "Warning: No match for E-Mail Address and/or Password.");
	}
	@Test(priority=2,groups = {"smoke","sanity"})
	public void loginWithValid() {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("anupam983734@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Anupam@1234",Keys.ENTER);
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	}
	public void sampleMethod() {
		
		SoftAssert sftAssert = new SoftAssert();
		String a = driver.getTitle();
		String expected = "Your Stre";
		sftAssert.assertEquals(a, expected);
		driver.findElement(By.name("search")).sendKeys("HP",Keys.ENTER);
		sftAssert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
		driver.quit();
		sftAssert.assertAll();

		
	}
	

}
