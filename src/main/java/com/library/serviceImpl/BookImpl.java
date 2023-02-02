package com.library.serviceImpl;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.library.model.Book;
import com.library.model.Reader;
import com.library.service.AddBookService;
import com.library.service.RegistrationService;

public class BookImpl implements AddBookService {

	Scanner sc = new Scanner(System.in);
	LinkedHashSet<Book> booksList = new LinkedHashSet<>();
	LinkedHashSet<Reader> readerBookList = new LinkedHashSet<>();

	@Override
	public void addBook() {

		Book book = new Book();
		System.out.println("Enter book Id = ");
		int bId = sc.nextInt();
		book.setBookID(bId);

		System.out.println("Enter book Name = ");
		String bName = sc.next();
		book.setBookName(bName);

		System.out.println("Enter author Name = ");
		String aName = sc.next();
		book.setAuthor(aName);

		System.out.println("Enter quntity = ");
		int quntity = sc.nextInt();
		book.setTotalBook(quntity);
		book.setQuntity(quntity);

		boolean flag = false;

		if (booksList.isEmpty()) {
			booksList.add(book);
			flag = true;
			System.out.println("Book Added Successfully");
		}

		long count1 = booksList.stream().filter(a -> a.getBookID() == bId && !a.getBookName().equalsIgnoreCase(bName))
				.count();
		long count2 = booksList.stream().filter(a -> a.getBookID() == bId && a.getBookName().equalsIgnoreCase(bName))
				.count();

		if ((count1 == 1 || count2 == 1) && flag == false) {

			System.err.println("Book id alreday use or register");
		}

		if (count2 == 0 && count1 == 0) {

			booksList.add(book);
			System.out.println("Book Added Successfully");
		}

	}

	@Override
	public void displayBook() {

		System.out.println("------------------------------------------------");
		for (Book book : booksList) {

			System.out.println(book);
		}
		System.out.println("------------------------------------------------");

	}

	@Override
	public void updateInformation() {

		System.out.println("Enetr Book id = ");
		int id = sc.nextInt();

		boolean flag = booksList.stream().filter(a -> a.getBookID() == id).findAny().isPresent();

		if (flag == false) {
			System.err.println("Book not available");
			return;
		}

		System.out.println("1. Book Name = ");
		System.out.println("2. Author Name = ");
		System.out.println("3. Quntity = ");
		System.out.println("Enter Choice = ");
		int ch = sc.nextInt();

		Optional<Book> books = booksList.stream().filter(a -> a.getBookID() == id).findAny();

		if (ch == 1) {
			System.out.println("Enter book Name = ");
			String bName = sc.next();
			books.get().setBookName(bName);

		}

		if (ch == 2) {
			System.out.println("Enter author Name = ");
			String aName = sc.next();
			books.get().setAuthor(aName);
		}

		if (ch == 3) {
			System.out.println("Enter quntity = ");
			int quntity = sc.nextInt();
			books.get().setTotalBook(quntity);
			books.get().setQuntity(quntity);
		}

		booksList.add(books.get());
		System.out.println("Update Sucessfully.");

	}

	@Override
	public void deleteBook() {

		System.out.println("Enter Book Id = ");
		this.displayBook();
		int id = sc.nextInt();
		Optional<Book> book = booksList.stream().filter(a -> a.getBookID() == id).findAny();
		booksList.remove(book.get());
		System.out.println("Book Delete Successfully");

	}

	@Override
	public void searchBook() {

		System.out.println("Search book by..");
		System.out.println("1. Book Name = ");
		System.out.println("2. Author Name = ");
		System.out.println("Enter Choice = ");
		int ch = sc.nextInt();

		if (ch == 1) {
			System.out.println("Enter book Name = ");
			String bName = sc.next();
			Optional<Book> book = booksList.stream().filter(a -> a.getBookName().equalsIgnoreCase(bName)).findAny();

			if (book.isEmpty()) {
				System.err.println("Book not available..");
			}
			if (book.isPresent()) {
				System.out.println("------------------------------------------------");
				System.out.println("Book id = " + book.get().getBookID() + " , Book Name = " + book.get().getBookName()
						+ " , Author Name = " + book.get().getAuthor());
				System.out.println("------------------------------------------------");

			}
		}

		if (ch == 2) {

			System.out.println("Enter author Name = ");
			String aName = sc.next();
			List<Book> books = booksList.stream().filter(a -> a.getAuthor().equalsIgnoreCase(aName))
					.collect(Collectors.toList());
			if (books.isEmpty()) {
				System.err.println("Book not available..");
			}
			if (books.size() != 0) {
				System.out.println("-----------------------------------------------------");
				for (Book book : books) {
					System.out.println("Book id = " + book.getBookID() + " , Book Name = " + book.getBookName()
							+ " , Author Name = " + book.getAuthor());
				}
				System.out.println("-----------------------------------------------------");
			}
		}

	}

	@Override
	public void getBook() {

		Reader reader = new Reader();
		System.out.println("Enter Customer id Id = ");
		reader.setcId(sc.nextInt());

		System.out.println("Enter Name = ");
		String name = sc.next();
		reader.setName(name);

		System.out.println("Enter address Name = ");
		String address = sc.next();
		reader.setAddress(address);

		System.out.println("Enter book id = ");
		int id = sc.nextInt();

		Optional<Book> book = booksList.stream().filter(a -> a.getBookID() == id).findAny();

		if (book.isEmpty()) {

			System.err.println("Book not available");
		}

		if (book.get().getQuntity() == 0) {
			System.err.println("book not available or zero quantity");
			return;
		}

		int qu = book.get().getQuntity();
		book.get().setQuntity(qu - 1);
		LocalDate today = LocalDate.now();
		reader.setBook(book.get());
		reader.setIssueDate(today);
		reader.setReturnDate(today.plusDays(8));
		booksList.add(book.get());
		readerBookList.add(reader);
		System.out.println("Book Get Sucessfully...");

	}

	@Override
	public void showGetBook() {

		System.out.println("Enter customer id = ");
		int id = sc.nextInt();
		Optional<Reader> book = readerBookList.stream().filter(a -> a.getcId() == id).findAny();
		if (book.isEmpty())
			System.err.println("Book not available");
		if (book.isPresent()) {
			System.out.println("------------------------------------------------------");
			System.out.println("Customer Id      = " + book.get().getcId());
			System.out.println("Customer Name    = " + book.get().getName());
			System.out.println("Customer Address = " + book.get().getAddress());
			System.out.println("Book Id          = " + book.get().getBook().getBookID());
			System.out.println("Book Name        = " + book.get().getBook().getBookName());
			System.out.println("Author Name      = " + book.get().getBook().getAuthor());
			System.out.println("Issue Date       = " + book.get().getIssueDate());
			System.out.println("Return Date      = " + book.get().getReturnDate());
			System.out.println("------------------------------------------------------");
		}

	}

	@Override
	public void returnBook() {
		System.out.println("Enter Customer Id = ");
		int id = sc.nextInt();
		Optional<Reader> reader = readerBookList.stream().filter(a -> a.getcId() == id).findAny();
		if (reader.isEmpty())
			System.err.println("Customer not available");
		Optional<Book> book = booksList.stream().filter(a -> a.getBookID() == reader.get().getBook().getBookID())
				.findAny();
		book.get().setQuntity(book.get().getQuntity() + 1);
		readerBookList.remove(reader.get());
		booksList.add(book.get());
		System.out.println("Book Return Sucessfully...");

	}

	@Override
	public void checkBookStatus() {

		System.out.println("1. Check Book Status = ");
		System.out.println("2. Check How Many Book Issue =");
		System.out.println("Select Choice = ");
		int ch = sc.nextInt();

		if (ch == 1) {
			System.out.println("Enter book id = ");
			int id = sc.nextInt();
			List<Reader> book = readerBookList.stream().filter(a -> a.getBook().getBookID() == id)
					.collect(Collectors.toList());
			if (book.isEmpty())
				System.out.println("No reader available");
			if (book.size() != 0) {
				System.out.println("------------------------------------------------------");
				for (Reader reader : book) {
					System.out.println("Book Id = " + reader.getBook().getBookID() + " , Book Name = "
							+ reader.getBook().getBookName() + " , Customer Id = " + reader.getcId()
							+ " , Customer Name = " + reader.getName() + " , Customer Address = " + reader.getAddress()
							+ " , Issue Date = " + reader.getIssueDate() + " , Return Date = "
							+ reader.getReturnDate());
				}
				System.out.println("------------------------------------------------------");

			}
		}

		if (ch == 2) {

			System.out.println("Enter book id = ");
			int id = sc.nextInt();
			Optional<Book> book = booksList.stream().filter(a -> a.getBookID() == id).findAny();
			System.out.println("-----------------------------------------------------------------");
			System.out.println("Book Id = " + book.get().getBookID() + " , Book Name = " + book.get().getBookName()
					+ " , Issue Book Quntity = " + (book.get().getTotalBook() - book.get().getQuntity()));
			System.out.println("------------------------------------------------------------------");

		}
	}

	@Override
	public void updateCustomerDetails() {

		System.out.println(
				"\t1.Update Customer Name =  \n\t2.Update Address = \n\t3.Change Book = \n\t4.Change Password = ");
		System.out.println("Select Choice = ");
		int ch = sc.nextInt();
		Optional<Reader> reader = Optional.empty();

		if (ch == 4) {
			RegistrationService loginReg = new LoginService();
			loginReg.updatePassword();
		}

		if (ch == 1 || ch == 2 || ch == 3) {
			System.out.println("Enter Customer Id = ");
			int cid = sc.nextInt();
			reader = readerBookList.stream().filter(a -> a.getcId() == cid).findAny();
			if (reader.isEmpty()) {
				System.err.println("Customer not available");
				return;
			}
		}

		if (ch == 1) {
			System.out.println("Enter Name = ");
			String name = sc.next();
			reader.get().setName(name);
		}

		if (ch == 2) {
			System.out.println("Enter address Name = ");
			String address = sc.next();
			reader.get().setAddress(address);
		}

		if (ch == 3) {

			int bid = reader.get().getBook().getBookID();
			System.out.println("Enter book id = ");
			int id = sc.nextInt();

			Optional<Book> book = booksList.stream().filter(a -> a.getBookID() == id).findAny();
			Optional<Book> book1 = booksList.stream().filter(a -> a.getBookID() == bid).findAny();

			if (book.isEmpty()) {

				System.err.println("Book not available");
			}

			int qu = book.get().getQuntity();
			book.get().setQuntity(qu - 1);
			LocalDate today = LocalDate.now();

			reader.get().setBook(book.get());
			reader.get().setIssueDate(today);
			reader.get().setReturnDate(today.plusDays(8));

			book1.get().setQuntity(book1.get().getQuntity() + 1);
			booksList.add(book1.get());
			booksList.add(book.get());

		}
		if (reader.isPresent())
			readerBookList.add(reader.get());
		System.out.println("Update Sucessfully...");
	}

}
