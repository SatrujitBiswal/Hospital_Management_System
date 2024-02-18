package com.hospital_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class patient  {
   
	public void addpatient() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter patient Name");
		String name = scanner.next();
		
		System.out.println("Enter patient Age");
		 int age = scanner.nextInt();
		 
		 System.out.println("Enter patient gender");
		 String gender = scanner.next();
		 
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver"); // load and register driver 
		       Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?useSSL=false", "root", "Satru@12"); //making connection
		       
		       PreparedStatement ps= con.prepareStatement("insert into patients (name,age,gender) values(?,?,?)"); // create statements
		       ps.setString(1, name);
		       ps.setInt(2, age);
		       ps.setString(3, gender);
		       
		       int i = ps.executeUpdate(); // execute
		       
		       if(i>0) {
		     	  System.out.println("Succesfully registered");
		       }
		       else
		     	  System.out.println("Reistered failed");
		      
		} catch (SQLException | ClassNotFoundException e) {
			// TODO: haendle exception
			e.printStackTrace();
		}

	}
	
	public void viewpatient() {
		
		try {
			  Class.forName("com.mysql.cj.jdbc.Driver");
			     
			     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?useSSL=false","root","Satru@12");
			     
			     PreparedStatement ps = con.prepareStatement("select * from patients");
			     
			    ResultSet rs = ps.executeQuery();
			     
			     while(rs.next()) {
			    	 
			    	 int id = rs.getInt("id");
			    	 System.out.println(id);
			    	 
			    	 String name1 = rs.getString("name");
			    	 System.out.println("name =" +name1);
			    	 
			    	 int age1 = rs.getInt("age");
			    	 System.out.println("Age ="+age1);
			    	 
			    	 String gender1 = rs.getString("gender");
			    	 System.out.println("Gender ="+gender1);
			     }
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public  boolean getpatientbyid(int id) {
		
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
		     
		     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?useSSL=false","root","Satru@12");
		     
		     PreparedStatement ps = con.prepareStatement("select * from patients where id = ?");
		     ps.setInt(1, id);
		    ResultSet rs = ps.executeQuery();
		    
		    if(rs.next()) {
		    	return true;
		    }
		    else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
		
	}

	
}
