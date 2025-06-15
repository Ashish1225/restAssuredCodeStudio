package day2;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class Test_PatchMethod {
	
	@Test
	public void test05()
	{
		// created json body
		JSONObject js = new JSONObject();
		js.put("name", "neelam");
		
		js.put("job", "Better-Half");
		
		baseURI = "https://reqres.in/api/users/765";
		
		ValidatableResponse response = given()
				.header("x-api-key","reqres-free-v1").contentType(ContentType.JSON)
		.body(js.toJSONString())
		.when().patch()
		.then().statusCode(200).log().all();
		
		System.out.println("Response :" +response.extract().asPrettyString());
		System.out.println("status code :"+response.extract().statusCode());
		
		
	}

}
