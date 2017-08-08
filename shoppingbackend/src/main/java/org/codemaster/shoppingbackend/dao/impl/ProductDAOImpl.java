package org.codemaster.shoppingbackend.dao.impl;

import java.util.List;

import org.codemaster.shoppingbackend.dao.ProductDAO;
import org.codemaster.shoppingbackend.dto.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author codemaster
 *
 */
@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	/* (non-Javadoc)
	 * 
	 * Returns a single product by id
	 * 
	 * @see org.codemaster.shoppingbackend.dao.ProductDAO#get(int)
	 */
	@Override
	public Product get(int productId) {
		
		try{
			return sessionFactory
					.getCurrentSession()
					.get(Product.class, Integer.valueOf(productId));
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return null;
	}

	/* (non-Javadoc)
	 * List Of Products
	 * @see org.codemaster.shoppingbackend.dao.ProductDAO#list()
	 */
	@Override
	public List<Product> list() {
		return sessionFactory
				.getCurrentSession()
				.createQuery("FROM Product", Product.class)
				.getResultList();
		
	}

	/* (non-Javadoc)
	 * INSERT
	 * @see org.codemaster.shoppingbackend.dao.ProductDAO#add(org.codemaster.shoppingbackend.dto.Product)
	 */
	@Override
	public boolean add(Product product) {
		try{
			sessionFactory
				.getCurrentSession()
				.persist(product);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/* (non-Javadoc)
	 * UPDATE
	 * @see org.codemaster.shoppingbackend.dao.ProductDAO#update(org.codemaster.shoppingbackend.dto.Product)
	 */
	@Override
	public boolean update(Product product) {
		try{
			sessionFactory
				.getCurrentSession()
				.update(product);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * DELETE
	 * 
	 * @see org.codemaster.shoppingbackend.dao.ProductDAO#delete(org.codemaster.shoppingbackend.dto.Product)
	 */
	@Override
	public boolean delete(Product product) {
		try{
			product.setActive(false);
			//call the update method
			sessionFactory
				.getCurrentSession()
				.update(product);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see org.codemaster.shoppingbackend.dao.ProductDAO#listActiveProducts()
	 */
	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts = "FROM Product WHERE active = :active";
		return sessionFactory
				.getCurrentSession()
				.createQuery(selectActiveProducts,Product.class)
				.setParameter("active",true)
				.getResultList();
	}

	/* (non-Javadoc)
	 * @see org.codemaster.shoppingbackend.dao.ProductDAO#listActiveProductsByCategory(int)
	 */
	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		return sessionFactory
				.getCurrentSession()
				.createQuery(selectActiveProductsByCategory,Product.class)
				.setParameter("active",true)
				.setParameter("categoryId", categoryId)
				.getResultList();
	}

	/* (non-Javadoc)
	 * @see org.codemaster.shoppingbackend.dao.ProductDAO#getLatestActiveProducts(int)
	 */
	@Override
	public List<Product> getLatestActiveProducts(int count) {
		String selectLatestActiveProducts = "FROM Product WHERE active = :active ORDER BY id";
		return sessionFactory
				.getCurrentSession()
				.createQuery(selectLatestActiveProducts,Product.class)
				.setParameter("active",true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
	}
	
	
}
