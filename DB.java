package com.swingdemo.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

	public static Connection getDbCon(){
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swingdb","root","");
		return con;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
}
