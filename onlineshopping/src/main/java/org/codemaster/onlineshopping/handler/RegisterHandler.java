package org.codemaster.onlineshopping.handler;

import org.codemaster.onlineshopping.model.RegisterModel;
import org.codemaster.shoppingbackend.dao.UserDAO;
import org.codemaster.shoppingbackend.dto.Address;
import org.codemaster.shoppingbackend.dto.Cart;
import org.codemaster.shoppingbackend.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

@Component
public class RegisterHandler {

	@Autowired
	private UserDAO userDAO;

	public String validateUser(User user, MessageContext error) {
		String transitionValue = "success";

		if (user.getPassword().compareToIgnoreCase(user.getConfirmPassword()) != 0) {
			error.addMessage(new MessageBuilder()
					.error()
					.source("confirmPassword")
					.defaultText("Password does not match the confirm password")
					.build());
			
			transitionValue = "failure";
		}
		//check the uniqueness of email
		if(this.userDAO.getByEmail(user.getEmail()) != null){
			error.addMessage(new MessageBuilder()
					.error()
					.source("email")
					.defaultText("The email you entered is already taken.")
					.build());
			
			transitionValue = "failure";
		}

		return transitionValue;
	}

	public String saveAll(RegisterModel model) {
		String transitionValue = "success";

		User user = model.getUser();

		if (user.getRole().equals("USER")) {
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		userDAO.addUser(user);

		Address billing = model.getBilling();
		billing.setUser(user);
		billing.setBilling(true);

		userDAO.addAddress(billing);

		return transitionValue;
	}

	public RegisterModel init() {
		return new RegisterModel();
	}

	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}

	public void addBilling(RegisterModel registerModel, Address billing) {
		registerModel.setBilling(billing);
	}
}
