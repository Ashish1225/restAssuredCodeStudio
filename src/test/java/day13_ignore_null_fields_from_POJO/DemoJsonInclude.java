package day13_ignore_null_fields_from_POJO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DemoJsonInclude {
	
	
	@Test
	public void testMethod1() throws JsonProcessingException {
		
		// create payload
		EmployeePOJOClass emp = new EmployeePOJOClass();
		emp.setFirstname("Ashish");
		//emp.setLastname("Rathour");
		//emp.setAge(30);
		emp.setGender("Male");
		emp.setSalary(90802.43);
		//emp.setIsmarried(true);
		
		// empty array
		String hobbies[] = {};
		emp.setHobbies(hobbies);
		
		// empty list
		List<String> degress = new ArrayList<String>();
		emp.setDegress(degress);
		// empty map
		
		Map<String, String> familymembers = new HashMap<String, String>();
		emp.setFamilymembers(familymembers);
		// create class object into Json object
		
		ObjectMapper objMapper = new ObjectMapper();
		String employeePayload = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		
		System.out.println(employeePayload);
	}

}
