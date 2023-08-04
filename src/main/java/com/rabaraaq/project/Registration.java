package com.rabaraaq.project;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="registrations")
public class Registration{
	
	@Id
	public String id;
	public String event_id, customer_id, registration_date, notes;

	public Registration() {}
	
	public Registration(String eventId, String customerId, String registrationDate, String notes) {
		event_id = eventId;
		customer_id = customerId;
		registration_date = registrationDate;
		this.notes = notes;
	}
	
}
