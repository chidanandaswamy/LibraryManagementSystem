package com.library.model;

import java.time.LocalDate;

public class Reader {

	private int cId;
	private String name;
	private String address;
	private LocalDate issueDate;
	private LocalDate returnDate;
	private Book book;

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Reader [cId=" + cId + ", name=" + name + ", address=" + address + ", issueDate=" + issueDate
				+ ", returnDate=" + returnDate + ", book=" + book + "]";
	}

}
