package day2;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class Test_PutMethod {
	
	// https://reqres.in/api/users/765
	
	@Test
	public void test04()
	{
		// created json body
		JSONObject js = new JSONObject();
		js.put("name", "Neealm");
		js.put("job", "Home maker");
		
		baseURI = "https://reqres.in/api/users/765";
		
		ValidatableResponse response = given()
				.header("x-api-key","reqres-free-v1").contentType(ContentType.JSON)
		.body(js.toJSONString())
		.when().put()
		.then().statusCode(200).log().all();
		
		System.out.println("Response :" +response.extract().asPrettyString());
		System.out.println("status code :"+response.extract().statusCode());
		
		
	}

}
