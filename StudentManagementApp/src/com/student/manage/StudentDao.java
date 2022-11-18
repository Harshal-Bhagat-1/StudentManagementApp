package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class StudentDao {

	public static boolean insetStudentToDB(Student st) {
		
		boolean f=false;
		
		try {
			//jdbc code...
			Connection con=CP.createC();
			String q="insert into students(sname,sphone,scity) values(?,?,?)";
			
			//PreparedStatement
			PreparedStatement pstmt=con.prepareStatement(q);
			
			//set the value of parameter
			pstmt.setString(1, st.getsName());
			pstmt.setInt(2, st.getsPhone());
			pstmt.setString(3,st.getsCity());
			
			//execute...
			pstmt.executeUpdate();
			f=true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
	}
	
	public static boolean deleteStudent(int userId) {

		boolean f=false;
		
		try {
			Connection con=CP.createC();
			String q="delete from students where sid=?";
			
			//PreparedStatement
			PreparedStatement pstmt=con.prepareStatement(q);
			
			//set the value of parameter
			pstmt.setInt(1, userId);
			
			
			//execute...
			pstmt.executeUpdate();
			f=true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
		
		
		
	}

	public static void showAllStudent() {
		// TODO Auto-generated method stub
		boolean f=false;
		
		try {
			Connection con=CP.createC();
			String q="select * from students";
			
			Statement stmt=con.createStatement();
			
			ResultSet set=stmt.executeQuery(q);
			
			while(set.next()) {
				int id=set.getInt(1);
				String name=set.getString(2);
				String phone=set.getString(3);
				String city=set.getString(4);
				
				System.out.println("-------------------------------------------------------");
				System.out.println("ID: "+id+" Name: "+name+" Phone no: "+phone+" City: "+city);
				System.out.println("-------------------------------------------------------");
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
//		return f;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
