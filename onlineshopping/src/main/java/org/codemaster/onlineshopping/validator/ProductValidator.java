package org.codemaster.onlineshopping.validator;

import org.codemaster.shoppingbackend.dto.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;

		// whether file has been selected
		if (product.getFile() == null || product.getFile().getOriginalFilename().equals("")) {
			errors.rejectValue("file", null, "Please select an image file to upload");
			return;
		}
		// what is mime type like ("images/jpeg")
		if (!(product.getFile().getContentType().equals("image/jpeg")
				|| product.getFile().getContentType().equals("image/png")
				|| product.getFile().getContentType().equals("image/gif"))) {
			errors.rejectValue("file", null, "Please use only image file to upload");
			return;
		}
	}

}
