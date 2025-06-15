package day13_ignore_null_fields_from_POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// another way of ignore Unknown properties using - ObjectMapper



//@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeePOJOFOrUnknownProperties {
	
	private String firstname;
	private String lastname;
	private int age;
	private double salary;
	private String gender;
	private boolean married;
	
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	
	
	

}
