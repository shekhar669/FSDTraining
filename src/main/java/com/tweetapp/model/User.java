package com.tweetapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Name is mandatory")
    private String firstName;
    
    @NotBlank(message = "last name is mandatory")
    private String lastName;
    
    @NotBlank(message = "loginId is mandatory")
    private String loginId;
    
    @NotBlank(message = "Email is mandatory")
    private String email;
    
    @NotBlank(message = "password is mandatory")
    private String password;
    
    private String contactnumber;

	public String getContactnumber() {
		return contactnumber;
	}

	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {}

   
    public void setId(long id) {
        this.id = id;
    }
    
    public long getId() {
        return id;
    }
    
   
    public void setEmail(String email) {
        this.email = email;
    }

   
    public String getEmail() {
        return email;
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

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public User(long id, @NotBlank(message = "Name is mandatory") String firstName,
			@NotBlank(message = "last name is mandatory") String lastName,
			@NotBlank(message = "loginId is mandatory") String loginId,
			@NotBlank(message = "Email is mandatory") String email,
			@NotBlank(message = "password is mandatory") String password, String contactnumber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.loginId = loginId;
		this.email = email;
		this.password = password;
		this.contactnumber = contactnumber;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", loginId=" + loginId
				+ ", email=" + email + ", password=" + password + ", contactnumber=" + contactnumber + "]";
	}

}