package API;

import io.restassured.builder.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.*;
import static io.restassured.RestAssured.*;

public class SpecBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// (optimization of code)we can make reusable code static and save it yo one place by using request spec builder and response spec builder
		//note:-
		// requestspec method start with set and response start with expect
		//reustspec object save in requestSpecification refrence and response in respnsespeci....\
		//build() methos is mandatory to work 
		//in this we try diifernt apptrach and save request sperate an extract resonse sperate and save it into Response class refrence.
		RequestSpecification req= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
	.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
//		Response res = given().log().all().spec(req).body("{\r\n"
//				+ "  \"location\": {\r\n"
//				+ "    \"lat\": -38.383494,\r\n"
//				+ "    \"lng\": 33.427362\r\n"
//				+ "  },\r\n"
//				+ "  \"accuracy\": 50,\r\n"
//				+ "  \"name\": \"Frontline house\",\r\n"
//				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
//				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
//				+ "  \"types\": [\r\n"
//				+ "    \"shoe park\",\r\n"
//				+ "    \"shop\"\r\n"
//				+ "  ],\r\n"
//				+ "  \"website\": \"http://google.com\",\r\n"
//				+ "  \"language\": \"French-IN\"\r\n"
//				+ "}\r\n"
//				+ "")
//		.when().post(" /maps/api/place/add/json")
//		.then().log().all().assertThat().statusCode(200).extract().response();
//		String str = res.asString();
//		System.out.println(str);
		//another way split request and response
		RequestSpecification res = given().log().all().spec(req).body("{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "");
		ResponseSpecification resp = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		Response response = res.when().post("/maps/api/place/add/json");
				//.then().log().all().spec(resp).extract().response();
		//System.out.println(response);
		String str = response.asString();
		//System.out.println(str);
	}

}
