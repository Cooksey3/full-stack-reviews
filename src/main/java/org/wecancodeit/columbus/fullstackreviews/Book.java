package org.wecancodeit.columbus.fullstackreviews;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {

	@Id
	@GeneratedValue
	private long id;
	private String title;
	private String image;

	@Lob
	private String description;

	@OneToMany(mappedBy = "book")
	private Collection<Comment> comments;

	public Collection<Comment> getComments() {
		return comments;
	}

	@JsonIgnore
	@ManyToOne
	private Genre genre;

	public String getDescription() {
		return description;
	}

	public Genre getGenre() {
		return genre;
	}

	@SuppressWarnings("unused")
	private Book() {
	}

	public Book(String title, String image, String description, Genre genre) {
		this.title = title;
		this.description = description;
		this.genre = genre;
		this.image = image;
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

	@ManyToMany(mappedBy = "books")
	private Collection<Tag> tags;

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

}
