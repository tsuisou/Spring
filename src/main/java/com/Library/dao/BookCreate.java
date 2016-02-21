package com.Library.dao;

import java.util.List;

import com.Library.model.Book;

public interface BookCreate {

	List<Book> list();
	Book getBookById(String id);
	void addBook(Book book);
	List<Book> getBookByCategory(String category);
	List<Book> getBookByTitle(String title);
}
