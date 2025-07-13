package day5;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class QueryParameterDemo {
	
	// https://reqres.in/api/users?page=2
	
	@Test
	public void filterData()
	{
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://reqres.in");
		reqSpec.basePath("/api/users");
		reqSpec.queryParam("page", 2);
		
		Response response = reqSpec.get();
		String responseBody = response.getBody().asString();
		
		System.out.println("Response body :"+responseBody);
		
		JsonPath resJsonPath = response.getBody().jsonPath();
		Object firstEmployeeData = resJsonPath.get("data[0]");
		
		System.out.println(firstEmployeeData);
		
		
	}

}
