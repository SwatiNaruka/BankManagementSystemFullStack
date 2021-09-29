package com.bank.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
		public static Connection getConnection() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank1", "root", "");	
				Statement stmt=con.createStatement();
				return con;
				
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return null;
		} 	
}
