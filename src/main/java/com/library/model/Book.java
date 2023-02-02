package com.library.model;

public class Book {

	private int bookID;
	private String bookName;
	private String author;
	private int quntity;
	private int totalBook;

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getQuntity() {
		return quntity;
	}

	public void setQuntity(int quntity) {
		this.quntity = quntity;
	}

	public int getTotalBook() {
		return totalBook;
	}

	public void setTotalBook(int totalBook) {
		this.totalBook = totalBook;
	}

	@Override
	public String toString() {
		return "Book ID = " + bookID + ", Book Name = " + bookName + ", Author = " + author + ", Quntity = " + quntity;

	}

}
