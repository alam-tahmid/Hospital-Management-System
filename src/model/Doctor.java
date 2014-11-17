package model;

import java.io.Serializable;

public class Doctor implements Serializable {


	private static final long serialVersionUID = -6520086370486146545L;
	
	private String id;//unique id of the doctor in the database
	private String name;
	private String specialization;
	private String address;
	private String phone;
	private String email;
	private Gender gender;
	public Doctor(String id, String name, String specialization,
			String address, String phone, String email, Gender gender) {


		this.id = id;
		this.name = name;
		this.specialization = specialization;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
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
