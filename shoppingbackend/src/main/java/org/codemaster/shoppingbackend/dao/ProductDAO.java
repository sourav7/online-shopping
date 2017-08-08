package org.codemaster.shoppingbackend.dao;

import java.util.List;

import org.codemaster.shoppingbackend.dao.impl.ProductDAOImpl;
import org.codemaster.shoppingbackend.dto.Product;

/**
 * Interface uses product. see {@link ProductDAOImpl}
 * 
 * @author codemaster
 *
 */
public interface ProductDAO {
	
	/**
	 * @param productId
	 * @return
	 */
	Product get(int productId);
	/**
	 * @return
	 */
	List<Product> list();
	/**
	 * @param product
	 * @return
	 */
	boolean add(Product product);
	/**
	 * @param product
	 * @return
	 */
	boolean update(Product product);
	/**
	 * @param product
	 * @return
	 */
	boolean delete(Product product);
	
	//business methods
	/**
	 * @return All active products
	 */
	List<Product> listActiveProducts();
	/**
	 * @param categoryId
	 * @return List of Active Products By Category of a specific id
	 */
	List<Product> listActiveProductsByCategory(int categoryId);
	/**
	 * @param count
	 * @return List of active product
	 */
	List<Product> getLatestActiveProducts(int count);
}
