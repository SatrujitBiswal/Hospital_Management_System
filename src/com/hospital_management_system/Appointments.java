package com.hospital_management_system;

import java.nio.channels.SelectableChannel;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Appointments {
  
	public void book_appointment(Doctor doctor,patient ptn) {
		
	
		Scanner  sc = new Scanner(System.in);
       
		System.out.println("Enter patient id");
		int patientId= sc.nextInt();
		
		System.out.println("Enter Doctor id");
		int DoctorId = sc.nextInt();
		
		System.out.println("Enter appointment date (yyyy-mm-dd)");
		String appointmentdate = sc.next();
		
		if(ptn.getpatientbyid(patientId)&& doctor.getdoctorsbyid(DoctorId)) {
			if(checkDoctorAvailability(DoctorId,appointmentdate)) {
				
				try {
					 Class.forName("com.mysql.cj.jdbc.Driver"); // load and register driver 
				       Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?useSSL=false", "root", "Satru@12"); //making connection
				       
				       PreparedStatement ps= con.prepareStatement("insert into appointments (patient_id,doctor_id,appointment_date) values(?,?,?)"); // create statements
				       ps.setInt(1, patientId);
				       ps.setInt(2, DoctorId);
				       ps.setString(3, appointmentdate);
				       
				       int i = ps.executeUpdate(); // execute
				       
				       if(i>0) {
				     	  System.out.println("Appointment booked succesfully");
				       }
				       else
				     	  System.out.println("failed to book Appointment");
				       
				     
			}
				  catch (Exception e) {
						// TODO: handle exception
					     }
			}
			else {
				System.out.println("Doctor not available on this date !!");
			}
			
		}
		
		else {
			System.out.println("Either doctor or patient does not exist");
		}
		
	
}

	public  boolean checkDoctorAvailability(int DoctorId, String appointmentdate) {
		// TODO Auto-generated method stub
		
		try {
			
			 Class.forName("com.mysql.cj.jdbc.Driver"); // load and register driver 
		       Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?useSSL=false", "root", "Satru@12"); //making connection
		       
		       PreparedStatement ps= con.prepareStatement("select count(*) from appointments where doctor_id = ? and appointment_date = ?");
		       
		       ps.setInt(1, DoctorId);
		       ps.setString(2, appointmentdate);
		       
		       ResultSet rs = ps.executeQuery();
		       
		       if(rs.next()) {
		    	   int count = rs.getInt(1);
		    	   
		    	   if(count==0) {
		    		   return true;
		    	   }
		    	   else {
					return false;
				}
		    	   
		       }
		       
		     
		       
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}
