package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Guide;
import entity.Student;
import util.HibernateUtil;


public class MappingAssociationsClient {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Guide max=new Guide("ABC112","Max Wilson",10000);
		Student john =new Student("118120A","John Carter",max);
		Student jerry =new Student("118120B","Jerry Williams",max);
		
		Guide merry=new Guide("ABC113","Merry Warner",10500);
		Student maria =new Student("11802C","Maria Wills",merry);

		session.save(max);
		session.save(john);
		session.save(jerry);
		
		session.save(merry);
		session.save(maria);

		session.getTransaction().commit();
		
		session.close();
	}
}
