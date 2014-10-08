package com.cookies;

import java.awt.*;
import java.sql.*;

import javax.swing.*;

public class Start_Program extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Connection connection = null;
	public static Boolean isUserValidated = false;
	
	public Start_Program(){
		
	}
	
	public static boolean validateLogin() throws SQLException{
		//String url = "jdbc:mysql://192.186.249.9/PenFed_Realty";
		String url = "jdbc:mysql://localhost/Java_Database_Project";
		//String user ="administrator";
		String user = "root";
		//String pass = "adminpass";
		String pass = "admin";
		
		try{
			connection = DriverManager.getConnection(url,user,pass);
		}catch (SQLException e){
			System.out.println(e);
		}finally{
			connection.close();
		}
		
		
		return isUserValidated;
	}
	
	public static void main(String[] args) throws SQLException {
		JFrame mainFrame = new JFrame();
		mainFrame.setResizable(true);
		mainFrame.setVisible(true);
		mainFrame.setSize(new Dimension(800,800));
		
		Start_Program.validateLogin();
		System.out.println(Start_Program.isUserValidated);
	}

}
