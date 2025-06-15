package day12_pojoDemo;

public class Employee {
	
	// -------------- POJO --------------
	private String firstname;
	private String lastname;
	private String gender;
	private int age;
	private double salary;
	
	// getter and setter
	
	public String getFirstName() {
		return firstname;
	}
	
	// setter
	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastName() {
		return lastname;
	}
	
	public void setLastName(String lastname) {
		this.lastname = lastname;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
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
	
	
	

}
