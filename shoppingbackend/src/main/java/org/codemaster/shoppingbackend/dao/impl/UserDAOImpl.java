package org.codemaster.shoppingbackend.dao.impl;

import java.util.List;

import org.codemaster.shoppingbackend.dao.UserDAO;
import org.codemaster.shoppingbackend.dto.Address;
import org.codemaster.shoppingbackend.dto.Cart;
import org.codemaster.shoppingbackend.dto.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) {
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().persist(address);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public User getByEmail(String email) {
		String selectQuery = "FROM User WHERE email = :email";
		try {
			return this.sessionFactory.getCurrentSession().createQuery(selectQuery, User.class)
					.setParameter("email", email).getSingleResult();

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Address getBillingAddress(User user) {
		String selectQuery = "FROM Address WHERE user = :user AND billing = :billing";
		try {
			return this.sessionFactory.getCurrentSession().createQuery(selectQuery, Address.class)
					.setParameter("user", user).setParameter("billing", true).getSingleResult();

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Address> listShippingAddresses(User user) {
		String selectQuery = "FROM Address WHERE user = :user AND shipping = :shipping";
		try {
			return this.sessionFactory.getCurrentSession().createQuery(selectQuery, Address.class)
					.setParameter("user", user).setParameter("shipping", true).getResultList();

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
