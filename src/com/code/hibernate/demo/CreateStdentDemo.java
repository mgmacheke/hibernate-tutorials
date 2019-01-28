package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.entity.Student;

public class CreateStdentDemo {

	public static void main(String[] args) {
		// create sessionFactor
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
				
				//create session
				Session session = factory.getCurrentSession();
				
				try{
					
					// create the student object
					System.out.println( "Creating a new student obect");
					Student theStudent = new Student("Musa","Macheke","musa@codeworld.com");
					
					//start transaction
					session.beginTransaction();
					
					// save the object
					System.out.println("Saving the student object");
					session.save(theStudent);
					
					// commit the transaction
					session.getTransaction().commit();
				}finally{
					factory.close();
				}

	}

}
