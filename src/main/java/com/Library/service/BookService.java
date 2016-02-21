package com.Library.service;

import java.util.List;

import com.Library.model.Book;

public interface BookService {

	List<Book> listBook();
	Book getBookById(String id);
	void addBook(Book book);
	List<Book> getBookByCategory(String category);
	List<Book> getBookByTitle(String title);
}
