package org.wecancodeit.columbus.fullstackreviews;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FullStackReviewsApplicationTests {

	@Resource
	private TestEntityManager entityManager;
	
	@Resource BookRepository bookRepo;
	
	@Test
	public void contextLoads() {
	}

}
