package com.Library.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.Library.dao.BookCreate;
import com.Library.model.Book;

@Repository
public class BookCreateImpl implements BookCreate {

	List<Book> list = new ArrayList<Book>();

	public BookCreateImpl() {
		Book thePragmaticProgrammer = new Book("The Pragmatic Programmer", "Andrew", "Hunt");
		thePragmaticProgrammer.setId("A1");
		thePragmaticProgrammer.setCategory("Programming");
		Book cleanCode = new Book("Clean Code", "Robert", "Martin");
		cleanCode.setId("A2");
		cleanCode.setCategory("Programming");
		list.add(thePragmaticProgrammer);
		list.add(cleanCode);
	}

	@Override
	public List<Book> list() {
		return list;
	}

	@Override
	public Book getBookById(String id) {
		Book bookById = null;

		for (Book book : list) {
			if (book != null && book.getId().equals(id)) {
				bookById = book;
				break;
			}
		}

		if (bookById == null) {
			throw new IllegalArgumentException("Brak produktu o wskazanym id: " + id);
		}
		return bookById;
	}

	@Override
	public void addBook(Book book) {
		list.add(book);
	}

	@Override
	public List<Book> getBookByCategory(String category) {
		List<Book> listBookByCategory = new ArrayList<Book>();

		for (Book book : list) {
			if (category.equalsIgnoreCase(book.getCategory())) {
				listBookByCategory.add(book);
			}
		}
		return listBookByCategory;
	}

	@Override
	public List<Book> getBookByTitle(String title) {
		List<Book> listBookByTitle = new ArrayList<Book>();

		for (Book book : list) {
			if (title.equalsIgnoreCase(book.getTitle())) {
				listBookByTitle.add(book);
			}
		}
		return listBookByTitle;

	}

}
