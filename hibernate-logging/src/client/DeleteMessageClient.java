package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Message;
import util.HibernateUtil;

public class DeleteMessageClient {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();
		
		try {
			
			txn.begin();
			Message message = session.get(Message.class,12L);
			session.delete(message);
			txn.commit();
			
		}catch (Exception ex) {
			
		}
	}
}


