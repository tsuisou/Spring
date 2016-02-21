package com.Library.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Library.model.Book;
import com.Library.service.BookService;

@Controller
@RequestMapping("collection")
public class BookController {
	
	@Autowired
	private BookService bookService;

	@RequestMapping(value="/all")
	public String listBook(Model model){
		model.addAttribute("book", bookService.listBook());
		return "books";
	}
	
	@RequestMapping(value="/book")
	public String getBookById(@RequestParam("id") String id, Model model) {
		if (id.isEmpty() || id == null){
			throw new RuntimeException("problem");
		}
		model.addAttribute("book", bookService.getBookById(id));
		return "book";
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addBook(@ModelAttribute("formBook") Book book){
		return "addBook";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String saveBook(@ModelAttribute("formBook") @Valid Book book,BindingResult result,HttpServletRequest request){
		System.out.println("czy jest błąd " + result.hasErrors());
		if (result.hasErrors()){
			return "addBook";
		}
//		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
//		MultipartFile multipart = book.getObrazek();
//		if (!multipart.isEmpty() && multipart != null){
//			try {
//				multipart.transferTo(new File(rootDirectory+"resources\\images\\"+book.getId() + ".jpg"));
//				System.out.println("name " + multipart.getName() + " id: " + book.getId());
//			} catch (IllegalStateException | IOException e) {
//				throw new RuntimeException("Problem z przesłaniem pliku");
//			}
//		}
		bookService.addBook(book);
		return "redirect:/collection/all";
	}

}
