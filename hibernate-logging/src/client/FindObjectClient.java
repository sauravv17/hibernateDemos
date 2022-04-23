package client;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Message;
import util.HibernateUtil;

public class FindObjectClient {

	public static void main(String[] args) {
	
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();
		
		try {
			
			txn.begin();
			Message message = session.get(Message.class,12L);
			System.out.println(message);
			message.setText("welcome to automatic dirty checking");
			txn.commit();
			
		}catch (Exception ex) {
			
		}
		
}


}

