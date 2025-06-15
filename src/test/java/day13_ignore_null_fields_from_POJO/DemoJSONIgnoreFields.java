package day13_ignore_null_fields_from_POJO;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DemoJSONIgnoreFields {
	
	
	@Test
	public void  testMethod1() throws JsonProcessingException {
		
		EmployeePOJOForIgnoreFields emp = new EmployeePOJOForIgnoreFields();
		emp.setAge(30);
		emp.setFirstname("Ashish");
		emp.setLastname("Rathour");
		emp.setGender("Male");
		emp.setSalary(564656.0);
		emp.setFullname("Ashish Rathour");
		emp.setmaritalStatus(true);
		
		// serialization
		ObjectMapper objMapper = new ObjectMapper();
		String empPayload = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		
		System.out.println(empPayload);
		
		// De-serialization jSON payload to Employee CLass Object
		
		String payload = "{\r\n"
				+ "  \"firstname\" : \"Ashish\",\r\n"
				+ "  \"lastname\" : \"Rathour\",\r\n"
				+ "  \"gender\" : \"Male\",\r\n"
				+ "  \"salary\" : 564656.0,\r\n"
				+ "  \"age\" : 30,\r\n"
				+ "  \"fullname\" : \"Ashish Rathour\",\r\n"
				+ "  \"maritalStatus\" : false\r\n"
				+ "}";
		
		EmployeePOJOForIgnoreFields emp2 = objMapper.readValue(payload, EmployeePOJOForIgnoreFields.class);
		
		System.out.println(emp2.getFirstname());
		System.out.println(emp2.getLastname());
		System.out.println(emp2.getGender());
		System.out.println(emp2.getAge());
		System.out.println(emp2.getSalary());
		System.out.println(emp2.getFullname());
		System.out.println(emp2.getmaritalStatus());
		
	}

}
