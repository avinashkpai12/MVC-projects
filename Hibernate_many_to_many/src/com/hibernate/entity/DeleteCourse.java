
package com.hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourse {
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
		{    session.beginTransaction();
		     int courseId=12;
		     Course course=session.get(Course.class,courseId);
		     session.delete(course);
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
