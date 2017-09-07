package org.codemaster.shoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "user_detail")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3339066954014697122L;
	/*
	 * private fields for user
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_name")
	@NotBlank(message = "Please enter first name")
	private String firstName;
	@Column(name = "last_name")
	@NotBlank(message = "Please enter last name")
	private String lastName;
	@NotBlank(message = "Please enter email")
	private String email;
	@NotBlank(message = "Please enter contact number")
	private String contactNumber;
	private String role;
	private String password;

	// confirm password transient field
	@Transient
	private String confirmPassword;
	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	private boolean enabled = true;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Cart cart;

	public User() {

	}

	public User(String firstName, String lasttName, String email, String contactNumber, String role, String password) {
		this.firstName = firstName;
		this.lastName = lasttName;
		this.email = email;
		this.contactNumber = contactNumber;
		this.role = role;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lasttName) {
		this.lastName = lasttName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", contactNumber=" + contactNumber + ", role=" + role + ", password=" + password + ", enabled="
				+ enabled + "]";
	}

}
