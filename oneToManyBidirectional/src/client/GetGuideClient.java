package client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Guide;
import entity.Student;
import util.HibernateUtil;


public class GetGuideClient {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Guide guide = session.get(Guide.class, 3L);
		System.out.println(guide);
		List<Student> student= guide.getStudents();
		System.out.println(student);
		
		session.getTransaction().commit();
		
		session.close();
	}
}
