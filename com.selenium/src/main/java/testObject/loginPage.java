package testObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
		WebDriver driver;
		//object
		@FindBy(linkText= "Login")
		WebElement Login;
		@FindBy(id = "input-email")
		WebElement email;
		@FindBy(id = "input-password")
		WebElement password;
		@FindBy(xpath = "//input[@value = 'Login']")
		WebElement loginButton;
	public loginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//Action
	public void clickOnLoginDrop() {
		Login.click();
	}
	public void enterEmail(String emailid) {
		email.sendKeys(emailid);
	}
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	public void login() {
		loginButton.click();
	}

	
}

