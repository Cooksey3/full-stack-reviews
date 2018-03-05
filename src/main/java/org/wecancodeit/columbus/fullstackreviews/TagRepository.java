package org.wecancodeit.columbus.fullstackreviews;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long> {

	// List<Tag> findByBook_id(Long book_id);

}
