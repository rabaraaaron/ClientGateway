package com.rabaraaq.project;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
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
@CrossOrigin
@RequestMapping("/api/registrations")
public class RegistrationClientGateway {
	
	@Value("${app.url.registration}")
	private String url;

	@GetMapping("")
	public List<Registration> getAll() {
		List registrations = (new RestTemplate()).getForObject(url + "/api/registrations", List.class);
		return registrations;
	}
	
	@GetMapping("/{id}")
	public Registration getById(@PathVariable(value = "id") String id) {
		Registration registration = (new RestTemplate()).getForEntity(url + "/api/registrations/" + id, Registration.class).getBody();
		return registration;
	}
	
	@PostMapping("")
	public ResponseEntity<?> createRegistration(@RequestBody Registration reg) {
		return (new RestTemplate()).postForObject(url + "/api/registrations", reg, ResponseEntity.class);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> createOrUpdateRegistration(@PathVariable(value = "id") String id, @RequestBody Registration reg) throws URISyntaxException {
		String uri = url + "/api/registrations/";
		(new RestTemplate()).put(uri + id, reg);
		return ResponseEntity.created(new URI(uri + id)).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable(value = "id") String id) throws URISyntaxException {
		String uri = url + "/api/registrations/";
		(new RestTemplate()).delete(uri + id);
		return ResponseEntity.created(new URI(uri + id)).build();
	}
}
