package org.baali.test;

import java.util.List;

import org.dummy.DummyUser;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class DummyUserGetTest
{

	public static void main(String[] args)
	{
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();		
		
		DummyUser user;
		Query q = session.createQuery("from DummyUser where id = 12");
		List<DummyUser> userList =(List<DummyUser>)  q.list();
		DummyUser newUser = (DummyUser)userList.get(0);
		newUser.setName("New User");
		session.save(newUser);
		session.getTransaction().commit();
		session.close();
		
		
		System.out.println(newUser.getId() + ": " + newUser.getName());
		
	}

}
