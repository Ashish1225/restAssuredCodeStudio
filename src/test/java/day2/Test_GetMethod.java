package day2;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test_GetMethod {
	
	//URL =  https://reqres.in/api/users?page=2
	
	@Test
	public void test01()
	{
		RequestSpecification request = RestAssured.given();
		request.header("x-api-key","reqres-free-v1");
		Response response = request.get("https://reqres.in/api/users?page=2");
		System.out.println(response.asString());
		System.out.println("status code : "+response.getStatusCode());
		System.out.println(response.getBody().asString());
		System.out.println(response.getTime());
		System.out.println(response.header("Content-Type"));
		
		// validate status code - expected status code is 200
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(200, statusCode);
	}
	
	// using BDD style
	// given() , when() , then()
	
	@Test
	public void test02() {
		RestAssured.baseURI = "https://reqres.in/api/users";
		RestAssured.given().queryParam("page", "2").header("x-api-key","reqres-free-v1")
		.when().get()
		.then().statusCode(200);
		
	}

}
