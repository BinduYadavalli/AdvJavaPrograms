package com.sathya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc1 {

	public static void main(String[] args) throws ClassNotFoundException,SQLException {
		// TODO Auto-generated method stub
      Class.forName("oracle.jdbc.driver.OracleDriver");
      System.out.println("driver loaded successfully");
      //create connection
      Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:XE","system","manager");
	  System.out.println("connectin successfully");
	}
	

}

