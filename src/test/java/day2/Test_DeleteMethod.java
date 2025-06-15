package day2;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class Test_DeleteMethod {
	
	
	@Test
	public void test05()
	{

		baseURI = "https://reqres.in/api/users/765";
		
		ValidatableResponse response = given()
				.header("x-api-key","reqres-free-v1")
		.when().delete()
		.then().statusCode(204).log().all();
		
		System.out.println("Response :" +response.extract().asPrettyString());
		System.out.println("status code :"+response.extract().statusCode());
		
		
	}

}
