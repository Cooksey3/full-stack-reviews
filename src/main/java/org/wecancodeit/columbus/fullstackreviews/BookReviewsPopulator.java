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

		Book lotr = bookRepo.save(new Book("The Lord of the Rings", "/images/lordoftherings.png",
				"A thrilling fantasy trilogy filled with peril and sacrifice, featuring a well-ordered fantasy world. Tolkien's finest work.",
				fiction));
		Book sniper = bookRepo.save(new Book("Marine Sniper: 93 Confirmed Kills", "/images/marinesniper.png",
				"The true story of America's deadliest sniper during the Vietnam War", nonFiction));
		Book harryPotter = bookRepo.save(new Book("The Harry Potter Series", "/images/harrypotter.png",
				"Great series. Rowling does a fantastic job of creating a fantasy world with remarkable consistency. The characters are well developed, wich great tension throughout.",
				fiction));

		Tag adventure = tagRepo.save(new Tag("Adventure", lotr, harryPotter));
		Tag thriller = tagRepo.save(new Tag("Thriller", lotr, sniper));
		Tag action = tagRepo.save(new Tag("Action", harryPotter, lotr));
		Tag fantasy = tagRepo.save(new Tag("Fantasy", lotr, harryPotter));
		
		tagRepo.save(adventure);
		tagRepo.save(action);
		tagRepo.save(thriller);
		tagRepo.save(fantasy);

	}

}
