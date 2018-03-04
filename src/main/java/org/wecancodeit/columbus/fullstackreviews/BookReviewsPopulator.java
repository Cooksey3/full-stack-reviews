package org.wecancodeit.columbus.fullstackreviews;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;

public class BookReviewsPopulator implements CommandLineRunner {

	@Resource
	private BookRepository bookRepo;
	
	@Resource
	private GenreRepository genreRepo;
	
	@Resource
	private TagRepository tagRepo;
	
	@Override
	public void run(String...args) throws Exception {
		
	}
	
}
