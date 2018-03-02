package org.wecancodeit.columbus.fullstackreviews;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue
	private long id;
	private String title;
	
	@SuppressWarnings("unused")
	private Book() {
	}
	
	public Book(String title) {
		this.title = title;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

}
