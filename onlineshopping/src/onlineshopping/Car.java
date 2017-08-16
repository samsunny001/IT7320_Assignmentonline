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
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Car extends JFrame {

	private JPanel contentPane;
	private static JTextField txtcaid;
	private static JTextField txtcapro;
	private static JTextField txtcade;
	private static JTextField txtcaco;
	private static JTextField txtcacount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Car frame = new Car();
					frame.setVisible(true);
					DBConnection ob= new DBConnection();
					Connection con= ob.getConnectione();
					Statement myStmt=con.createStatement();
					ResultSet myRs=myStmt.executeQuery("select * from product where idproduct='"+5+"' and count>'"+0+"'");
					while(myRs.next()){
						txtcaid.setText(myRs.getString(1));
						txtcapro.setText(myRs.getString(2));
						txtcade.setText(myRs.getString(3));
						txtcaco.setText(myRs.getString(4));
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
	public Car() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product Details");
		lblNewLabel.setBounds(136, 11, 120, 28);
		contentPane.add(lblNewLabel);
		
		txtcaid = new JTextField();
		txtcaid.setEditable(false);
		txtcaid.setBounds(170, 67, 86, 20);
		contentPane.add(txtcaid);
		txtcaid.setColumns(10);
		txtcaid.setVisible(false);
		
		txtcapro = new JTextField();
		txtcapro.setEditable(false);
		txtcapro.setBounds(170, 98, 86, 20);
		contentPane.add(txtcapro);
		txtcapro.setColumns(10);
		
		txtcade = new JTextField();
		txtcade.setEditable(false);
		txtcade.setBounds(170, 129, 86, 20);
		contentPane.add(txtcade);
		txtcade.setColumns(10);
		
		txtcaco = new JTextField();
		txtcaco.setEditable(false);
		txtcaco.setBounds(170, 160, 86, 20);
		contentPane.add(txtcaco);
		txtcaco.setColumns(10);
		
		txtcacount = new JTextField();
		txtcacount.setBounds(170, 191, 86, 20);
		contentPane.add(txtcacount);
		txtcacount.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Product Name");
		lblNewLabel_2.setBounds(51, 100, 119, 17);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Description");
		lblNewLabel_3.setBounds(51, 132, 87, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cost");
		lblNewLabel_4.setBounds(51, 163, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("No of Item");
		lblNewLabel_5.setBounds(51, 194, 87, 17);
		contentPane.add(lblNewLabel_5);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
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
					myStmt.executeUpdate("INSERT INTO shop VALUES ('"+sho+"','"+txtcaid.getText()+"','"+shopbyid+"')");
					ResultSet myR=myStmt.executeQuery("SELECT * FROM product WHERE idproduct='"+5+"'");
					while(myR.next()){
						
						noi=Integer.parseInt(txtcacount.getText());
						
						cou=myR.getInt(5);
						
						tot=cou-noi;
						
						}
					
					myStmt.executeUpdate("UPDATE product SET count = '"+tot+"' WHERE idproduct='"+5+"'");
						
					
					Thanks obj = new Thanks();
					obj.main(null);
					
					myRs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBuy.setBounds(57, 237, 89, 23);
		contentPane.add(btnBuy);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
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
		btnCancel.setBounds(167, 237, 89, 23);
		contentPane.add(btnCancel);
	}
}
