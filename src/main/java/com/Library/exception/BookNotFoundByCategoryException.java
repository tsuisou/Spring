package com.Library.exception;

public class BookNotFoundByCategoryException extends RuntimeException{

	private static final long serialVersionUID = -694354952032299587L;
	
	private String category;

	public BookNotFoundByCategoryException(String category) {
		this.category = category;
	}
	
	public String getCategory() {
		return category;
	}

}
