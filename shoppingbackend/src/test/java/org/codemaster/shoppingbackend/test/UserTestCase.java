package org.codemaster.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.codemaster.shoppingbackend.dao.UserDAO;
import org.codemaster.shoppingbackend.dto.Address;
import org.codemaster.shoppingbackend.dto.Cart;
import org.codemaster.shoppingbackend.dto.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserTestCase {
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("org.codemaster.shoppingbackend");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");
	}

	@Test
	public void testAdd() {
		user = new User("Hrittik", "Roshan", "hr@gmail.com", "1234512345", "USER", "123456");

		assertEquals("Failed to add user!", true, userDAO.addUser(user));
		address = new Address("101/B Jadoo Society, Krish Nagar", "Near Kabil store", "Mumbai", "Maharastra", "India",
				"400001", true);
		
		//link the user with address
		address.setUserId(user.getId());
		
		assertEquals("Failed to add address!", true, userDAO.addAddress(address));
		
		if(user.getRole().equals("USER")){
			//create a cart
			cart = new Cart();
			cart.setUser(user);
			
			//add to cart
			assertEquals("Failed to add cart!", true, userDAO.addCart(cart));
			
			//add a shipping address
			address = new Address("201/B Jadoo Society, Krish Kanai Nagar", "Near Dhoom store", "Mumbai", "Maharastra", "India",
					"400001", false);
			//shipping true billing false
			address.setShipping(true);
			
			//link to user
			address.setUserId(user.getId());
			
			assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
			
		}

	}
}
