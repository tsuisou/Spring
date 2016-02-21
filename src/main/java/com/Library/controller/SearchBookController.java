package com.Library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Library.exception.BookNotFoundByCategoryException;
import com.Library.model.Book;
import com.Library.service.BookService;

@Controller
@RequestMapping("collection")
public class SearchBookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public String createForm(@ModelAttribute("formSearch") Book book){
		return "BookSearch";
	}
	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public String search(@ModelAttribute("formSearch") Book book){
		if (book.getTitle() != null && !book.getTitle().isEmpty()){
			return "redirect:/collection/title/" + book.getTitle();
		}else{
		return "redirect:/collection/category/" + book.getCategory();
		}
	}
	
	@RequestMapping(value="/category/{category}")
	public String findBookByCategory(@PathVariable("category") String category,Model model){
		List<Book> list = bookService.getBookByCategory(category);
		if (list.isEmpty() || list == null){
			throw new BookNotFoundByCategoryException(category);
		}
		model.addAttribute("book", list);
		return "books";
	}
	
	@RequestMapping(value="/title/{title}")
	public String findBookByTitle(@PathVariable("title") String title,Model model){
		List<Book> list = bookService.getBookByTitle(title);
		if (list.isEmpty() || list == null){
			throw new RuntimeException("Brak takiego tytułu");
		}
		model.addAttribute("book", list);
		return "books";
	}
	
	@ExceptionHandler(BookNotFoundByCategoryException.class)
	public ModelAndView handleError() {
		 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.setViewName("bookNotFound");
		 return modelAndView;
	}

}
