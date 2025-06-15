package day11_createOwnApi;


import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class OwnAPITesting {
	
	@BeforeClass
	public void defaultSetup() {
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("http://localhost:3000");
		reqSpec.basePath("/users");
		
		RestAssured.requestSpecification = reqSpec;
	}
	
	@Test
	public void readUserData() {
		
		Response response = RestAssured.get();
		
		System.out.println("response is :"+response.asString());
		
		Assert.assertEquals(response.statusCode(), 200,"Status code is not matched");
		
		Assert.assertEquals(response.asString().contains("Ashish"), true,"Ashish is not present in the response");
		
		ResponseBody resBody = response.getBody();
		
		
		JsonPath jsonPathView = response.jsonPath();
	
		
		System.out.println("Names of user 1 :"+jsonPathView.getString("[0].name"));
	}
	
	@Test
	public void createUser() {
		JSONObject payload = new JSONObject();
		payload.put("name","Prateek");
		payload.put("age", 30);
		
		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON);
		Response response = request.body(payload.toJSONString()).post();
		
		System.out.println("New response is :"+response.asString());
		
		Assert.assertEquals(response.statusCode(), 201,"Status code is not matched");
		
		Assert.assertEquals(response.asString().contains("Prateek"), true,"Prateek is not present in the response");

	}
	
	@Test
	public void updateUser() {
		JSONObject payload = new JSONObject();
		payload.put("name","Praveen");
		payload.put("age", 29);
		
		Response response = RestAssured.given().contentType(ContentType.JSON).body(payload.toJSONString()).put("/3");
		
		System.out.println("Update response is :"+response.asString());
		
		Assert.assertEquals(response.statusCode(), 200,"Status code is not matched");
		
		Assert.assertEquals(response.asString().contains("Praveen"), true,"Praveen is not present in the response");
	}
	
	@Test
	public void deleteUser() {
		
		Response response = RestAssured.given().delete("/6");
		System.out.println("deleted response is :"+response.asString());
		
		Assert.assertEquals(response.statusCode(), 200,"Status code is not matched");
	}

}
