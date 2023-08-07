package com.rabaraaq.project;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EventClientGateway {

	@GetMapping("/api/events")
	public List<Event> getAll() {
		RestTemplate rt = new RestTemplate();
		List events = rt.getForObject("http://localhost:8011/events", List.class);
		System.out.println(events);
		return events;
	}

	@GetMapping("/api/events/{id}")
	public Event getById(@PathVariable String id) {
		RestTemplate rt = new RestTemplate();
		Event events = rt.getForObject("http://localhost:8011/events/" + id, Event.class);
		System.out.println(events);
		return events;
	}
	
	@DeleteMapping("/api/events/{id}")
	public void deleteById(@PathVariable String id) {
		RestTemplate rt = new RestTemplate();
		rt.delete("http://localhost:8011/events/" + id);
	}

	@PutMapping("/api/events/{id}")
	public Event updateEvent(@PathVariable String id, @RequestBody Event events) {
		RestTemplate rt = new RestTemplate();
		HttpEntity<Event> eventRequest = new HttpEntity<>(events);
		Event event = rt.postForObject("http://localhost:8011/events/", eventRequest, Event.class);
		return event;
	}
		
//		Event events = rt.put("http://localhost:8011/events/" + id, Event.class);
//		System.out.println(events);
//		return events;
	
	
//	@PostMapping("/api/events/{id}")
//	public Event createEvent (@PathVariable String id, @RequestBody Event events) {
//		RestTemplate rt = new RestTemplate();
//		Event events = rt.postForObject("http://localhost:8011/events/" + id, Event.class);
//		return events;
//	}
	
}
