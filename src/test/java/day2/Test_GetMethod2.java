package day2;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


// import static

public class Test_GetMethod2 {
	
	//URL =  https://reqres.in/api/users?page=2
	
	@Test
	public void test01()
	{
		RequestSpecification request = given();
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
		baseURI = "https://reqres.in/api/users";
		given().queryParam("page", "2").header("x-api-key","reqres-free-v1")
		.when().get()
		.then().statusCode(200);
		
	}

}
