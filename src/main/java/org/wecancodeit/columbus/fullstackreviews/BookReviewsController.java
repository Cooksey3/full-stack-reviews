package org.wecancodeit.columbus.fullstackreviews;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookReviewsController {

	@Resource
	BookRepository bookRepo;
	
	@Resource
	GenreRepository genreRepo;
	
	@RequestMapping("/genres")
	public String getAllBooks(Model model) {
		model.addAttribute("genresModel", bookRepo.findAll());
		return "genresView";
	}
	
}
