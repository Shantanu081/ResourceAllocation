package com.shantanu.productcatalogue.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.shantanu.productcatalogue.model.InputDTO;
import com.shantanu.productcatalogue.model.OutputDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductcatalogueApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@SuppressWarnings("unchecked")
	@Test
	public void testResourceAllocation() {
		InputDTO input = new InputDTO();
		List<Integer> rooms = new ArrayList<>();
		rooms.add(99);
		rooms.add(35);
		rooms.add(21);
		input.setRooms(rooms);
		input.setJunior(6);
		input.setSenior(10);

		List<OutputDTO> output = restTemplate.postForObject("/productcatalogue/getWorkforce", input, List.class);

		assertNotNull(output);
		assertEquals(output.toString(), "[{senior=9, junior=2}, {senior=3, junior=1}, {senior=2, junior=1}]");

	}
}
