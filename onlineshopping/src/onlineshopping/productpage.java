package onlineshopping;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.sql.*;

public class productpage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)throws SQLException {
		DBConnection ob= new DBConnection();
		Connection con= ob.getConnectione();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					productpage frame = new productpage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public productpage() {
		setTitle("productpage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnProduct1 = new JButton("Mobile");
		btnProduct1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DBConnection ob= new DBConnection();
				Connection con= ob.getConnectione();
			
				try {
					ob.mobile();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnProduct1.setBounds(54, 70, 89, 23);
		contentPane.add(btnProduct1);
		
		JButton btnProduct3 = new JButton("Computer");
		btnProduct3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DBConnection ob= new DBConnection();
				Connection con= ob.getConnectione();
			
				try {
					ob.comp();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				
			}
		});
		btnProduct3.setBounds(54, 116, 129, 23);
		contentPane.add(btnProduct3);
		
		JButton btnProduct5 = new JButton("Car");
		btnProduct5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBConnection ob= new DBConnection();
				Connection con= ob.getConnectione();
			
				try {
					ob.carr();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnProduct5.setBounds(239, 70, 89, 23);
		contentPane.add(btnProduct5);
		
		JButton btnProduct4 = new JButton("Watch");
		btnProduct4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DBConnection ob= new DBConnection();
				Connection con= ob.getConnectione();
			
				try {
					ob.wat();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnProduct4.setBounds(223, 116, 89, 23);
		contentPane.add(btnProduct4);
		
		JLabel lblProductsPage = new JLabel("Products Page");
		lblProductsPage.setBounds(144, 24, 129, 14);
		contentPane.add(lblProductsPage);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login objp = new login();
				try {
					objp.main(null);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCancel.setBounds(126, 164, 106, 34);
		contentPane.add(btnCancel);
	}
}
