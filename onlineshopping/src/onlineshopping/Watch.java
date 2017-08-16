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

public class Watch extends JFrame {

	private JPanel contentPane;
	private static JTextField txtwatid;
	private static JTextField txtproname;
	private static JTextField txtprode;
	private static JTextField txtprocost;
	private static JTextField txtprocount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Watch frame = new Watch();
					frame.setVisible(true);
					DBConnection ob= new DBConnection();
					Connection con= ob.getConnectione();
					Statement myStmt=con.createStatement();
					ResultSet myRs=myStmt.executeQuery("select * from product where idproduct='"+4+"' and count>'"+0+"'");
					while(myRs.next()){
						txtwatid.setText(myRs.getString(1));
						txtproname.setText(myRs.getString(2));
						txtprode.setText(myRs.getString(3));
						txtprocost.setText(myRs.getString(4));
						
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
	public Watch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product Details");
		lblNewLabel.setBounds(225, 11, 165, 42);
		contentPane.add(lblNewLabel);
		
		txtwatid = new JTextField();
		txtwatid.setEditable(false);
		txtwatid.setBounds(320, 76, 86, 20);
		contentPane.add(txtwatid);
		txtwatid.setColumns(10);
		txtwatid.setVisible(false);
		
		txtproname = new JTextField();
		txtproname.setEditable(false);
		txtproname.setBounds(224, 76, 86, 20);
		contentPane.add(txtproname);
		txtproname.setColumns(10);
		
		txtprode = new JTextField();
		txtprode.setEditable(false);
		txtprode.setBounds(225, 107, 86, 20);
		contentPane.add(txtprode);
		txtprode.setColumns(10);
		
		txtprocost = new JTextField();
		txtprocost.setEditable(false);
		txtprocost.setBounds(224, 138, 86, 20);
		contentPane.add(txtprocost);
		txtprocost.setColumns(10);
		
		txtprocount = new JTextField();
		txtprocount.setBounds(225, 176, 86, 20);
		contentPane.add(txtprocount);
		txtprocount.setColumns(10);
		
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
					myStmt.executeUpdate("INSERT INTO shop VALUES ('"+sho+"','"+txtwatid.getText()+"','"+shopbyid+"')");
					ResultSet myR=myStmt.executeQuery("SELECT * FROM product WHERE idproduct='"+4+"'");
					while(myR.next()){
						
						noi=Integer.parseInt(txtprocount.getText());
						
						cou=myR.getInt(5);
						
						tot=cou-noi;
						
						}
					
					myStmt.executeUpdate("UPDATE product SET count = '"+tot+"' WHERE idproduct='"+4+"'");
						
					
					Thanks obj = new Thanks();
					obj.main(null);
					
					myRs.close();
							
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnNewButton.setBounds(105, 235, 89, 23);
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
		btnNewButton_1.setBounds(225, 235, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Product Name");
		lblNewLabel_1.setBounds(81, 79, 119, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Description");
		lblNewLabel_2.setBounds(81, 110, 119, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cost");
		lblNewLabel_3.setBounds(81, 141, 76, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("No Of Item");
		lblNewLabel_4.setBounds(81, 179, 102, 14);
		contentPane.add(lblNewLabel_4);
	}

}
