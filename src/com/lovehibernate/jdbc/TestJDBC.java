package com.lovehibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {

	public static void main(String[] args) {
		String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user="hbstudent";
		String password="hbstudentyy";
		
		System.out.println("Connecting database..."+jdbcUrl);
		try {
			Connection con=DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Database connected!");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
