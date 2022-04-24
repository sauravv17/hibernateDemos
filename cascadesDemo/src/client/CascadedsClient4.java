package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Guide;
import entity.Student;
import util.HibernateUtil;


public class CascadedsClient4 {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Student student =session.get(Student.class, 4L);
		
		//delete one student one guide which is guide of other students
		student.setGuide(null);
		session.delete(student);
		session.getTransaction().commit();
		
		session.close();
	}
}
