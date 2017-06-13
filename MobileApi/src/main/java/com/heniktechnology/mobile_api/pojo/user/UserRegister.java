package com.heniktechnology.mobile_api.pojo.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class UserRegister {


	@Id  
    private String loginId;

    private String password;

    private String firstName;

    private String lastName;
    
    private String active;

	public UserRegister() {
		super();
	}

	public UserRegister(String loginId, String password, String firstName, String lastName, String active) {
		super();
		this.loginId = loginId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.active = active;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "UserRegister [loginId=" + loginId + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", active=" + active + "]";
	}

   
}