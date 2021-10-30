/*
 * It is a java file that creates database and performs address formatting operation.
 */

package uidai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedHashSet;


public class UserDatabase {
	
	private String url = "jdbc:mysql://localhost/";
	private String user = "root";
	private String password = "root";

	// Declare and initialise sql query for inserting data and printing the final address 
	private static final String insert_query = "insert into address(aadharNo, hNo, street, area, landmark, town, subDistrict, district, state, pin, finalAddress) values (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String select_query = "Select finalAddress from address where aadharNo = ?";

	//It establishes the connection with MySql and creates database and table in it
	protected Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Class not found");
		} 
		
	    // Open a connection and creates database
	    conn = DriverManager.getConnection(url,user,password);
	    Statement stmt = conn.createStatement();
	    
	    String sql = "create database if not exists aadhar";
	    stmt.executeUpdate(sql);
	    System.out.println("Database created successfully...");  
	    String useDB = "use aadhar";
	    stmt.executeUpdate(useDB);
	    
	    //Creates table
	    String create_table = "create table if not exists address (aadharNo VARCHAR(12) unique, hNo VARCHAR(40), street VARCHAR(40), area VARCHAR(40), landmark VARCHAR(40), town VARCHAR(40), subDistrict VARCHAR(40), district VARCHAR(40), state VARCHAR(40), pin INT(6), finalAddress VARCHAR(100))";
        stmt.executeUpdate(create_table);
        
		return conn;
	        
	}	
	
	
	// Inserts the data into table and formats the address
	public void insertAndFormatting(UserInput user) throws SQLException {

		try (Connection conn = getConnection();) {
			
			PreparedStatement pstmt = conn.prepareStatement(insert_query);

			pstmt.setString(1, user.getAadharNo());
			pstmt.setString(2, user.gethNo());
			pstmt.setString(3, user.getStreet());
			pstmt.setString(4, user.getArea());
			pstmt.setString(5, user.getLandmark());
			pstmt.setString(6, user.getTown());
			pstmt.setString(7, user.getSubDistrict());
			pstmt.setString(8, user.getDistrict());
			pstmt.setString(9, user.getState());
			pstmt.setString(10, user.getPin());

			// It only takes the unique values. Therefore all the duplicates will be removed. 
			LinkedHashSet<String> set = new LinkedHashSet<>();

			set.add(user.gethNo());
			set.add(user.getStreet());
			set.add(user.getArea().toLowerCase());
			set.add(user.getLandmark().toLowerCase());
			set.add(user.getTown().toLowerCase());
			set.add(user.getSubDistrict().toLowerCase());
			set.add(user.getDistrict().toLowerCase());
			set.add(user.getState());
			set.add(user.getPin());

			// Checks extra commas and removes square brackets
			String value = set.toString();
			int length = value.length();
			String value1 = value.substring(1, length - 1);
			String finalAddress = value1.replaceAll(" , ", " ");
			String ch = finalAddress.substring(0, 1);

			if (ch.equals(",")) {
				int length1 = finalAddress.length();
				String finalAddress1 = finalAddress.substring(2, length1);

				pstmt.setString(11, finalAddress1);  //Adds the formatted address to the table in column 11
				pstmt.executeUpdate();  
			} else {
				pstmt.setString(11, finalAddress);
				pstmt.executeUpdate();

			}
		} catch (Exception e) {
			System.out.println("Connection not established!");
		}
	}
	
	// It returns the formatted address 
	public String selectAddress(String aadharNo) {
		 
		String add = null;
		try{
			
			Connection con = DriverManager.getConnection(url,user,password);
		    Statement stmt = con.createStatement();
		    String useDB = "use aadhar";
		    stmt.executeUpdate(useDB);
		  
			PreparedStatement pstmt = con.prepareStatement(select_query);
			pstmt.setString(1,aadharNo);
			
			ResultSet rst = pstmt.executeQuery();
			rst.next();
			add = rst.getString("finalAddress"); 
			return add;		
		}
		
		catch (SQLException e) {
			return add;	
		}	
	}
}