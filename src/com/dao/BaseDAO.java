package com.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.vo.Product;

public class BaseDAO {
	
	public static Connection getConnection() {
		
		Connection connection = null;
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "Kri0357shna$");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}

	

	

	

	
	

	
	

	

	
	

}
