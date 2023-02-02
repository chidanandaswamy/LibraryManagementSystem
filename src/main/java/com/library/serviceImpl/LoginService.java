package com.library.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.library.model.Registration;
import com.library.utility.MyConnection;

public class LoginService implements com.library.service.RegistrationService {

	Scanner sc = new Scanner(System.in);

	@Override
	public int checkLogin() {

		Connection connection = null;
		PreparedStatement ps = null;
		boolean flag = false;
		String role = "";

		try {

			connection = MyConnection.getConnection();
			String sql = "Select * from registration where uname = ? and pass = ?";

			ps = connection.prepareStatement(sql);

			System.out.println("Enter User Name = ");
			String id = sc.next();
			ps.setString(1, id);

			System.out.println("Enter Password = ");
			String name = sc.next();
			ps.setString(2, name);

//			System.out.println("Enter Role = ");
//			role = sc.next();
//			ps.setString(3, role);

			ResultSet r = ps.executeQuery();
			flag = r.next();
			if (flag == true)
				role = r.getString(5);

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				connection.close();
				ps.close();

			} catch (Exception e) {

			}
		}
		if (flag == true && role.equalsIgnoreCase("admin")) {
			System.out.println("Login Successfully");
			return 1;
		}
		if (flag == true && role.equalsIgnoreCase("reader")) {
			System.out.println("Login Successfully");
			return 2;
		}
		return 0;
	}

	@Override
	public void registration() {

		Connection connection = null;
		PreparedStatement ps = null;

		try {

			connection = MyConnection.getConnection();

			String sql = "insert into registration values(? ,? ,? ,? ,?)";
			ps = connection.prepareStatement(sql);

			System.out.println("Enter Your Name = ");
			String name = sc.next();
			ps.setString(1, name);

			System.out.println("Enter Mobile No = ");
			String mobileNo = sc.next();
			ps.setString(2, mobileNo);

			System.out.println("Enter User Name = ");
			String uname = sc.next();
			ps.setString(3, uname);

			System.out.println("Enter Password = ");
			String pass = sc.next();
			ps.setString(4, pass);

			System.out.println("Enter Role = ");
			System.out.println("\t1. Admin \n\t2. Reader \n Select 1 Option");
			int ch = sc.nextInt();

			if (ch == 1) {
				String role = "admin";
				ps.setString(5, role);
			}

			if (ch == 2) {
				String role = "reader";
				ps.setString(5, role);
			}

			if (ch >= 3) {
				System.err.println("Invaild Option");
				return;
			}

			ps.execute();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				connection.close();
				ps.close();

			} catch (Exception e) {

			}
		}

		System.out.println("Registration Successfully");

	}

	@Override
	public void updatePassword() {

		Connection connection = null;
		PreparedStatement ps = null;

		try {

			connection = MyConnection.getConnection();
			String sql = "Select * from registration where uname = ?";

			ps = connection.prepareStatement(sql);
			System.out.println("Enter User Name = ");
			String id1 = sc.next();
			ps.setString(1, id1);
			ResultSet r = ps.executeQuery();
			boolean flag = r.next();

			if (flag == true) {

				String sql1 = "update registration set pass = ? where uname = ?";
				ps = connection.prepareStatement(sql1);

				ps.setString(2, id1);

				System.out.println("Enter Set New Password = ");
				String name = sc.next();
				ps.setString(1, name);

				ps.executeUpdate();

			}

			if (flag == false) {
				System.out.println("Invalid User Name");
			}
		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				connection.close();
				ps.close();

			} catch (Exception e) {

			}
		}

	}

}
