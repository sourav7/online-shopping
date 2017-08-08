package org.codemaster.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.codemaster.shoppingbackend.dao.ProductDAO;
import org.codemaster.shoppingbackend.dto.Product;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductTestCase {
	private static AnnotationConfigApplicationContext context;

	private static ProductDAO productDAO;

	@SuppressWarnings("unused")
	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("org.codemaster.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

/*	@Test
	public void testCRUDProduct() {
		product = new Product();
		
		product.setName("Oppo Selfie 553");
		product.setBrand("Oppo");
		product.setDescription("Description for Oppo Selfie 553");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
		assertEquals("Something went wrong while adding products",true,productDAO.add(product));
		
		//reading and updating the product
		product = productDAO.get(2);
		product.setName("Samsung galaxy s7");
		assertEquals("Something went wrong while adding products",true,productDAO.update(product));
		
		assertEquals("Something went wrong while deleting existing records",true,productDAO.delete(product));
		
		//list
		assertEquals("Something went wrong while fetching list of products",7,productDAO.list().size());
		
	}*/
	
	@Test
	public void testListOfActiveProducts(){
		assertEquals("Something went wrong while fetching active records",6,productDAO.listActiveProducts().size());
	}
	@Test
	public void testListOfActiveProductsByCategory(){
		assertEquals("Something went wrong while fetching active records",4,productDAO.listActiveProductsByCategory(3).size());
	}
	
	@Test
	public void testGetLatestActiveProducts(){
		assertEquals("Something went wrong while fetching latest active records",3,productDAO.getLatestActiveProducts(3).size());
	}
}
