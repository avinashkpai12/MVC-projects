
package com.hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {
	public static void main(String[] args)
	{
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session=factory.getCurrentSession();
		try
		{       session.beginTransaction();
		       int Id=3;
		       Student tempStudent=session.get(Student.class,Id);
		       session.delete(tempStudent);
		       session.getTransaction().commit();
		
		
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally
		{
			factory.close();
		}
	
	}
}
