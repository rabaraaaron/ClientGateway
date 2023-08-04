package com.rabaraaq.project;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.websocket.server.PathParam;

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
@RequestMapping("/api/registrations")
public class RegistrationClientGateway {

	@GetMapping("")
	public List<Registration> getAll() {
		List registrations = (new RestTemplate()).getForObject("http://localhost:7777/api/registrations", List.class);
		return registrations;
	}
	
	@GetMapping("/{id}")
	public Registration getById(@PathVariable(value = "id") String id) {
		Registration registration = (new RestTemplate()).getForEntity("http://localhost:7777/api/registrations/" + id, Registration.class).getBody();
		return registration;
	}
	
	@PostMapping("")
	public ResponseEntity<?> createRegistration(@RequestBody Registration reg) {
		return (new RestTemplate()).postForObject("http://localhost:7777/api/registrations", reg, ResponseEntity.class);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> createOrUpdateRegistration(@PathVariable(value = "id") String id, @RequestBody Registration reg) throws URISyntaxException {
		String uri = "http://localhost:7777/api/registrations/";
		(new RestTemplate()).put(uri + id, reg);
		return ResponseEntity.created(new URI(uri + id)).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable(value = "id") String id) throws URISyntaxException {
		String uri = "http://localhost:7777/api/registrations/";
		(new RestTemplate()).delete(uri + id);
		return ResponseEntity.created(new URI(uri + id)).build();
	}
}
