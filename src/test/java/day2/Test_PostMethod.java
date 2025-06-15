package day2;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class Test_PostMethod {
	
	// https://reqres.in/api/users
	

	
	
	@Test
	public void test03() {
		
		// creating json body
		
		JSONObject js = new JSONObject();
		js.put("name", "Ashish");
		js.put("Job", "QA");
		
		baseURI = "https://reqres.in/api/users";
		
		ValidatableResponse response = given()
		.header("x-api-key","reqres-free-v1").contentType(ContentType.JSON)
		.body(js.toJSONString())
		.when().post()
		.then().statusCode(201).log().all();
		
		System.out.println("Response :" +response.extract().asPrettyString());
		System.out.println("status code :"+response.extract().statusCode());
		
		//   "id": "765"
	}

}
