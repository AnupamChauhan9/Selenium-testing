package Ecommmerce;
import io.restassured.builder.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.specification.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;

import java.io.File;

public class TestEcommerce {
	public static void main(String[] args) {
		RestAssured.baseURI ="https://rahulshettyacademy.com";
		Login login= new Login();
		login.setUserEmail("anupam1234@gmail.com");
		login.setUserPassword("Anupam123");
		LoginResponse responseLogin = given().log().all().header("Content-Type","application/json").body(login).when().post("/api/ecom/auth/login").then().log().all().extract().response().as(LoginResponse.class);
		System.out.println();
		
		RequestSpecification rsp_Spec = new RequestSpecBuilder().addHeader("Authorization",responseLogin.getToken()).build();
		RequestSpecification req = given().log().all().spec(rsp_Spec).multiPart("productName","qwerty")
		.multiPart("productAddedBy",responseLogin.getUserId())
		.multiPart("productCategory","fashion")
		.multiPart("productSubCategory","shirts")
		.multiPart("productPrice","11500")
		.multiPart("productDescription","Addias Originals12")
		.multiPart("productImage",new File("C:\\Users\\anupa\\OneDrive\\Pictures\\Screenshots\\pic.png"))
		.multiPart("productFor","women");
		String  res =  req.when().post("/api/ecom/product/add-product")
		.then().log().all().assertThat().statusCode(201).body("message", equalTo("Product Added Successfully")).extract().response().asString();
		JsonPath js = new JsonPath(res);
		String msg = js.getString("message");
		System.out.println(msg);
		given().log().all().spec(rsp_Spec).pathParam("key",js.getString("productId"))
		.when().delete("/api/ecom/product/delete-product/{key}").then().log().all()
		.assertThat().statusCode(200).body("message", equalTo("Product Deleted Successfully"));
		 
		
		
		
	}

}
