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

	// @Test
	// public void testAdd() {
	// user = new User("Hrittik", "Roshan", "hr@gmail.com", "1234512345",
	// "USER", "123456");
	//
	// assertEquals("Failed to add user!", true, userDAO.addUser(user));
	// address = new Address("101/B Jadoo Society, Krish Nagar", "Near Kabil
	// store", "Mumbai", "Maharastra", "India",
	// "400001", true);
	//
	// //link the user with address
	// address.setUserId(user.getId());
	//
	// assertEquals("Failed to add address!", true,
	// userDAO.addAddress(address));
	//
	// if(user.getRole().equals("USER")){
	// //create a cart
	// cart = new Cart();
	// cart.setUser(user);
	//
	// //add to cart
	// assertEquals("Failed to add cart!", true, userDAO.addCart(cart));
	//
	// //add a shipping address
	// address = new Address("201/B Jadoo Society, Krish Kanai Nagar", "Near
	// Dhoom store", "Mumbai", "Maharastra", "India",
	// "400001", false);
	// //shipping true billing false
	// address.setShipping(true);
	//
	// //link to user
	// address.setUserId(user.getId());
	//
	// assertEquals("Failed to add shipping address!", true,
	// userDAO.addAddress(address));
	//
	// }
	//
	// }

	////////////////////////////////////////////////////////////////////////////////////////

	// @Test
	// public void testAdd() {
	// user = new User("Hrittik", "Roshan", "hr@gmail.com", "1234512345",
	// "USER", "123456");
	//
	// if (user.getRole().equals("USER")) {
	// // create a cart
	// cart = new Cart();
	// cart.setUser(user);
	//
	// // attach cart with user
	// user.setCart(cart);
	//
	// }
	// assertEquals("Failed to add user!", true, userDAO.addUser(user));
	//
	// }

	///////////////////////////////////////////////////////////////////////////////////

	// @Test
	// public void testAddAddress() {
	// // we need to add an user
	// user = new User("Hrittik", "Roshan", "hr@gmail.com", "1234512345",
	// "USER", "123456");
	//
	// assertEquals("Failed to add user!", true, userDAO.addUser(user));
	//
	// // we are going to add the address
	// address = new Address("101/B Jadoo Society, Krish Nagar", "Near Kabil
	// store", "Mumbai", "Maharastra", "India",
	// "400001", true);
	//
	// address.setUser(user);
	// assertEquals("Failed to add address!", true,
	// userDAO.addAddress(address));
	//
	// // we are also going to add the shipping address
	// address = new Address("101/B Jadoo Society, Krish Nagar", "Near Kabil
	// store", "Mumbai", "Maharastra", "India",
	// "400001", false);
	// address.setShipping(true);
	//
	// address .setUser(user);
	//
	// assertEquals("failed adding shipping address", true,
	// userDAO.addAddress(address));
	// }

	// @Test
	// public void testAddAddress() {
	// // we need to add an user
	// user = userDAO.getByEmail("hr@gmail.com");
	// // we are going to add the address
	// address = new Address("301/B Jadoo Society, Kanaiya Nagar", "Near Dhoom
	// store", "Mumbai", "Maharastra", "India",
	// "400001", false);
	// address.setShipping(true);
	//
	// address.setUser(user);
	// assertEquals("Failed to add shipping address!", true,
	// userDAO.addAddress(address));
	// }

	@Test
	public void testGetAddress() {
		user = userDAO.getByEmail("hr@gmail.com");

		assertEquals("Failed to fetch thel list of address and size does not match", 2,
				userDAO.listShippingAddresses(user).size());
		assertEquals("Failed to fetch thel list of address and size does not match", "Mumbai",
				userDAO.getBillingAddress(user).getCity());
	}
}
