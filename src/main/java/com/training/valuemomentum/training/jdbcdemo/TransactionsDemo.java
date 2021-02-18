package com.training.valuemomentum.training.jdbcdemo;
import java.sql.*;
public class TransactionsDemo {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		 Class.forName("com.mysql.cj.jdbc.Driver");
         // created connection object
         System.out.println("Connection to database");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Mandhane*123");
        System.out.println("driver is loaded");
         
         Statement stmt=con.createStatement();
         con.setAutoCommit(false);
         try {
        	 int i1=stmt.executeUpdate("insert into candidate_skills values(50,3)");
        	 int i2=stmt.executeUpdate("update skills set name='Sam' where id=2");
        	 int i3=stmt.executeUpdate("delete from candidates where id=35");
        	 con.commit();
        	 System.out.println("Transaction is success");
        	 
         }// end of try
         catch(Exception e)
         {
        	 try
        	 {
        		 con.rollback();
        		 System.out.println("Transaction is failed");
        	 }
        	 catch(Exception ex)
        	 {
        		 System.out.println(ex);
        	 }
         }
         stmt.close();
         con.close();
         System.out.println("connection is closed");
	}

}
