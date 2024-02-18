package com.hospital_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Doctor {
public void viewdoctor() {
		
		try {
			  Class.forName("com.mysql.cj.jdbc.Driver");
			     
			     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?useSSL=false","root","Satru@12");
			     
			     PreparedStatement ps = con.prepareStatement("select * from doctors");
			     
			    ResultSet rs = ps.executeQuery();
			     
			     while(rs.next()) {
			    	 
			    	 int id = rs.getInt("id");
			    	 System.out.println(id);
			    	 
			    	 String name1 = rs.getString("name");
			    	 System.out.println(name1);
			    	 
			    	
			    	 
			    	 String specialize = rs.getString("specialization");
			    	 System.out.println(specialize);
			     }
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public boolean getdoctorsbyid(int id) {
		
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
		     
		     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?useSSL=false","root","Satru@12");
		     
		     PreparedStatement ps = con.prepareStatement("select * from doctors where id = ?");
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
