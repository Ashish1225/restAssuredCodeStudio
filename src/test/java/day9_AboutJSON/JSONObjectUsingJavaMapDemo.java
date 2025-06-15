package day9_AboutJSON;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSONObjectUsingJavaMapDemo {
	
	//  https://restful-booker.herokuapp.com/auth
	
	@Test
	public void createAuthToekn() {
		
		// create JSON object using java MAp
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", "admin");
		map.put("password", "password123");
		
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://restful-booker.herokuapp.com");
		reqSpec.basePath("/auth").contentType(ContentType.JSON);
		
		reqSpec.body(map);
		
		Response response = reqSpec.post();
		
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 200,"status code is not matched");
		
	}

}
