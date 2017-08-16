package onlineshopping;
import java.sql.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DBConnection {
	
	public static  Connection  getConnectione() 
	{
		
		
		try
		{
			Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshopping","root","");
			return myConn;
		}
		catch(Exception e){
			return null;
		}
		
		
		
	}

	public void login(String a,String b,Connection con) throws SQLException
	{
		
		Statement myStmt=con.createStatement();
		
		ResultSet myRs=myStmt.executeQuery("select * from onlineshopping.login  where username='"+a+"' and password='"+b+"'");
		
		if(!myRs.next())	{
			JOptionPane.showMessageDialog(null, "Invalid Login Details","Login Error",JOptionPane.ERROR_MESSAGE );
			
		}
		else
		{
			while(myRs.next()){
				 
			}
			
			productpage info = new productpage();
				productpage.main(null);
			
			}
				
		}
			//productdetails
	public void mobile() throws SQLException
	{
		productdetails info = new productdetails();
		productdetails.main(null);
		
		}
	public void carr() throws SQLException
	{
		Car info = new Car();
		Car.main(null);
		
		}
	public void wat() throws SQLException
	{
		Watch info = new Watch();
		Watch.main(null);
		
		}
	public void comp() throws SQLException
	{
		Computer info = new Computer();
		Computer.main(null);
		
		}
}
