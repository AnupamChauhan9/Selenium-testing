package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.Endpoints;
import api.payload.User;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

public class UserTest {
	
	Faker faker;
	User user;
	@BeforeClass
	public void setUpDat() {
		faker = new Faker();
		user = new User();
		user.setId(faker.idNumber().hashCode());
		user.setUsername(faker.name().username());
		user.setFirstName(faker.name().firstName());
		user.setLastName(faker.name().lastName());
		user.setEmail(faker.internet().emailAddress());
		user.setPhone(faker.phoneNumber().phoneNumber());
		user.setPassword(faker.internet().password(5, 10));
	}
	@Test(priority =1)
	public void createUser() {
		Response response = Endpoints.createUser(user);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		 //a =response.getBody();
		
		
		
	}
	@Test(priority =2)
	public void getUser() {
		Response response = Endpoints.reaadUser(user.getUsername()).then().log().all().extract().response();
		Assert.assertEquals(response.getStatusCode(), 200);

	}

}
