package org.wecancodeit.columbus.fullstackreviews;

import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
