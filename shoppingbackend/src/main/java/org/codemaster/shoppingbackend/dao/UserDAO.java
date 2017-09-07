package org.codemaster.shoppingbackend.dao;

import java.util.List;

import org.codemaster.shoppingbackend.dao.impl.UserDAOImpl;
import org.codemaster.shoppingbackend.dto.Address;
import org.codemaster.shoppingbackend.dto.Cart;
import org.codemaster.shoppingbackend.dto.User;

/**
 * {@link UserDAOImpl}
 * @author John
 *
 */
public interface UserDAO {
	boolean addUser(User user);

	User getByEmail(String email);

	boolean addAddress(Address address);

	boolean updateCart(Cart cart);

	Address getBillingAddress(User user);

	List<Address> listShippingAddresses(User user);
}
