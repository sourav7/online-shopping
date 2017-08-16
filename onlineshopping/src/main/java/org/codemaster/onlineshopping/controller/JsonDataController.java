package org.codemaster.onlineshopping.controller;

import java.util.List;

import org.codemaster.shoppingbackend.dao.ProductDAO;
import org.codemaster.shoppingbackend.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts() {
		return this.productDAO.listActiveProducts();
	}
	
	@RequestMapping("/admin/all/products")
	@ResponseBody
	public List<Product> getAllProductsForAdmin() {
		return this.productDAO.list();
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable("id") int id) {
		return this.productDAO.listActiveProductsByCategory(id);
	}
}
