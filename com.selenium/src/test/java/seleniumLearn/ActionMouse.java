package seleniumLearn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Base.BaseC;
import testObject.ActionObject;

public class ActionMouse extends BaseC {
	
	WebDriver driver;
	public ActionMouse() {
		super();
	}
	@Test
	public void mouse() {
		driver = initBrowser("Chrome");
		ActionObject el = new ActionObject(driver);
		Actions actions = new Actions(driver);
		
		actions.moveToElement(el.Blog).perform();
		
	}

}
