package com.cookies;

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.JButton;

public class Login extends JPanel{
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	public Login() throws SQLException{
		setBackground(Color.BLACK);
		setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(292, 253, 233, 35);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(292, 299, 233, 35);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.setBounds(292, 345, 233, 35);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Can't access account?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(292, 391, 233, 14);
		add(lblNewLabel);			
	}
	
	public static boolean validateLogin(String username, String password) throws SQLException{
		String url = "jdbc:mysql://localhost/Java_Database_Project";
		String user = "root";
		String pass = "admin";
		Connection connection = null;
		PreparedStatement loginStatement;
		ResultSet loginResult = null;
		try{
			connection = DriverManager.getConnection(url,user,pass);
			loginStatement = connection.prepareStatement("SELECT admin_username,admin_password FROM admin WHERE admin.admin_username = ? and admin.admin_password = ?");
			loginStatement.setString(1, username);
			loginStatement.setString(2, password);
			loginResult = loginStatement.executeQuery();
			
			if(loginResult.next()){
				Start_Program.isUserValidated = true;
			}else{
				JOptionPane.showMessageDialog(null, "Incorrect username and/or password!","Login Failure!",JOptionPane.WARNING_MESSAGE);
			}
			
		}catch (SQLException e){
			System.out.println(e);
		}finally{
			connection.close();
		}
		return Start_Program.isUserValidated;
	}
}
