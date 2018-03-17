package org.wecancodeit.columbus.fullstackreviews;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

	@Id
	@GeneratedValue
	private Long id;
	private String comment;

	public Comment() {
	}

	public Comment(String comment, Book book) {
		this.comment = comment;
		this.book = book;
	}

	@ManyToOne
	private Book book;

	public Book getCommentBook() {
		return book;
	}

	public Long getId() {
		return id;
	}

	public String getComment() {
		return comment;
	}

	public Book getBook() {
		return book;
	}
}
