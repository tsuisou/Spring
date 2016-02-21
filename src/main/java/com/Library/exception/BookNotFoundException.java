package com.Library.exception;

public class BookNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -694354952032299587L;
	
	private String id;

	public BookNotFoundException(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

}
