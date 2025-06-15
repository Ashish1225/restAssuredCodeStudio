package day12_pojoDemo;

import java.util.List;

public class NestedJSONPOJOClass {
	
	/* 
			"companyname":"xyz limited",
			"street":"Avenue park",
			"city":"Mumbai",
			"state":"maharashtra",
			"pincode":474655,
			"Bankaccounts":["HDFC","SBI","ICICI","AXIS"]
	*/
	
	private String companyname;
	private String street;
	private String city;
	private String state;
	private int pincode;
	private List<String> bankaccounts;
	private List<Student> employeeList;
	
	
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public List<String> getBankaccounts() {
		return bankaccounts;
	}
	public void setBankaccounts(List<String> bankaccounts) {
		this.bankaccounts = bankaccounts;
	}
	public List<Student> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<Student> employeeList) {
		this.employeeList = employeeList;
	}
	
	

}
