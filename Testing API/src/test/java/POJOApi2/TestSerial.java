package POJOApi2;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;

public class TestSerial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddLocation bd = new AddLocation();
		bd.setAccuracy(50);
		bd.setAddress("29, side layout898375, cohen 09");
		bd.setName("Frontline house12");
		bd.setPhone_number("983739815");
		bd.setWebsite("http://google.com");
		bd.setLanguage("French-IN");
		Location l = new Location();
		
		bd.setLocation(l);
		l.setLat(-38.383494);
		l.setLng(33.427362);
		String [] a = {"shoe park","shop"};
		bd.setTypes(a);
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123")
		.body(bd)
		.when().post("/maps/api/place/add/json")
		.then().log().all().extract().response().asString();
		System.out.println(response);
	}

}
