package org.wecancodeit.columbus.fullstackreviews;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewsMappingsTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private BookRepository bookRepo;

//	@Resource
//	private GenreRepository genreRepo;

	@Resource
	private TagRepository tagRepo;

	@Test
	public void shouldSaveAndLoadBook() {
		Book book = new Book("LOTR");
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
	
//	@Test
//	public void shouldSaveAndLoadCategore() {
//		Genre fiction = new Genre("Fiction");
//		fiction = genreRepo.save(fiction);
//		
//	}
	
	
}