package day14;

import java.util.Map;
import java.util.Map.Entry;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DemoMockTest {
	
	// https://run.mocky.io/v3/427637d0-0150-4dc0-9994-2278e8d2249e
	
	
	@Test
	public void test1() {
		
		RequestSpecification reqSpec = RestAssured.given();
		
		reqSpec.baseUri("https://run.mocky.io/v3/427637d0-0150-4dc0-9994-2278e8d2249e");
		
		Response response = reqSpec.get();
		
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 200,"Status code is not matched..");
		
		// deserialization
		
		EmployeePOJOClsss emp2 = response.as(EmployeePOJOClsss.class);
		System.out.println("Age is :"+emp2.getAge());
		System.out.println("First name is :"+emp2.getFirstname());
		System.out.println("last name is :"+emp2.getLastname());
		System.out.println("Gender is :"+emp2.getGender());
		System.out.println("Mariatal status :"+emp2.isMarried());
		System.out.println("Salary is :"+emp2.getSalary());
		
		String[] hobbies = emp2.getHobbies();
		for(String hobby : hobbies) {
			System.out.println(hobby);
		}
		
		Map<String, String> members = emp2.getFamilymembers();
		for(Map.Entry<String, String> mem :members.entrySet()) {
			System.out.println(mem.getKey() +" and value is :"+mem.getValue());
		}
	}

}
