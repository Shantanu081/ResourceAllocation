package com.shantanu.productcatalogue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shantanu.productcatalogue.domain.service.ProductService;
import com.shantanu.productcatalogue.model.InputDTO;
import com.shantanu.productcatalogue.model.OutputDTO;

@RestController
@RequestMapping("/productcatalogue")
public class ProductController {

	@Autowired
	ProductService productService;

	/**
	 * @param input, a json containing flats numbers, along with capacities of
	 *        senior and junior.
	 * @return a json after allocation of senior and junior resources.
	 * @throws Exception.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/getWorkforce", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	List<OutputDTO> getAllocationDetails(@RequestBody InputDTO input) throws Exception {

		List<OutputDTO> response = productService.allocateResources(input);
		if (response == null) {
			throw new Exception("Exception occured while getting the response");
		}
		return response;
	}
}
