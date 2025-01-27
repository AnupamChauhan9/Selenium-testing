package tests;
import io.cucumber.java.en.*;
import io.cucumber.java.en.When;

public class login {
	@Given("user navigate to login page")
	public void user_navigate_to_login_page() {
		System.out.println("succesws");
	}
	    

	@When("user enter email address {string}")
	public void user_enter_email_address(String string) {
		System.out.println("enter email"+string);
	    
	}

	@And("enter password {string}")
	public void enter_password(String string) {
		System.out.println("enter password"+string);

	}

	@And("Click on login button")
	public void click_on_login_button() {
		System.out.println("Click");

	}

	@Then("user should logged sucerssfully")
	public void user_should_logged_sucerssfully() {
		System.out.println("successfully login");

	    
	}

}
