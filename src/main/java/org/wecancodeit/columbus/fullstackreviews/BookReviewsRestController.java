package org.wecancodeit.columbus.fullstackreviews;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookReviewsRestController {
	
	@Resource
	private BookRepository bookRepo;
	
	@Resource
	private TagRepository tagRepo;

	@RequestMapping("/remove-tag")
	public Book DeleteTagFromThisBook(Long bookId, Long tagId) {
		Book targetBook = bookRepo.findOne(bookId);
		Tag thisTag = tagRepo.findOne(tagId);
		thisTag.deleteBook(targetBook);
		tagRepo.save(thisTag);

		return targetBook;
	}
	
}
