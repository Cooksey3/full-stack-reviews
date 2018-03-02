package org.wecancodeit.columbus.fullstackreviews;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Genre {

	@Id
	@GeneratedValue
	private long id;
	private String genre;

	@SuppressWarnings("unused")
	private Genre() {
		
	}
	
	public Genre(String genre) {
		this.genre = genre;
	}

	public long getId() {
		return id;
	}

	public String getGenre() {
		return genre;
	}

}
