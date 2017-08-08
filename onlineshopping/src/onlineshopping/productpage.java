package onlineshopping;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

public class productpage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		
		JButton btnNewButton = new JButton("product 1");
		btnNewButton.setBounds(54, 70, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("product 2");
		btnNewButton_1.setBounds(54, 116, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("product 3");
		btnNewButton_2.setBounds(54, 161, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("product 5");
		btnNewButton_3.setBounds(239, 70, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("product 6");
		btnNewButton_4.setBounds(239, 116, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("product 7");
		btnNewButton_5.setBounds(239, 161, 89, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("product 4");
		btnNewButton_6.setBounds(54, 205, 89, 23);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("product 8");
		btnNewButton_7.setBounds(239, 205, 89, 23);
		contentPane.add(btnNewButton_7);
		
		JLabel lblProductsPage = new JLabel("Products Page");
		lblProductsPage.setBounds(144, 24, 129, 14);
		contentPane.add(lblProductsPage);
	}
}
