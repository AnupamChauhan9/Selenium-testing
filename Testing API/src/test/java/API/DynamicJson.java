package API;
import io.restassured.*;
import io.restassured.path.json.JsonPath;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import io.restassured.RestAssured;

public class DynamicJson {
	@Test(dataProvider= "add book")
	public void dynamic(String name ,String id) {
		RestAssured.baseURI = "http://216.10.245.166";
		String res = given().log().all().body(Payload.addBook(name,id))
		.when().post("/Library/Addbook.php")
		.then().log().all().assertThat().body("Msg", equalTo("successfully added")).statusCode(200)
		.extract().response().asString();
		JsonPath js = new JsonPath(res);
		String a = js.get("ID");
		given().log().all().body("{\r\n"
				+ "    \"ID\":\""+a+"\"\r\n"
				+ "}")
		.when().post("/Library/DeleteBook.php")
		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("book is successfully deleted"));
		
		}
	
	@DataProvider(name = "add book")
	public  Object[][] data() {
		return new Object[][] {{"chem","2345"},{"checm","3454"},{"anupam","546"}};
	}
	

}
