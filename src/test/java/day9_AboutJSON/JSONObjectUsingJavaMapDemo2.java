package day9_AboutJSON;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSONObjectUsingJavaMapDemo2 {
	
	//  https://reqres.in/api/users
	
	@Test
	public void createUserUsingMap() {
		
		// create JSON object using java MAp
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("firstname", "Ashish");
		map.put("lastname", "Rathour");
		map.put("age", 30);
		map.put("salary", 60000);
		map.put("ismarried", true);
		
		List<String> hobbiesList = Arrays.asList("Music","Travelling","Painting");
		map.put("Hobbies", hobbiesList);
		
		Map<String, String> skills = new HashMap<String, String>();
		skills.put("programming language", "java");
		skills.put("webAutomation", "selenium");
		skills.put("api testing", "Rest Assured");
		
		map.put("TechSkills", skills);
		
		
		
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://reqres.in");
		reqSpec.basePath("/api/users").contentType(ContentType.JSON);
		reqSpec.header("x-api-key","reqres-free-v1");
		
		reqSpec.body(map);
		
		Response response = reqSpec.post();
		
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 201,"status code is not matched");
		
	}

}
