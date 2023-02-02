package com.library.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {

	public static final String URl = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	public static final String UserName = "root";
	public static final String Password = "mynewpassword";

	public static Connection connection = null;

	private MyConnection() {

	}

	public static Connection getConnection() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(URl, UserName, Password);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return connection;

	}

}
