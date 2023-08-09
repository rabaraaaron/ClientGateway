package com.rabaraaq.project;

public class Event {

	private String id;
	private String code, title, description;

	public Event() {
	}

	public Event(String code, String title, String description) {
		super();
		this.code = code;
		this.title = title;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Events [id=" + id + ", code=" + code + ", title=" + title + ", description=" + description + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
