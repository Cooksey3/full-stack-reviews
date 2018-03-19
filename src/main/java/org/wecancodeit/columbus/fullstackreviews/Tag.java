package org.wecancodeit.columbus.fullstackreviews;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import static java.util.Arrays.asList;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private long id;
	private String tag;

	@ManyToMany
	private Collection<Book> books;

	public Collection<Book> getBooks() {
		return books;
	}

	public long getId() {
		return id;
	}

	public String getTag() {
		return tag;
	}

	@SuppressWarnings("unused")
	private Tag() {
	}

	public Tag(String tag, Book... books) {
		this.tag = tag;
		this.books = new HashSet<>(asList(books));
	}

	public void deleteBook(Book book) {
		books.remove(book);
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
}