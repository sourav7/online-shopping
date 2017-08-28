package org.codemaster.shoppingbackend.dao;

import org.codemaster.shoppingbackend.dto.Address;
import org.codemaster.shoppingbackend.dto.Cart;
import org.codemaster.shoppingbackend.dto.User;

public interface UserDAO {
	boolean addUser(User user);
	boolean addAddress(Address address);
	boolean addCart(Cart cart);
}
