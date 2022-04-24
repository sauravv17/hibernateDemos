package client;

import org.hibernate.Session;

import entity.Guide;
import entity.Student;
import util.HibernateUtil;

public class OneToManyBidirectionalClient {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Guide gandhi=new Guide("ABC1232","Gandhi Kishu",100000);
		Student john =new Student("11812220SS","John Walker",gandhi);
		gandhi.getStudents().add(john);
		
		//persist guide and it will save student also
		session.persist(gandhi);
		session.getTransaction().commit();
		
		session.close();
	}
}
