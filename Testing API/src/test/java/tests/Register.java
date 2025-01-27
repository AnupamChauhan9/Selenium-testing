package tests;
import io.cucumber.java.en.*;

public class Register {
	@Given("user navigate to  user creation page")
	public void user_navigate_to_user_creation_page() {
	    System.out.println("1");
	}

	@When("user enter first name  {string}")
	public void user_enter_first_name(String string) {
		    System.out.println("1");

	}

	@And("user enter last name {string}")
	public void user_enter_last_name(String string) {
	    System.out.println("1");

	}

	@When("Enter email {string}")
	public void enter_email(String string) {
	    System.out.println("1");
	}


	@And("enter password {string} into password field")
	public void enter_password_into_password_field(String string) {
		    System.out.println("1");

	}

	@And("user enter confirm password {string}")
	public void user_enter_confirm_password(String string) {
	    System.out.println("1");

	}

	@And("user select  the check box")
	public void user_select_the_check_box() {
	    System.out.println("1");

	}

	@And("Click on Continue button")
	public void click_on_continue_button() {
	    System.out.println("1");

	}

	@Then("user created sucerssfully")
	public void user_created_sucerssfully() {
	    System.out.println("1");

	}

}
