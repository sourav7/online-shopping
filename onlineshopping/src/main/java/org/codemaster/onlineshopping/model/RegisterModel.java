package org.codemaster.onlineshopping.model;

import java.io.Serializable;

import org.codemaster.shoppingbackend.dto.Address;
import org.codemaster.shoppingbackend.dto.User;

public class RegisterModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4282748994308940633L;
	private User user;
	private Address billing;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getBilling() {
		return billing;
	}

	public void setBilling(Address billing) {
		this.billing = billing;
	}

}
