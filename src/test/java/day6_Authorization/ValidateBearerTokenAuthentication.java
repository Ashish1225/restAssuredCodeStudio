package day6_Authorization;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateBearerTokenAuthentication {
	
	// Bearer token authentication
	
	// https://gorest.co.in/public/v2/users
	
	// token ==   6444d43cc05948d5304ae7bae1bfac5343d93a2a18de19f4b2ab49ee36918915
	
	// Bearer 6444d43cc05948d5304ae7bae1bfac5343d93a2a18de19f4b2ab49ee36918915
	
	@Test
	public void bearerAuth()
	{
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://gorest.co.in");
		reqSpec.basePath("/public/v2/users");
		
		JSONObject payload = new JSONObject();
		payload.put("name", "Ashish");
		payload.put("gender", "Male");
		payload.put("email", "ask12@gmail.com");
		payload.put("status", "Active");
		
	
		String bearerToken = "Bearer 6444d43cc05948d5304ae7bae1bfac5343d93a2a18de19f4b2ab49ee36918915";
		
		reqSpec.header("Authorization",bearerToken).contentType(ContentType.JSON).body(payload.toJSONString());
		
		Response response = reqSpec.post();
		System.out.println("Response is :"+response.getBody().asPrettyString());
		
		System.out.println("Status line is :"+response.statusLine());
		
		Assert.assertEquals(response.getStatusCode(), 201,"Status code is not matched with response..");
		
		
	}

}
