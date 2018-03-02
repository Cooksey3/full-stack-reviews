package org.wecancodeit.columbus.fullstackreviews;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private long id;
	private String tag;

	@SuppressWarnings("unused")
	private Tag() {
		
	}
	
	public Tag(String tag) {
		this.tag = tag;
	}

	public long getId() {
		return id;
	}

	public String getTag() {
		return tag;
	}

}
