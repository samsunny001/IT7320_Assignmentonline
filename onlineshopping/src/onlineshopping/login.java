package onlineshopping;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import onlineshopping.DBConnection.*;
import java.sql.*;
public class login {

	private JFrame frmLogin;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 */
	
	 
	public static void main(String[] args) throws SQLException {
		DBConnection ob= new DBConnection();
		Connection con= ob.getConnectione();
		
		
			
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public login() {
		initialize();
	}

	
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("login");
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblUserName = new JLabel("Username");
		lblUserName.setBounds(90, 79, 92, 14);
		frmLogin.getContentPane().add(lblUserName);
		
		textField = new JTextField();
		textField.setBounds(192, 76, 86, 20);
		frmLogin.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(90, 127, 99, 14);
		frmLogin.getContentPane().add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DBConnection ob= new DBConnection();
				Connection con= ob.getConnectione();
				//conn.setVisible(true);
				
				String password = passwordField.getText();
				String username = textField.getText();
				try {
					ob.login(username, password, con);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnLogin.setBounds(73, 168, 89, 23);
		frmLogin.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(192, 124, 86, 20);
		frmLogin.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(null);
				passwordField.setText(null);
			}
		});
		btnNewButton.setBounds(233, 168, 89, 23);
		frmLogin.getContentPane().add(btnNewButton);
	}
}