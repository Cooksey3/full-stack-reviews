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

		Tag adventure = tagRepo.save(new Tag("Adventure"));
		Tag thriller = tagRepo.save(new Tag("Thriller"));
		Tag action = tagRepo.save(new Tag("Action"));
		Tag fantasy = tagRepo.save(new Tag("Fantasy"));

		bookRepo.save(new Book("The Lord of the Rings", "/images/lordoftherings.png",
				"A thrilling fantasy trilogy filled with peril and sacrifice, featuring a well-ordered fantasy world. Tolkien's finest work.",
				fiction, action, fantasy, adventure));
		bookRepo.save(new Book("Marine Sniper: 93 Confirmed Kills", "/images/marinesniper.png",
				"The true story of America's deadliest sniper during the Vietnam War", nonFiction, action, thriller));
		bookRepo.save(new Book("The Harry Potter Series", "/images/harrypotter.png",
				"Great series. Rowling does a fantastic job of creating a fantasy world with remarkable consistency. The characters are well developed, wich great tension throughout.",
				fiction, action, fantasy));
	}

}
