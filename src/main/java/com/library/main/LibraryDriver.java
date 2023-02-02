package com.library.main;

import java.util.Scanner;

import com.library.service.AddBookService;
import com.library.service.RegistrationService;
import com.library.serviceImpl.BookImpl;
import com.library.serviceImpl.LoginService;

public class LibraryDriver {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		RegistrationService loginReg = new LoginService();
		AddBookService addBook = new BookImpl();

		while (true) {

			System.out.println("1. Login \n2. Registration User \n3. Exit ");
			System.out.println("Select option = ");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:

				int flag = loginReg.checkLogin();
				if (flag == 0) {
					System.err.println("Invalid Credential...");
					break;
				}

				if (flag == 1) {
					int ch1 = 0;
					System.out.println("\t----Admin Portal----");
					while (ch1 != 1) {

						System.out.println(
								"\t1.Add Book =  \n\t2.Display All Book = \n\t3.Search Book  = \n\t4.Update Book = \n\t5.Check Book Status = \n\t6.Delete Book = "
										+ "\n\t7.Logout = ");
						System.out.println("Enter Your Choice = ");
						int cha = sc.nextInt();
						switch (cha) {
						case 1:
							addBook.addBook();
							break;
						case 2:
							addBook.displayBook();
							break;
						case 3:
							addBook.searchBook();
							break;
						case 4:
							addBook.updateInformation();
							break;
						case 5:
							addBook.checkBookStatus();
							break;
						case 6:
							addBook.deleteBook();
							break;
						case 7:
							ch1++;
							break;
						default:
							System.out.println("Wrong input");
						}
					}
				}

				if (flag == 2) {
					int ch1 = 0;
					while (ch1 != 1) {

						System.out.println(
								"\t1.Search Book  =  \n\t2.Get Book = \n\t3.Show Book = \n\t4.Update Information = \n\t5.Return Book =\n\t6.Logout = ");
						System.out.println("Enter Your Choice = ");
						int cha = sc.nextInt();
						switch (cha) {
						case 1:
							addBook.searchBook();
							break;
						case 2:
							addBook.getBook();
							break;
						case 3:
							addBook.showGetBook();
							break;
						case 4:
							addBook.updateCustomerDetails();
							break;
						case 5:
							addBook.returnBook();
							break;
						case 6:
							ch1++;
							break;
						default:
							System.out.println("Wrong input");
						}

					}
				}
				break;

			case 2:
				loginReg.registration();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Enter vaild input");
				break;
			}

		}
	}
}
