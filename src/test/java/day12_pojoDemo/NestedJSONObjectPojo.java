package day12_pojoDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NestedJSONObjectPojo {
	
	
	@Test
	public void createUser() throws JsonProcessingException {
		
		Student stu = new Student();
		stu.setFirstName("Ashish");
		stu.setLastName("rathour");
		stu.setAge(30);
		stu.setGender("Male");
		stu.setSalary(64454.90);
		
		StudentAddress studentAdress = new StudentAddress();
		studentAdress.setStreet("Civil Lines");
		studentAdress.setCity("Firozabad");
		studentAdress.setState("Uttar Pradesh");
		studentAdress.setPincode(283837);
		stu.setAddress(studentAdress);
		
		// convert class object to json object  as string
		
		ObjectMapper objMapper  = new ObjectMapper();
		String stringPayload = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(stu);
		
		System.out.println(stringPayload);
		
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://httpbin.org");
		reqSpec.basePath("/post");
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(stringPayload);
		Response response = reqSpec.post();
		
		System.out.println("Response is :"+response.asString());
		
		Assert.assertEquals(response.statusCode(), 200,"status code is not matched..");
		
		System.out.println("-------------- Deserialization --------------");
		
		Student stud = objMapper.readValue(stringPayload, Student.class);
		
		System.out.println(stud.getAge());
		System.out.println(stud.getFirstName());
		
		StudentAddress studAddress = stud.getAddress();
		System.out.println(studAddress.getCity());
		System.out.println(studAddress.getState());
		
	}

}
