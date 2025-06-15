package day13_ignore_null_fields_from_POJO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(value = {"gender","fullname"})
public class EmployeePOJOForIgnoreFields {
	
	private String firstname;
	private String lastname;
	private String gender;
	private boolean maritalStatus;
	
	private int age;
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private double salary;
	//@JsonIgnore
	private String fullname;
	
	/*
	 * 1. if you want ignore 1 field then @JsonIgnore can be used ,but if you want to ignore multiple fields then
	 * use @JsonIgnoreproperties annotation
	 * 
	 * 2. If you want to ignore any fields from De serialization process only but want to access in serialization,
	 * then use - @jsonProperty(access = jsonProperty.Access>READ_ONLY)
	 */
	

	// getter and setter
	
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean getmaritalStatus() {
		return maritalStatus;
	}
	public void setmaritalStatus(boolean maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

}
