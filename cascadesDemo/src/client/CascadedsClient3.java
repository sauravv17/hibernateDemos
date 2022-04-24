package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Guide;
import entity.Student;
import util.HibernateUtil;


public class CascadedsClient3 {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Student student =session.get(Student.class, 8L);
		
		//delete one student one guide
		session.delete(student);
		session.getTransaction().commit();
		
		session.close();
	}
}
