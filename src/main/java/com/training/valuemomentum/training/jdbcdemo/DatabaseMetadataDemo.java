package com.training.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class DatabaseMetadataDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Connection con;
		
		try{  
	 Class.forName("com.mysql.cj.jdbc.Driver");
	System.out.println("Connecting to database...");
	con=DriverManager.getConnection(  
	"jdbc:mysql://localhost:3306/mysqljdbc","root","Mandhane*123");
	
	java.sql.DatabaseMetaData dbmd=con.getMetaData();
	System.out.println("database server name:"+dbmd.getDatabaseProductName());
	System.out.println("database server version:"+dbmd.getDatabaseProductVersion());
	System.out.println("driver server version:"+dbmd.getDriverVersion());
	System.out.println("driver server name:"+dbmd.getDriverName());
	System.out.println("max columns:"+dbmd.getMaxColumnsInTable());
	
	con.close();
		}
	catch(Exception e){ System.out.println(e);}  
	}

}
