package day13_ignore_null_fields_from_POJO;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

// if you want to ignore null value - @JsonInclude(JsonInclude.Include.NON_NULL)

// if you want ignore empty value -- @JsonInclude(JsonInclude.Include.NON_EMPTY)


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EmployeePOJOClass {
	
	private String firstname;
	private String lastname;
	private int age;
	private double salary;
	private String gender;
	private boolean ismarried;
	private String[] hobbies;
	private List<String> degress;
	private Map<String, String> familymembers;
	
	

	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public List<String> getDegress() {
		return degress;
	}
	public void setDegress(List<String> degress) {
		this.degress = degress;
	}
	public Map<String, String> getFamilymembers() {
		return familymembers;
	}
	public void setFamilymembers(Map<String, String> familymembers) {
		this.familymembers = familymembers;
	}
	public boolean isIsmarried() {
		return ismarried;
	}
	public void setIsmarried(boolean ismarried) {
		this.ismarried = ismarried;
	}
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
	
}
