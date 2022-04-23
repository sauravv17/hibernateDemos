package client;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import entity.Message;
import util.HibernateUtil;

public class HelloWorldClient {
	static Logger logger=Logger.getLogger(HelloWorldClient.class.getName());

		public static void main(String[] args) {
		
			Session session = HibernateUtil.getSessionFactory().openSession();
			logger.trace("Retrived session factory");
			session.beginTransaction();
			logger.trace("began transaction");
			
			Message message = new Message("annotation mapping again");
			
			session.save(message);
			logger.trace("message saved");
			
			session.getTransaction().commit();
			logger.trace("transaction committed");
			session.close();
	}
	

}
