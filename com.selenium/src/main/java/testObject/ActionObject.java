package testObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActionObject {
	WebDriver driver;
	@FindBy(id = "blogsmenu")
	public WebElement Blog;
	@FindBy(xpath = "//span[text()='SeleniumByArun']")
	public WebElement option2;
	public ActionObject(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
		}
}
