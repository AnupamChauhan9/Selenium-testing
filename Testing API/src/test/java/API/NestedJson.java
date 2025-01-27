package API;

//import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;
//need to create a program in which total price of each item

public class NestedJson {
	public static void main(String[] args) {
		JsonPath js = new JsonPath(Payload.course());
		int a = js.getInt("courses.size()");
		System.out.println(a);
		int total = js.getInt("dashboard.purchaseAmount");
		//System.out.println(total);
		//to print all courses title 
		System.out.println(js.getString("courses.title"));
		//String b = js.get("courses[0].title");

		//System.out.println(b);
		int sum = 0;
		for(int i=0;i<a;i++) {
			int price = js.getInt("courses["+i+"].price");
			int copy = js.getInt("courses["+i+"].copies");
			sum = sum +(price * copy);
		}	
		
		Assert.assertEquals(sum , total);
		
	}

}
