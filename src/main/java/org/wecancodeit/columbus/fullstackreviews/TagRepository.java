package org.wecancodeit.columbus.fullstackreviews;

import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long> {

	public Tag findByTag(String tag);

}
