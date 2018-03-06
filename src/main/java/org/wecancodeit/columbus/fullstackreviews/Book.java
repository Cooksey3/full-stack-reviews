package org.wecancodeit.columbus.fullstackreviews;

import static java.util.Arrays.asList;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Book {

	@Id
	@GeneratedValue
	private long id;
	private String title;
	private String image;

	@Lob
	private String description;

	@ManyToOne
	private Genre genre;

	@ManyToMany
	private Collection<Tag> tags;

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

	public Book(String title, Tag... tags) {
		this.title = title;
		this.tags = new HashSet<>(asList(tags));
	}

	public Book(String title, String description, Genre genre, Tag... tags) {
		this.title = title;
		this.description = description;
		this.genre = genre;
		this.tags = new HashSet<>(asList(tags));
	}

	public Book(String title, String image, String description, Genre genre, Tag... tags) {
		this.title = title;
		this.description = description;
		this.genre = genre;
		this.image = image;
		this.tags = new HashSet<>(asList(tags));
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getImage() {
		return image;
	}

	public Collection<Tag> getTags() {
		return tags;
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

	public String getDescription() {
		return description;
	}
}
