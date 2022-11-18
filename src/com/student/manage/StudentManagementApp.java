package com.student.manage;

import java.util.Scanner;

public class StudentManagementApp {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to Student Management App");
		
		while(true) {
			System.out.println("++++++++++++++++++++++++++++++++");
			System.out.println("PRESS 1 to ADD student");
			System.out.println("PRESS 2 to DELETE student: ");
			System.out.println("PRESS 3 to DISPLAY student: ");
			System.out.println("PRESS 4 to EXIT App:");
			System.out.println("++++++++++++++++++++++++++++++++");
			int choice=sc.nextInt();
			
			switch(choice) {
			//Add student
			case 1:
				System.out.println("Enter Student Name: ");
				String name=sc.next();
				
				System.out.println("Enter Student Phone no: ");
				int phone=sc.nextInt();
				
				System.out.println("Enter Student City: ");
				String city=sc.next();
				
				//create student object to store student
				Student st=new Student(name, phone, city);
				
				boolean answer = StudentDao.insetStudentToDB(st);
				if(answer) {
					System.out.println("Student is added successfully...");
				}
				else {
					System.out.println("Something went wrong, Please try again....");
				}
				break;
				
			//Delete student
			case 2:
				System.out.println("Enter student id to delete: ");
				int userId=sc.nextInt();
				boolean f=StudentDao.deleteStudent(userId);
				if(f) {
					System.out.println(userId+" user deleted successfully");
				}
				else {
					System.out.println("Something went wrong.....");
				}
				break;
			
			//Display student
			case 3:
				StudentDao.showAllStudent();
				break;
				
			//Update student
			
			case 4:
				System.out.println("Thank you for using my application...");
				System.exit(0);
				break;
				
			default:
				System.out.println("Invalid choice, Please press following Options: ");
			}
		}
		
	}
}



















