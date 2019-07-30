package com.shantanu.productcatalogue.domain.service;

import java.util.List;

import com.shantanu.productcatalogue.model.InputDTO;
import com.shantanu.productcatalogue.model.OutputDTO;

public interface ProductService {

	List<OutputDTO> allocateResources(InputDTO input) throws Exception;

}
