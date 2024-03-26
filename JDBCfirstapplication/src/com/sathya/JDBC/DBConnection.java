package com.sathya.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	Connection connection=null;
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection=DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:XE","system","manager");
		
		
	}
	catch(ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	return connection;
}
}
