package day8_retreiveRequestSpecificationDetails;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SendXMLDataAsPayload {
	
	// https://petstore3.swagger.io/api/v3/pet
	
	@Test
	public void addPetJsonPayload() {
		
		String payload = "{\r\n"
				+ "  \"id\": 10,\r\n"
				+ "  \"name\": \"doggie\",\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 1,\r\n"
				+ "    \"name\": \"Dogs\"\r\n"
				+ "  },\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}";
		
		RequestSpecification reqSpec = RestAssured.given();
		
		reqSpec.baseUri("https://petstore3.swagger.io");
		reqSpec.basePath("/api/v3/pet");
		reqSpec.header("accept", "application/json").contentType(ContentType.JSON);
		
		Response response = reqSpec.body(payload).post();
		
		System.out.println("\n-------------------JSON RESPONSE------------------\n");
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 200,"status code is not matched..");
			
	}
	
	@Test
	public void createPetXMLPayload() {
		
		String payload = "{\r\n"
				+ "  \"id\": 10,\r\n"
				+ "  \"name\": \"doggie\",\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 1,\r\n"
				+ "    \"name\": \"Dogs\"\r\n"
				+ "  },\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}";
		
		RequestSpecification reqSpec = RestAssured.given();
		
		reqSpec.baseUri("https://petstore3.swagger.io");
		reqSpec.basePath("/api/v3/pet");
		reqSpec.header("accept", "application/xml").contentType(ContentType.JSON);
		
		Response response = reqSpec.body(payload).post();
		
		System.out.println("\n-------------------XML RESPONSE------------------\n");
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 200,"status code is not matched..");
		
		// validate response using hamcrest
		response.then().body("Pet.name",Matchers.equalTo("doggie"));
		
		// Validate response using XML path class
		
		XmlPath xmlBody = response.body().xmlPath();
		String name = xmlBody.get("Pet.name");
		System.out.println(name);
		
		Assert.assertEquals(name, "doggie", "name is not matched");
		
		
	}

}
