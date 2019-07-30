package com.shantanu.productcatalogue.allocation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shantanu.productcatalogue.domain.service.ProductService;
import com.shantanu.productcatalogue.model.InputDTO;
import com.shantanu.productcatalogue.model.OutputDTO;

@Service
public class ProductServiceImpl implements ProductService {

	@Override
	public List<OutputDTO> allocateResources(InputDTO input) throws Exception {
		if (input == null) {
			throw new Exception("Inpur json cannot be null.");
		}
		List<Integer> flats = new ArrayList<>();
		int srCapacity = input.getSenior();
		int jrCapacity = input.getJunior();
		flats = input.getRooms();
		Object[] objects = flats.toArray();
		List<OutputDTO> responses = new ArrayList<>();

		for (int i = 0; i < objects.length; i++) {
			int srResource = 0;

			++srResource;
			OutputDTO response = allocateResource(srResource,
					((int) objects[i] - srCapacity) < 0 ? 0 : ((int) objects[i] - srCapacity), srCapacity, jrCapacity);

			responses.add(response);
		}
		return responses;
	}

	/**
	 * Checking the efficiency of junior and senior resources. If capacity of the
	 * worker is 6 and he/she is cleaning 6 rooms then the efficiency in 100% . We
	 * are giving priority to efficiency.
	 */
	private OutputDTO allocateResource(int srResource, int leftRoomCount, int srCapacity, int jrCapacity) {

		OutputDTO response = new OutputDTO();
		int jrResource = 0;

		if (leftRoomCount == 0) {
			response.setJunior(jrResource);
			response.setSenior(srResource);
		} else if (leftRoomCount % srCapacity == 0) {
			srResource = srResource + (leftRoomCount / srCapacity);
			response.setJunior(jrResource);
			response.setSenior(srResource);
		} else if (leftRoomCount % jrCapacity == 0) {
			jrResource = leftRoomCount / jrCapacity;
			response.setJunior(jrResource);
			response.setSenior(srResource);
		} else {
			allocateSrOrJr(response, srResource, leftRoomCount, srCapacity, jrCapacity, jrResource);
		}
		return response;
	}

	private void allocateSrOrJr(OutputDTO response, int srResource, int leftRoomCount, int srCapacity, int jrCapacity,
			int jrResource) {

		if (leftRoomCount % srCapacity != 0) {
			float a = (float) leftRoomCount / srCapacity;
			int intPart = (int) a;
			float decimalPart = ((a - intPart) * 10);

			srResource = srResource + intPart;

			if ((decimalPart != 0) && (decimalPart <= jrCapacity))
				jrResource = jrResource + 1;
			else
				jrResource = (int) Math.ceil(decimalPart / jrCapacity);

			response.setJunior(jrResource);
			response.setSenior(srResource);

		} else {
			float a = (float) leftRoomCount / jrCapacity;
			int intPart = (int) a;
			float decimalPart = ((a - intPart) * 10);

			jrResource = jrResource + intPart;

			if ((decimalPart != 0) && (decimalPart <= jrCapacity))
				jrResource = jrResource + 1;
			else
				jrResource = (int) Math.ceil(decimalPart / jrCapacity);

			response.setJunior(jrResource);
			response.setSenior(srResource);
		}

	}

}
