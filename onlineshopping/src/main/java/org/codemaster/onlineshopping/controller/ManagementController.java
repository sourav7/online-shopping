package org.codemaster.onlineshopping.controller;

import java.util.List;

import org.codemaster.shoppingbackend.dao.CategoryDAO;
import org.codemaster.shoppingbackend.dto.Category;
import org.codemaster.shoppingbackend.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = { "/products" }, method = RequestMethod.GET)
	public ModelAndView showManageProducts() {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");

		Product nProduct = new Product();

		// set few fields
		nProduct.setSupplierId(1);
		nProduct.setActive(true);

		mv.addObject("product", nProduct);

		return mv;
	}

	// returning categories for all the request
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDAO.list();
	}
}
