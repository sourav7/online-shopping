package org.codemaster.shoppingbackend.dao.impl;

import java.util.List;

import org.codemaster.shoppingbackend.dao.CategoryDAO;
import org.codemaster.shoppingbackend.dto.Category;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// private static List<Category> categories = new ArrayList<>();
	/*
	 * Returns the active category list
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Category> list() {

		String selectActiveCategory = "FROM Category WHERE active = :active";

		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);

		return query.getResultList();
	}

	/*
	 * Getting single category based on ID
	 */
	@Override
	public Category get(int id) {
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {
		try {
			// add category
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Category category) {
		try {
			// update category
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try {
			// update category
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
/*
 * Driver : org.h2.Driver url = jdbc:h2:tcp://localhost/~/onlineshopping name =
 * sa pass =
 */
// static {
// // adding first category
// Category category = new Category();
// category.setId(1);
// category.setName("Television");
// category.setDescription("Description for television");
// category.setImageURL("CAT_1.png");
//
// categories.add(category);
//
// // adding second category
// category = new Category();
// category.setId(2);
// category.setName("Mobile");
// category.setDescription("Description for mobile");
// category.setImageURL("CAT_2.png");
//
// categories.add(category);
//
// // adding third category
// category = new Category();
// category.setId(3);
// category.setName("Laptop");
// category.setDescription("Description for laptop");
// category.setImageURL("CAT_3.png");
//
// categories.add(category);
// }