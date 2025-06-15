package day9_AboutJSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSONArrayDemo {
	
	// Create JSON Array Using JSON Object and List
	
	// https://reqres.in/api/users
	
	@Test
	public void creatingUserUsingJSsonArray() {
		
		JSONObject user1 = new JSONObject();
		user1.put("firstname", "Ashish");
		user1.put("lastname", "rathour");
		user1.put("age", 30);
		user1.put("salary", 50000);
		
		JSONObject user2 = new JSONObject();
		user2.put("firstname", "Neelam");
		user2.put("lastname", "rathour");
		user2.put("age", 25);
		user2.put("salary", 50000);
		
		JSONObject user3 = new JSONObject();
		user3.put("firstname", "Mangal");
		user3.put("lastname", "Singh");
		user3.put("age", 30);
		user3.put("salary", 60000);
		
		// adding into jsonArray
		
		JSONArray payload = new JSONArray();
		payload.add(user1);
		payload.add(user2);
		payload.add(user3);
		
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://reqres.in");
		reqSpec.basePath("/api/users");
		reqSpec.header("x-api-key","reqres-free-v1").contentType(ContentType.JSON);
		Response response = reqSpec.body(payload).post();
		
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 201,"Status code is not matched ..");
		
		
		
	}

}
