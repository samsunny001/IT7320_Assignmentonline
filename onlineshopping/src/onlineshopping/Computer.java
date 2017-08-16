package onlineshopping;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Computer extends JFrame {

	private JPanel contentPane;
	private static JTextField txtcomid;
	private static JTextField txtcomna;
	private static  JTextField txtcomde;
	private static JTextField txtcomco;
	private static JTextField txtcomcou;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Computer frame = new Computer();
					frame.setVisible(true);
					DBConnection ob= new DBConnection();
					Connection con= ob.getConnectione();
					Statement myStmt=con.createStatement();
					ResultSet myRs=myStmt.executeQuery("select * from product where idproduct='"+3+"' and count>'"+0+"'");
					while(myRs.next()){
						txtcomid.setText(myRs.getString(1));
						txtcomna.setText(myRs.getString(2));
						txtcomde.setText(myRs.getString(3));
						txtcomco.setText(myRs.getString(4));
						
				}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Computer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProductDetails = new JLabel("Product Details");
		lblProductDetails.setBounds(131, 11, 140, 31);
		contentPane.add(lblProductDetails);
		
		txtcomid = new JTextField();
		txtcomid.setEditable(false);
		txtcomid.setBounds(245, 46, 86, 10);
		contentPane.add(txtcomid);
		txtcomid.setColumns(10);
		txtcomid.setVisible(false);
		
		txtcomna = new JTextField();
		txtcomna.setEditable(false);
		txtcomna.setBounds(141, 60, 86, 20);
		contentPane.add(txtcomna);
		txtcomna.setColumns(10);
		
		txtcomde = new JTextField();
		txtcomde.setEditable(false);
		txtcomde.setBounds(141, 99, 86, 20);
		contentPane.add(txtcomde);
		txtcomde.setColumns(10);
		
		txtcomco = new JTextField();
		txtcomco.setEditable(false);
		txtcomco.setBounds(141, 130, 86, 20);
		contentPane.add(txtcomco);
		txtcomco.setColumns(10);
		
		txtcomcou = new JTextField();
		txtcomcou.setBounds(141, 161, 86, 20);
		contentPane.add(txtcomcou);
		txtcomcou.setColumns(10);
		
		JButton btnNewButton = new JButton("Buy");
		btnNewButton.addActionListener(new ActionListener() {
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
					myStmt.executeUpdate("INSERT INTO shop VALUES ('"+sho+"','"+txtcomid.getText()+"','"+shopbyid+"')");
					ResultSet myR=myStmt.executeQuery("SELECT * FROM product WHERE idproduct='"+3+"'");
					while(myR.next()){
						
						noi=Integer.parseInt(txtcomcou.getText());
						
						cou=myR.getInt(5);
						
						tot=cou-noi;
						
						}
					
					myStmt.executeUpdate("UPDATE product SET count = '"+tot+"' WHERE idproduct='"+3+"'");
						
					
					Thanks obj = new Thanks();
					obj.main(null);
					
					myRs.close();
							
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(69, 213, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
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
		btnNewButton_1.setBounds(182, 213, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Product Name");
		lblNewLabel.setBounds(47, 62, 84, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Description");
		lblNewLabel_1.setBounds(48, 102, 84, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cost");
		lblNewLabel_2.setBounds(48, 133, 84, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("No of Item");
		lblNewLabel_3.setBounds(48, 164, 46, 14);
		contentPane.add(lblNewLabel_3);
	}

}
