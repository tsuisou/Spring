package com.Library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Library.dao.BookCreate;
import com.Library.model.Book;
import com.Library.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookCreate bookCreate;

	@Override
	public List<Book> listBook() {
		return bookCreate.list();
	}

	@Override
	public Book getBookById(String id) {
		return bookCreate.getBookById(id);
	}

	@Override
	public void addBook(Book book) {
		bookCreate.addBook(book);
	}

	@Override
	public List<Book> getBookByCategory(String category) {
		return bookCreate.getBookByCategory(category);
	}

	@Override
	public List<Book> getBookByTitle(String title) {
		return bookCreate.getBookByTitle(title);
	}

}
