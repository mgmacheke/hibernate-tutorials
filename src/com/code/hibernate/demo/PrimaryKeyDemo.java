package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try{
			
			// create the student object
			System.out.println( "Creating a 3 student obect");
			Student theStudent1 = new Student("John","Doe","John@codeworld.com");
			Student theStudent2 = new Student("Jane","Doe","Jane@codeworld.com");
			Student theStudent3 = new Student("Micheal","Jackson","Micheal@codeworld.com");
			
			//start transaction
			session.beginTransaction();
			
			// save the object
			System.out.println("Saving the student object");
			session.save(theStudent1);
			session.save(theStudent2);
			session.save(theStudent3);
			
			// commit the transaction
			session.getTransaction().commit();
		}finally{
			factory.close();
		}

 }

}
