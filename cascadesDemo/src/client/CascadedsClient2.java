package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Guide;
import entity.Student;
import util.HibernateUtil;


public class CascadedsClient2 {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Guide guide = session.get(Guide.class, 3L);
//		Assign a guide which is already present in db
		Student johny =new Student("118120F","Johny Well",guide);
		
		session.persist(johny);
		session.getTransaction().commit();
		
		session.close();
	}
}
