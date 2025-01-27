package POJOAPI_1;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class TestDeserial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String response = given().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.formParam("grant_type", "client_credentials")
				.formParam("scope", "trust")
				.when().log().all().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token")
				.asString();
				//directly store response without using then
				System.out.println(response);
				JsonPath js = new JsonPath(response);
				String accessToken = js.getString("access_token");
				GetCourse gc = given().queryParam("access_token", accessToken)
				.when().log().all()
				.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
				.then().log().all().extract().response().as(GetCourse.class);
				System.out.println(gc.getInstructor());
				System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
				//total sum of prices
				int sum =0;
				for (int i = 0;i<gc.getCourses().getWebAutomation().size();i++) {
					String a = gc.getCourses().getWebAutomation().get(i).getPrice();
					System.out.println(a);
					sum +=Integer.valueOf(a);
				}
				System.out.println(sum);
			}
	

}
