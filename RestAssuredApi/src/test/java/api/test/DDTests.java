package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import api.endpoints.Endpoints;
import api.payload.User;
import api.utilities.DataProvide;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DDTests {
	//dataProviderClass =class_name.class is need to clarify when we Data provider from another lass
	@Test(priority = 1,dataProvider="Data",dataProviderClass=DataProvide.class)
	public void ddTest(String userId,String userName,String fName,String lName
			,String email,String phone,String pswrd ) {
		User user = new User();
		user.setId(Integer.parseInt(userId));
		user.setFirstName(fName);
		user.setLastName(lName);
		user.setUsername(userName);
		user.setPassword(pswrd);
		user.setPhone(phone);
		user.setEmail(email);
		Response response = Endpoints.createUser(user);
		String payload = response.asString();
		Assert.assertEquals(response.getStatusCode(), 200);
		JsonPath js = new JsonPath(payload);
	   int  message = js.getInt("message");
		Assert.assertEquals(message,user.getId());
	
		
	}

}
