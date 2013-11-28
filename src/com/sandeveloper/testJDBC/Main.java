package com.sandeveloper.testJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		
		Connection conect = null;
		Statement statement = null;
		
		String createTableSQL = "CREATE TABLE user" +
								"(id INT NOT NULL AUTO_INCREMENT, " +
								" first VARCHAR(255), " +
								" last VARCHAR(255), " +
								" age INTEGER, " + 
								" PRIMARY KEY ( id ))";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Driver not found");
		}
		try {
			conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/USERS","root", "1111");
			System.out.println("Conected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No connection");
		}
	
		try {
			statement = conect.createStatement();
			//statement.execute(createTableSQL);
			System.out.println("Table is created");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String addNewUser0 = "INSERT INTO user " + "(first, last, age) VALUES('Jack', 'Jack', 10)";
		String addNewUser1 = "INSERT INTO user " + "(first, last, age) VALUES('Jack', 'Jack', 10)";
		String addNewUser2 = "INSERT INTO user " + "(first, last, age) VALUES('Jack', 'Jack', 10)";
		
		try {
			
			statement.executeUpdate(addNewUser0);
			statement.executeUpdate(addNewUser1);
			statement.executeUpdate(addNewUser2);
			System.out.println("New record added");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
