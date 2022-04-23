package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Message;
import util.HibernateUtil;

public class TaskUpdateClient {

public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();
		
		try {
			
			txn.begin();
			Message message = session.get(Message.class,13L);
			System.out.println(message);
			txn.commit();
			session.close();
			
			message.setText("Changed - " + message.getText());
			
			Session session2 = HibernateUtil.getSessionFactory().openSession();
			session2.getTransaction().begin();
			session2.update(message);
			session2.getTransaction().commit();
			session2.close();
			
		}catch (Exception ex) {
			
		}
	}
}
