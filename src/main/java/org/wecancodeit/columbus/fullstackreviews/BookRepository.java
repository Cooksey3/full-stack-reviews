package org.wecancodeit.columbus.fullstackreviews;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}