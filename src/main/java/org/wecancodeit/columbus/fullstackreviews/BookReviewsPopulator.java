package org.wecancodeit.columbus.fullstackreviews;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BookReviewsPopulator implements CommandLineRunner {

	@Resource
	private BookRepository bookRepo;

	@Resource
	private GenreRepository genreRepo;

	@Resource
	private TagRepository tagRepo;

	@Override
	public void run(String... args) throws Exception {

		Genre fiction = genreRepo.save(new Genre("Fiction"));
		Genre nonFiction = genreRepo.save(new Genre("Non-fiction"));
		Tag thriller = tagRepo.save(new Tag("Thriller"));
		Tag action = tagRepo.save(new Tag("Action"));
		Tag fantasy = tagRepo.save(new Tag("Fantasy"));
		bookRepo.save(new Book("The Lord of the Rings", "A thrilling fantasy trilogy fill with peril and sacrifice",
				fiction, action, fantasy));
		bookRepo.save(new Book("Marine Sniper: 93 Confirmed Kills",
				"The true story of America's most successful sniper", nonFiction, action, thriller));
	}

}
