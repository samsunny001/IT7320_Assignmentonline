package onlineshopping;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class productdetails extends JFrame {

	private JPanel contentPane;
	public Object lblproduct;
	public static JTextField txtmocost;
	private static JTextField txtmoprojectname;
	private static JTextField txtmodes;
	private JTextField txtmonoi;
	private static JTextField txtmoid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					productdetails frame = new productdetails();
					frame.setVisible(true);
					DBConnection ob= new DBConnection();
					Connection con= ob.getConnectione();
					Statement myStmt=con.createStatement();
					ResultSet myRs=myStmt.executeQuery("select * from product where idproduct='"+1+"' and count>'"+0+"'");
					while(myRs.next()){
						txtmoid.setText(myRs.getString(1));
						txtmoprojectname.setText(myRs.getString(2));
						txtmodes.setText(myRs.getString(3));
						txtmocost.setText(myRs.getString(4));
						
						}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public productdetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblproduct = new JLabel("Product Name");
		lblproduct.setBounds(57, 97, 93, 17);
		contentPane.add(lblproduct);
		txtmoprojectname = new JTextField();
		txtmoprojectname.setEditable(false);
		txtmoprojectname.setEnabled(true);
		txtmoprojectname.setBounds(184, 95, 86, 20);
		contentPane.add(txtmoprojectname);
		txtmoprojectname.setColumns(10);
		txtmocost = new JTextField();
		txtmocost.setEnabled(true);
		txtmocost.setEditable(false);
		txtmocost.setBounds(184, 158, 86, 27);
		contentPane.add(txtmocost);
		txtmocost.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Description");
		lblNewLabel.setBounds(57, 129, 93, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cost");
		lblNewLabel_1.setBounds(57, 171, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Product Details");
		lblNewLabel_2.setBounds(150, 25, 93, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Number Of Item");
		lblNewLabel_3.setBounds(57, 196, 93, 30);
		contentPane.add(lblNewLabel_3);
		
		JButton btnmoBuy = new JButton("Buy");
		
		
		btnmoBuy.setBounds(67, 247, 89, 23);
		contentPane.add(btnmoBuy);
		
		JButton btnmocan = new JButton("Cancel");
		btnmocan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productpage objp = new productpage();
				try {
					objp.main(null);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnmocan.setBounds(181, 247, 89, 23);
		contentPane.add(btnmocan);
		
		
		
		txtmodes = new JTextField();
		txtmodes.setEditable(false);
		txtmodes.setEnabled(true);
		txtmodes.setBounds(184, 127, 86, 20);
		contentPane.add(txtmodes);
		txtmodes.setColumns(10);
		
		txtmonoi = new JTextField();
		txtmonoi.setBounds(184, 196, 86, 20);
		contentPane.add(txtmonoi);
		txtmonoi.setColumns(10);
		
		txtmoid = new JTextField();
		txtmoid.setEditable(false);
		txtmoid.setEnabled(true);
		txtmoid.setBounds(184, 63, 86, 20);
		contentPane.add(txtmoid);
		txtmoid.setColumns(10);
		txtmoid.setVisible(false);
		
btnmoBuy.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				int shopidd = 0;
				int sho=0;
				int cou=0;
				int tot=0;
				int noi=0;
				DBConnection ob= new DBConnection();
				Connection con= ob.getConnectione();
				
				String shopbyid="1";
				try {
					Statement myStmt=con.createStatement();
					ResultSet myRs=myStmt.executeQuery("SELECT shopid FROM shop ORDER BY shopid DESC LIMIT 1");
					while(myRs.next()){
						shopidd=myRs.getInt(1);
						sho=shopidd+1;
						
					}
					myStmt.executeUpdate("INSERT INTO shop VALUES ('"+sho+"','"+txtmoid.getText()+"','"+shopbyid+"')");
					ResultSet myR=myStmt.executeQuery("SELECT * FROM product WHERE idproduct='"+1+"'");
					while(myR.next()){
						
						noi=Integer.parseInt(txtmonoi.getText());
						
						cou=myR.getInt(5);
						
						tot=cou-noi;
						
						}
					
					myStmt.executeUpdate("UPDATE product SET count = '"+tot+"' WHERE idproduct='"+1+"'");
						
					
					Thanks obj = new Thanks();
					obj.main(null);
					
					myRs.close();
							
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		 
	}
		}
				
	
	

