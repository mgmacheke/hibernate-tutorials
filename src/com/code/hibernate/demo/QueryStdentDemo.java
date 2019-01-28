package com.code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.entity.Student;

public class QueryStdentDemo {

	public static void main(String[] args) {
		// create sessionFactor
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
				
				//create session
				Session session = factory.getCurrentSession();
				
				try{
					
					//start transaction
					session.beginTransaction();
					
					// query students
					List<Student> theStudent = session.createQuery("from Student").getResultList();
					
					// display the students
					displayStudets(theStudent);
					
					// query students: lastName = Doe
					List<Student> theStudent1 = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
					
					// display the students
					System.out.println("students with last name: Doe");
					displayStudets(theStudent1);
					
					// commit the transaction
					session.getTransaction().commit();
				}finally{
					factory.close();
				}

	}

	private static void displayStudets(List<Student> theStudent) {
		for(Student tempStudent : theStudent){
			System.out.println(tempStudent);
		}
	}

}
