package org.wecancodeit.columbus.fullstackreviews;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Genre {

	@Id
	@GeneratedValue
	private long id;
	private String genre;

	@OneToMany(mappedBy = "genre")
	private Collection<Book> books;

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

	public Collection<Book> getBooks() {
		return books;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genre other = (Genre) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
