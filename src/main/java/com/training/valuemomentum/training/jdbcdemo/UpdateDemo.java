package com.training.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDemo {

	public static void main(String[] args) {
		
		Connection con;
		Statement stmt;
		int cnt=0;
		try {
		// register jdbc driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// creating connection object
		System.out.println("Connection to database");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Mandhane*123");
		
		String sqlUpdate = "UPDATE candidates "+"SET last_name = ? "+"WHERE id = ?";
		PreparedStatement pstmt = con.prepareStatement(sqlUpdate);
		// prepare date for update
		Scanner s = new Scanner(System.in);
		System.out.println("enter Employee id:");
		int eid=s.nextInt();
		System.out.println("enter Employee's new last name:");
		String lastname=s.next();
		
		pstmt.setString(1,lastname);
		pstmt.setInt(2,eid);
		
		int rowAffected = pstmt.executeUpdate();
		System.out.println(String.format("Row affected %d",rowAffected));
		
		//reuse the prepared statement
		lastname = "Grohe";
		eid = 101;
		pstmt.setString(1,lastname);
		pstmt.setInt(2,eid);
		
		rowAffected = pstmt.executeUpdate();
		System.out.println(String.format("Row affected %d",rowAffected));
		con.close();
		}catch(Exception ce) {
			System.out.println(ce);
			}

	}

}
