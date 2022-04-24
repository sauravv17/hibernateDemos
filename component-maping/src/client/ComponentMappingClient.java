package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Address;
import entity.Person;
import util.HibernateUtil;


public class ComponentMappingClient {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Address homeAddress=new Address("25, MainStreet","NYC","201307");
		Address billingAddress=new Address("25, MainStreet","NYC","201307");

		Person sam = new Person("Sam",homeAddress,billingAddress);
		
		session.save(sam);
		
		session.getTransaction().commit();
		
		session.close();
	}
}
