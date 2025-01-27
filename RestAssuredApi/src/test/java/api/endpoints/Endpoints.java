package api.endpoints;
import static io.restassured.RestAssured.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Endpoints {
	//UserEndpoints.java 
	//Created to perform Create, Read, Update, Delete requests to the User services 
	public static Response  createUser(User payload) {
		Response response = given().log().all().contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when().post(Routes.post_url);
		return response;
	}
	public static Response reaadUser(String userName) {
		Response response = given().log().all()
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		.when().get(Routes.get_url);
		return response;
	}
	public static Response  updateUser(User payload,String userName) {
		Response response = given().contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		.body(payload)
		.when().post(Routes.post_url);
		return response;
	}
	public static Response  deleteUser(String userName) {
		Response response = given().contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		.when().post(Routes.post_url);
		return response;
	}
	

}
