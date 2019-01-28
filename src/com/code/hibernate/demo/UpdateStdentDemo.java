package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.entity.Student;

public class UpdateStdentDemo {

	public static void main(String[] args) {
		// create sessionFactor
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
				
				//create session
				Session session = factory.getCurrentSession();
				
				try{
					
					
					//create a new session and start transaction
					Session session1 = factory.getCurrentSession();
					session1.beginTransaction();
					
					int studentId = 5;
					// get the current student id
					System.out.println("the student ID is: " + studentId);
					
					//read the student ID
					Student myStudent = session1.get(Student.class, studentId);
					System.out.println("Student info that was retrieved: " + myStudent.toString());
					
					// update the student name
					myStudent.setFirstName("Kenny");
					myStudent.setEmail("Kenny@codeworld.com");
					
					// commit the transaction
					session1.getTransaction().commit();
					
					
				}finally{
					factory.close();
				}

	}

}
