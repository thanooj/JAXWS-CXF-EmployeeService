package com.vo;

import java.io.Serializable;
import java.math.BigInteger;

import org.springframework.stereotype.Component;

@Component
public class EmployeeVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigInteger id;
	private String firstName;
	private String lastName;
	private String dept;
	private String doj;
	protected String dNo;
	protected String line;
	protected String street;
	private String city;
	private String state;
	private String country;
	private BigInteger zipcode;
	
	public EmployeeVo() {
	}

	public EmployeeVo(BigInteger id, String firstName, String lastName, String dept, String doj, String dNo,
			String line, String street, String city, String state, String country, BigInteger zipcode) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dept = dept;
		this.doj = doj;
		this.dNo = dNo;
		this.line = line;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getdNo() {
		return dNo;
	}

	public void setdNo(String dNo) {
		this.dNo = dNo;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public BigInteger getZipcode() {
		return zipcode;
	}

	public void setZipcode(BigInteger zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "EmployeeVo [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dept=" + dept
				+ ", doj=" + doj + ", dNo=" + dNo + ", line=" + line + ", street=" + street + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", zipcode=" + zipcode + "]";
	}

}