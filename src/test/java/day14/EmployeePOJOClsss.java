package day14;

import java.util.List;
import java.util.Map;

public class EmployeePOJOClsss {
	
	private String firstname;
	private String lastname;
	private int age;
	private double salary;
	private String gender;
	private boolean married;
	private String[] hobbies;
	private Map<String, String> familymembers;
	
	
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
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public Map<String, String> getFamilymembers() {
		return familymembers;
	}
	public void setFamilymembers(Map<String, String> familymembers) {
		this.familymembers = familymembers;
	}
	
	

}
