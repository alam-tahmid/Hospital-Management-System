package model;

import java.io.Serializable;
import java.util.Random;

public class Paitient implements Serializable {

	
	private static final long serialVersionUID = -8073002703117196230L;
	
	private String id;//unique id of the paitient in the database
	private String firstName;
	private String lastName;
	private String occupation;
	private String age;
	private String address;
	private String phone;
	private String email;
	private Gender gender;
	
	public Paitient(String id,String firstName, String lastName, String occupation,
			String age, String address, String phone, String email,
			Gender gender) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.occupation = occupation;
		this.age = age;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
}
