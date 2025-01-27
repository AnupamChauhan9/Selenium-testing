package API;

import io.restassured.RestAssured;
import io.restassured.*;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
// we will use path param in this 
public class JiraApi {
	public static void main(String[] args)  {
		RestAssured.baseURI = "https://backtohellin.atlassian.net";
		String response = given().header("Content-Type","application/json").log().all()
		.header("Authorization","Basic YmFja3RvaGVsbGluQGdtYWlsLmNvbTpBVEFUVDN4RmZHRjBiUFZwZnlIOVRBdFBHVWpWczVfMS1xN20zMEVRWEpXWU1sMFQxd0M2cUppUnN1aEFrYnkxS1Q3MnN2OElTR0NUeDNocFR1bW5YS0EwZjExSVJHc0g5VktvOVhjRlpybmNyVVZLVUh2VklnbFZScnVhMkFpc3BOQm01aWExOE5ncEJKWDMxVURYdm5JV3RMeFNYOXJPZUhJaUJoVU9ld0pmdHZiR1lYUTNucWs9M0I1NjcwNkM=")
		.body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "       \"project\":\r\n"
				+ "       {\r\n"
				+ "          \"key\": \"SCRUM\"\r\n"
				+ "       },\r\n"
				+ "       \"summary\": \"view 4 is not working\",\r\n"
				+ "    \r\n"
				+ "       \"issuetype\": {\r\n"
				+ "          \"name\": \"Bug\"\r\n"
				+ "       }\r\n"
				+ "   }\r\n"
				+ "}")
		.when().post("/rest/api/3/issue").then()
		.log().all().assertThat().statusCode(201).extract().response().asString();
		JsonPath js = new JsonPath(response);
		String id = js.get("id");
		System.out.println(id);
		String res = given().pathParam("key", id)
		.header("Authorization","Basic YmFja3RvaGVsbGluQGdtYWlsLmNvbTpBVEFUVDN4RmZHRjBiUFZwZnlIOVRBdFBHVWpWczVfMS1xN20zMEVRWEpXWU1sMFQxd0M2cUppUnN1aEFrYnkxS1Q3MnN2OElTR0NUeDNocFR1bW5YS0EwZjExSVJHc0g5VktvOVhjRlpybmNyVVZLVUh2VklnbFZScnVhMkFpc3BOQm01aWExOE5ncEJKWDMxVURYdm5JV3RMeFNYOXJPZUhJaUJoVU9ld0pmdHZiR1lYUTNucWs9M0I1NjcwNkM=")
		.header("X-Atlassian-Token","no_check")
		.multiPart("file",new File("C:\\Users\\anupa\\OneDrive\\Desktop\\te.jpg"))
		.when().post("/rest/api/3/issue/{key}/attachments")
		.then().log().all().assertThat().extract().response().asString();
		System.out.println("123");
	}

}
