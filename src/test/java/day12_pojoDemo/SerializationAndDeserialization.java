package day12_pojoDemo;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SerializationAndDeserialization {

	// serialization

	@Test
	public void creatJSONObjectFromEmployeeClass() {

		Employee emp1 = new Employee();
		emp1.setFirstName("Ashish");
		System.out.println("First name is :"+emp1.getFirstName());

		emp1.setLastName("rathour");
		System.out.println("Last name is :"+emp1.getLastName());

		emp1.setGender("Male");
		System.out.println("gender is :"+emp1.getGender());

		emp1.setAge(30);
		System.out.println("Age is :"+emp1.getAge());

		emp1.setSalary(60000);
		System.out.println("salary is :"+emp1.getSalary());

		// convert Employee class object to JSON string 
		ObjectMapper objMap = new ObjectMapper();
		String employeeJson = null;
		try {
			employeeJson = objMap.writeValueAsString(emp1);
			System.out.println("Employee response is :"+employeeJson);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println("-----------------------");
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://httpbin.org");
		reqSpec.basePath("/post");
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(employeeJson);
		Response response = reqSpec.post();
		
		response.prettyPrint();
		
		// convert json object to class object
		System.out.println("-------------- Deserialization -----------");
		
		Employee emp2 = null;
		try {
			emp2 = objMap.readValue(employeeJson, Employee.class);
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		
		System.out.println(emp2.getAge());
		System.out.println(emp2.getFirstName());
		System.out.println(emp2.getLastName());
	}

}
