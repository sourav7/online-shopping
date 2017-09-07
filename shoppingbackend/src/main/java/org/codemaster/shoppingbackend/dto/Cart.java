package org.codemaster.shoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 146552818156788674L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/*---------*/
	// @JoinColumn(name = "uid")
	@OneToOne
	private User user;
	/*---------*/

	@Column(name = "grand_total")
	private double grandTotal;
	@Column(name = "cart_lines")
	private int cartLines;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public int getCartLines() {
		return cartLines;
	}

	public void setCartLines(int cartLines) {
		this.cartLines = cartLines;
	}

}
