package com.cookies;

import java.awt.*;
import java.sql.*;

import javax.swing.*;

public class Start_Program{
	public static Connection connection = null;
	public static Boolean isUserValidated = false;
	public static String loginUserName,loginPassWord;
	
	public Start_Program(){
		
	}
	
	public static void main(String[] args) throws SQLException {
		JFrame mainFrame = new JFrame();
		mainFrame.setResizable(true);
		mainFrame.setVisible(true);
		mainFrame.setSize(new Dimension(800,800));
		
		new Login();
		mainFrame.getContentPane().add(new Login());
		
	}

}
