package org.wecancodeit.columbus.fullstackreviews;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookReviewsController {

	@Resource
	BookRepository bookRepo;

	@Resource
	GenreRepository genreRepo;

	@Resource
	TagRepository tagRepo;

	@RequestMapping("/home")
	public String getAllGenres(Model model) {
		model.addAttribute("genresModel", genreRepo.findAll());
		model.addAttribute("tagsModel", tagRepo.findAll());
		return "homeView";
	}

	@RequestMapping("/genre")
	public String getOneGenre(@RequestParam Long id, Model model) {
		Genre genre = genreRepo.findOne(id);
		model.addAttribute("booksModel", bookRepo.findByGenre_id(id));
		model.addAttribute("genreModel", genre);
		return "genreView";
	}

	@RequestMapping("/tag")
	public String getTag(@RequestParam Long id, Model model) {
		Tag tag = tagRepo.findOne(id);
		model.addAttribute("tagModel", tag);
		return "tagView";
	}

	@RequestMapping("/book")
	public String getOneBook(@RequestParam Long id, Model model) {
		model.addAttribute("bookModel", bookRepo.findOne(id));
		return "bookView";
	}
}
