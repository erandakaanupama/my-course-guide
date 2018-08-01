package com.eab.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/my-course-guide?useSSL=false";
		String username = "shopingcart";
		String password = "shopingcart";

		try {
			System.out.println("Connecting to " + jdbcUrl);
			Connection myCon = DriverManager.getConnection(jdbcUrl, username, password);

			System.out.println("connection successful");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
