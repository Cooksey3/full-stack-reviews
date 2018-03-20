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
	public Book deleteTagFromThisBook(Long bookId, Long tagId) {
		Book targetBook = bookRepo.findOne(bookId);
		Tag thisTag = tagRepo.findOne(tagId);
		thisTag.deleteBook(targetBook);
		tagRepo.save(thisTag);

		return targetBook;
	}
	
	@RequestMapping("/add-tag")
	public Book addTagToBook(Long bookId, String addTag) {
		Book targetBook = bookRepo.findOne(bookId);
		if (tagRepo.findByTag(addTag) != null) {
			Tag newTag = new Tag(addTag, targetBook);
			newTag.addBook(targetBook);
			return targetBook;
		}
		
		Tag newTag = new Tag(addTag);
		tagRepo.save(newTag);
		newTag.addBook(targetBook);
		tagRepo.save(newTag);
		
		return targetBook;
	}
	
}
