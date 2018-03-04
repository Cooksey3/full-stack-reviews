package org.wecancodeit.columbus.fullstackreviews;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private long id;
	private String tag;

	@SuppressWarnings("unused")
	private Tag() {
	}

	@ManyToMany(mappedBy = "tags")
	private Collection<Book> books;

	public Tag(String tag) {
		this.tag = tag;
	}

	public long getId() {
		return id;
	}

	public String getTag() {
		return tag;
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
		return id == ((Tag) obj).id;
	}

	public Collection<Book> getBooks() {
		return books;
	}

}
