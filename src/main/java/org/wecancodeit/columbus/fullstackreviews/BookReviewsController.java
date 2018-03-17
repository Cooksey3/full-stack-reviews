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

	@Resource
	CommentRepository commentRepo;

	@RequestMapping("/home")
	public String getAllGenres(Model model) {
		model.addAttribute("genresModel", genreRepo.findAll());
		model.addAttribute("tagsModel", tagRepo.findAll());
		return "homeView";
	}

	@RequestMapping(value = "tags")
	public String getAllTags(Model model) {
		model.addAttribute("tags", tagRepo.findAll());
		return "tagsView";
	}

	@RequestMapping("/book")
	public String getOneBook(@RequestParam Long id, Model model) {
		model.addAttribute("book", bookRepo.findOne(id));
		return "bookView";
	}

	@RequestMapping("/tag")
	public String getOneTag(@RequestParam Long id, Model model) {
		Tag tag = tagRepo.findOne(id);
		model.addAttribute("booksModel", bookRepo.findByTags_id(id));
		model.addAttribute("tagModel", tag);
		return "tagView";
	}

	@RequestMapping("/genre")
	public String getOneGenre(@RequestParam Long id, Model model) {
		Genre genre = genreRepo.findOne(id);
		model.addAttribute("booksModel", bookRepo.findByGenre_id(id));
		model.addAttribute("genreModel", genre);
		return "genreView";
	}

	@RequestMapping("/add-comment")
	public String addComment(Long bookId, String comment) {
		Book targetBook = bookRepo.findOne(bookId);
		Comment newComment = new Comment(comment, targetBook);
		commentRepo.save(newComment);
		return "redirect:/book?id=" + bookId;
	}
	
	@RequestMapping("/delete-tag")
	public String deleteTag(Long bookId, Long tagId) {
		Book targetBook = bookRepo.findOne(bookId);
		Tag targetTag = tagRepo.findOne(tagId);
		targetBook.removeTag(targetTag);
		bookRepo.save(targetBook);
		return "redirect:/book?id=" + bookId;
	}
}