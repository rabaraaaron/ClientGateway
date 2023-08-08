package com.rabaraaq.project;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Transactional
@CrossOrigin
@RequestMapping("/api/customers")
public class CustomerClientGateway {
	
	@GetMapping
	public List<Customer> getAll() {
		RestTemplate rt = new RestTemplate();
		List customers = rt.getForObject("http://localhost:8012/api/customers", List.class);
		return customers;
	}
	
	@PostMapping
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
		RestTemplate rt = new RestTemplate();
		rt.postForObject("http://localhost:8012/api/customers", customer, ResponseEntity.class);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id}")
	public Customer getById(@PathVariable String id) {
		RestTemplate rt = new RestTemplate();
		Customer customer = rt.getForObject("http://localhost:8012/api/customers/" + id, Customer.class);
		return customer;	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) throws URISyntaxException {
		RestTemplate rt = new RestTemplate();
		String uri = "http://localhost:8012/api/customers/" + customer.getId();
		rt.put(uri, customer);
		return ResponseEntity.created(new URI(uri)).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable String id) throws URISyntaxException {
		RestTemplate rt = new RestTemplate();
		String uri = "http://localhost:8012/api/customers/" + id;
		rt.delete(uri);
		return ResponseEntity.created(new URI(uri)).build();
	}
	
	@GetMapping("/byname/{name}")
	public Customer getByName(@PathVariable String name) {
		RestTemplate rt = new RestTemplate();
		Customer customer = rt.getForObject("http://localhost:8012/api/customers/byname/" + name, Customer.class);
		return customer;	
	}
	
	@PostMapping("/byname")
	public ResponseEntity<?> getByNamePost(@RequestBody Customer customer) {
		RestTemplate rt = new RestTemplate();
		rt.postForObject("http://localhost:8012/api/customers", customer, ResponseEntity.class);
		return ResponseEntity.ok().build();
		
	}
}

