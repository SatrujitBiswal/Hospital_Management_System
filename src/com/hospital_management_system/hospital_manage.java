package com.hospital_management_system;

import java.util.Scanner;

public class hospital_manage {

	public static void main(String[] args) {
		
		Doctor doctor = new Doctor();
		patient ptn = new patient();
		Appointments appointments = new Appointments();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. add patients");
		System.out.println("2. view patients");
		System.out.println("3. view doctors");
		System.out.println("4. Book Appointment");
		System.out.println("5.Exit");
		
		System.out.println("Enter your choice");
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1: 
			ptn.addpatient();
			break;
		
		case 2:
			ptn.viewpatient();
			break;
		case 3:
			doctor.viewdoctor();
			break;
		case 4:
			 appointments.book_appointment(doctor, ptn);
			 break;
		case 5:
			return;
		default:
			System.out.println("Invalid choice");
		}
		
	}
	
}
