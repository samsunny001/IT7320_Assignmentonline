package onlineshopping;
import java.sql.*;
public class DBConnection {
	public static void main(String[] args){
String dbUrl="jdbc:mysql://localhost:3306/onlineshopping";
String user="root";
	String password="";
try
{
Connection myConn=DriverManager.getConnection(dbUrl,user,password);
Statement myStmt=myConn.createStatement();
ResultSet myRs=myStmt.executeQuery("select * from product");

while(myRs.next())	{
	System.out.println(myRs.getString("Username")+" "+ myRs.getString("password"));
}
myStmt.close();
myConn.close();
}
catch(Exception e){
	
}
	}
}
