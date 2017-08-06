package org.codemaster.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.codemaster.shoppingbackend.dao.CategoryDAO;
import org.codemaster.shoppingbackend.dto.Category;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	@SuppressWarnings("unused")
	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("org.codemaster.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}

	@Test
	public void testGetListOfCategory() {
		
		assertEquals("Successfully added a category in database", 2, categoryDAO.list().size());
	}

/*	@Test
	public void testAddCategory() {
		category = new Category();
		category.setName("Mobile");
		category.setDescription("Description for mobile");
		category.setImageURL("CAT_MOB.png");

		assertEquals("Successfully added a category in database", true, categoryDAO.add(category));
	}*/
	
	/*@Test
	public void testGetCategory(){
		category = categoryDAO.get(3);
		System.out.println(category);
		assertEquals("Successfully fetched single category only when it mathces with the Television", "Television",category.getName());
	}*/
	
	/*@Test
	public void testUpdateCategory(){
		category = categoryDAO.get(3);
		category.setName("TV");
		assertEquals("Successfully updated category only when it mathces with the Television", true,categoryDAO.update(category));
	} */
	
	/*@Test
	public void testDeleteCategory(){
		category = categoryDAO.get(3);
		
		assertEquals("Successfully updated category only when it mathces with the Television", true,categoryDAO.delete(category));
	} */
}
