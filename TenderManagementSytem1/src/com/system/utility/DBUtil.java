package com.system.utility;

import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {

	 public static Connection provideConnection() {
		 
		 Connection con= null;
		 String url ="jdbc:mysql://localhost:3306/deadtest1";
		 
		 
		 try {
			con=DriverManager.getConnection(url,"root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	 }
		
		
	
	
}
