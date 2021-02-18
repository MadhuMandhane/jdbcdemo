package com.training.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertDemo {

	public static void main(String[] args) {
		Connection con;
		   Statement stmt;
		   ResultSet rs;
		   int cnt=0;
		   
		   try
		   {
			   //register JDBC driver
			   Class.forName("com.mysql.cj.jdbc.Driver");
			   
			   //open a connection
			   System.out.println("connecting to database..");
			   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Mandhane*123");
			   
			   String str = "INSERT INTO skills(name)"+"VALUES('Spring')";
			   
			  // create a statement obj using Connection obj 
			   stmt=con.createStatement();
			   int rowcount = stmt.executeUpdate(str);
			   if(rowcount>0)
			   {
				   System.out.println("Record Inserted Successfully");
			   }
			   
			   String str1 = "select count(id) from skills";
			  
			 //execute a query
			   rs=stmt.executeQuery(str1);
			   
					   //Extract data from result set
					   while(rs.next()) // next() is method in rs
					   {
						   cnt=rs.getInt(1);
					
						   
					   }
					   System.out.println("Total no. of records is:"+cnt);
					   rs.close();
					   stmt.close();
					   con.close();
				       }
				         catch(Exception ce)
				   {
				        	 System.out.println(ce);
				        	 
				   }
	}

}
