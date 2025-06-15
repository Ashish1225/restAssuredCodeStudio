package day12_pojoDemo;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSONArrayPOJOClassDemo {

	@Test
	public void createEmployeesJSONArray() throws JsonProcessingException {

		// creating 3 Employee class object.
		Employee emp1 = new Employee();

		emp1.setFirstName("Ashish");
		emp1.setLastName("rathour");
		emp1.setGender("Male");
		emp1.setAge(30);
		emp1.setSalary(60000.0);

		Employee emp2 = new Employee();

		emp2.setFirstName("Neealm");
		emp2.setLastName("rathour");
		emp2.setGender("Female");
		emp2.setAge(25);
		emp2.setSalary(56000.0);

		Employee emp3 = new Employee();

		emp3.setFirstName("Rakhi");
		emp3.setLastName("Singh");
		emp3.setGender("Female");
		emp3.setAge(28);
		emp3.setSalary(20000);
		
		// create list of employee
		
		List<Employee> payload = new ArrayList<Employee>();
		payload.add(emp1);
		payload.add(emp2);
		payload.add(emp3);
		
		// convert Employee class object to JSoN Array
		ObjectMapper objMapper = new ObjectMapper();
		
		String stringPayload = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(payload);
		
		System.out.println("\nConverted JSON Array from Employee Class..\n");
		System.out.println(stringPayload);
		
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://httpbin.org");
		reqSpec.basePath("/post");
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(stringPayload);
		Response response = reqSpec.post();
		
		System.out.println("Response is :"+response.asString());
		
		Assert.assertEquals(response.statusCode(), 200,"status code is not matched..");
		
		System.out.println("------------- Deserialization -------------");
		JsonPath jsonPathView = response.jsonPath();
		System.out.println(jsonPathView.getString("json[1].firstName"));
	
		List<Employee> allEmployee = jsonPathView.getList("json",Employee.class);
		for(Employee emp :allEmployee) {
			System.out.println(emp.getFirstName());
		}
		
	}

}
