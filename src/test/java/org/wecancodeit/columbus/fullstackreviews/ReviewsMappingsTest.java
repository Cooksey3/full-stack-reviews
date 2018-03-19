package org.wecancodeit.columbus.fullstackreviews;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewsMappingsTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private CommentRepository commentRepo;
	
	@Resource
	private BookRepository bookRepo;

	@Resource
	private GenreRepository genreRepo;

	@Resource
	private TagRepository tagRepo;

	@Test
	public void shouldSaveAndLoadBook() {
		Book book = new Book("LOTR", null, null, null);
		book = bookRepo.save(book);

		long bookId = book.getId();

		entityManager.flush();
		entityManager.clear();

		book = bookRepo.findOne(bookId);

		assertThat(book.getTitle(), is("LOTR"));
	}

	@Test
	public void shouldSaveAndLoadTags() {
		Tag tag = new Tag("Fun read");
		tag = tagRepo.save(tag);
		long tagId = tag.getId();

		entityManager.flush();
		entityManager.clear();

		tag = tagRepo.findOne(tagId);
		assertThat(tag.getTag(), is("Fun read"));
	}

	@Test
	public void shouldSaveAndLoadGenre() {
		Genre genre = genreRepo.save(new Genre("Fiction"));
		long genreId = genre.getId();

		entityManager.flush();
		entityManager.clear();

		genre = genreRepo.findOne(genreId);
		assertThat(genre.getGenre(), is("Fiction"));
	}

	@Test
	public void shouldGenerateGenreId() {
		Genre genre = genreRepo.save(new Genre("Fiction"));
		long genreId = genre.getId();

		entityManager.flush();

		genre = genreRepo.findOne(genreId);
		assertThat(genreId, is(greaterThan(0L)));
	}

	@Test
	public void shouldSaveGenreToBookRelationship() {
		Genre genre = genreRepo.save(new Genre("Fiction"));
		long genreId = genre.getId();

		Book book1 = bookRepo.save(new Book("LOTR", null, null, genre));

		Book book2 = bookRepo.save(new Book("The Hobbit", null, null, genre));

		entityManager.flush();
		entityManager.clear();

		genre = genreRepo.findOne(genreId);
		assertThat(genre.getBooks(), containsInAnyOrder(book1, book2));
	}

	@Test
	public void shouldSaveTagToBookRelationship() {
		Tag tag = tagRepo.save(new Tag("Fiction"));
		long tagId = tag.getId();

		Book book1 = bookRepo.save(new Book("LOTR", null, null, null));

		Book book2 = bookRepo.save(new Book("The Hobbit", null, null, null));

		entityManager.flush();
		entityManager.clear();

		tag = tagRepo.findOne(tagId);
		assertThat(tag.getBooks(), containsInAnyOrder(book1, book2));
	}

	@Test
	public void bookShouldHaveMultipleTags() {
		Tag fun = tagRepo.save(new Tag("Fun"));
		Tag boring = tagRepo.save(new Tag("Boring"));

		Book book = bookRepo.save(new Book("LOTR", null, null, null));
		long lotrId = book.getId();

		entityManager.flush();
		entityManager.clear();

		book = bookRepo.findOne(lotrId);
		assertThat(book.getTags(), containsInAnyOrder(fun, boring));
	}

	@Test
	public void bookShouldHaveAllInfo() {
		Tag tag1 = tagRepo.save(new Tag("Fun"));
		Tag tag2 = tagRepo.save(new Tag("Gripping"));
		Genre genre = genreRepo.save(new Genre("Fiction"));
		Book book = bookRepo.save(new Book("LOTR", "Good book", null, genre));

		entityManager.flush();
		entityManager.clear();

		assertThat(book.getTags(), containsInAnyOrder(tag1, tag2));
		assertThat(book.getGenre(), is(genre));
		assertThat(book.getDescription(), is("Good book"));
		assertThat(book.getTitle(), is("LOTR"));
	}
	
	@Test
	public void removeTagShouldRemoveTag() {
		Tag fun = tagRepo.save(new Tag("Fun"));
		Tag boring = tagRepo.save(new Tag("Boring"));
		Tag exciting = tagRepo.save(new Tag("Exciting"));
		
		Book book = bookRepo.save(new Book("LOTR", null, null, null));
		long lotrId = book.getId();
		
		entityManager.flush();
		entityManager.clear();

		book = bookRepo.findOne(lotrId);
		assertThat(book.getTags(), containsInAnyOrder(fun, exciting));
		assertThat(book.getTags(), not(hasItem(boring)));
	}
}