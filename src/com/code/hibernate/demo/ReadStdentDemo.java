package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.entity.Student;

public class ReadStdentDemo {

	public static void main(String[] args) {
		// create sessionFactor
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
				
				//create session
				Session session = factory.getCurrentSession();
				
				try{
					
					// create the student object
					System.out.println( "Creating a new student obect");
					Student theStudent = new Student("Donald","Duck","Donald@codeworld.com");
						
					//start transaction
					session.beginTransaction();
					
					// Save the student the object
					System.out.println("Saving the student object");
					session.save(theStudent);
					
					// commit the transaction
					session.getTransaction().commit();
					
					//create a new session and start transaction
					Session session1 = factory.getCurrentSession();
					session1.beginTransaction();
					
					// get the current student id
					System.out.println("the student ID is: " + theStudent.getId());
					
					//read the student ID
					Student myStudent = session1.get(Student.class, theStudent.getId());
					System.out.println("Student info that was retrieved: " + myStudent.toString());
					
					// commit the transaction
					session1.getTransaction().commit();
					
					
				}finally{
					factory.close();
				}

	}

}
