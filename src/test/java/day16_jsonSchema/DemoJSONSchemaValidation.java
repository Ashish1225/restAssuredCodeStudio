package day16_jsonSchema;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DemoJSONSchemaValidation {
	
	
	@Test
	public void testmethod() {
		
		String reqPayload = "{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}";
		
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://restful-booker.herokuapp.com/auth");
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(reqPayload);
		Response response = reqSpec.post();
		
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 200,"Status code is not matched..");
		Assert.assertNotNull(response.jsonPath().getString("token"),"token should not be null..");
		
		File schemaFile = new File("C:\\Users\\ashu2\\OneDrive\\Desktop\\Rest Assured Data\\schema.json");
		
		response.then().body(JsonSchemaValidator.matchesJsonSchema(schemaFile));
	}

}
