package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Guide;
import entity.Student;
import util.HibernateUtil;


public class CascadedsClient {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Guide gandhi=new Guide("ABC1232","Gandhi Kishu",100000);
		Student john =new Student("11812220SS","John Walker",gandhi);

		session.persist(john);
		session.getTransaction().commit();
		
		session.close();
	}
}
