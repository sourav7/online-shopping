package org.codemaster.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.codemaster.onlineshopping.util.FileUploadUtility;
import org.codemaster.onlineshopping.validator.ProductValidator;
import org.codemaster.shoppingbackend.dao.CategoryDAO;
import org.codemaster.shoppingbackend.dao.ProductDAO;
import org.codemaster.shoppingbackend.dto.Category;
import org.codemaster.shoppingbackend.dto.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private CategoryDAO categoryDAO;

	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

	@RequestMapping(value = { "/products" }, method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name = "operation", required = false) String operation) {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");

		Product nProduct = new Product();

		// set few fields
		nProduct.setSupplierId(1);
		nProduct.setActive(true);

		mv.addObject("product", nProduct);

		if (operation != null) {
			if (operation.equals("product")) {
				mv.addObject("message", "Product submitted successfully.");
			}else if(operation.equals("category")){
				mv.addObject("message", "Category submitted successfully.");
			}
		}

		return mv;
	}

	@RequestMapping(value = { "/product/{id}/activation" })
	@ResponseBody
	public String handleProductActivation(@PathVariable("id") int id) {
		Product product = productDAO.get(id);
		boolean isActive = product.isActive();

		product.setActive(!product.isActive());

		productDAO.update(product);

		return (isActive) ? "You have successfully deactivated the product with id : " + id
				: "You have successfully activated the product with id : " + id;
	}

	@RequestMapping(value = { "/{id}/product" }, method = RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");

		Product nProduct = productDAO.get(id);

		// set few fields
		mv.addObject("product", nProduct);

		return mv;
	}

	// handling product submission
	// Binding result should come after modelattribute and not after Model
	@RequestMapping(value = { "/products" }, method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results,
			Model model, HttpServletRequest request) {

		if (mProduct.getId() == 0) {
			new ProductValidator().validate(mProduct, results);
		} else {
			//ensure for a valid file
			if(!mProduct.getFile().getOriginalFilename().equals("")){
				new ProductValidator().validate(mProduct, results);
			}
		}

		// check if there are any errors
		if (results.hasErrors()) {
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation failed for product submission.");

			return "page";
		}

		logger.info(mProduct.toString());
		if (mProduct.getId() == 0)
			this.productDAO.add(mProduct);
		else {
			this.productDAO.update(mProduct);
		}

		if (!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}

		return "redirect:/manage/products?operation=product";
	}

	//to handle category submission
	@RequestMapping(value ={"/category"}, method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category){
		categoryDAO.add(category);
		
		return "redirect:/manage/products?operation=category";
	}
	
	
	// returning categories for all the request
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDAO.list();
	}
	
	@ModelAttribute("category")
	public Category getCategory() {
		return new Category();
	}
}
