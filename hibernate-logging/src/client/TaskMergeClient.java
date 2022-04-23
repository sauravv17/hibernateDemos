package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Message;
import util.HibernateUtil;

public class TaskMergeClient {
	public static void main(String[] args) {
		
	
	
	try {
		Session session1 = HibernateUtil.getSessionFactory().openSession();
		Message message1 = session1.get(Message.class,13L);
		System.out.println(message1);
		session1.getTransaction().commit();		
		session1.close();
		
		message1.setText("Changed - " + message1.getText());
		
		Session session2 = HibernateUtil.getSessionFactory().openSession();
		session2.getTransaction().begin();
		Message message2=session2.get(Message.class, 13L);
		session2.merge(message1);
		session2.getTransaction().commit();
		session2.close();
		
	}catch (Exception ex) {
		
	}
}
}



