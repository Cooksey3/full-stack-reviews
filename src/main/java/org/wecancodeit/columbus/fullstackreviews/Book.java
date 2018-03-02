package org.wecancodeit.columbus.fullstackreviews;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book {

	@Id
	@GeneratedValue
	private long id;
	private String title;

	@ManyToOne
	private Genre genre;

	@SuppressWarnings("unused")
	private Book() {
	}

	public Genre getGenre() {
		return genre;
	}

	public Book(String title) {
		this.title = title;
	}

	public Book(String title, Genre genre) {
		this.title = title;
		this.genre = genre;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public int hashCode() {
		return ((Long) id).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		return id == ((Book) obj).id;
	}

}
