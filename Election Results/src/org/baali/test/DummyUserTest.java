package org.baali.test;

import java.util.ArrayList;
import java.util.List;

import org.dummy.DummyUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class DummyUserTest
{

	public static void main(String[] args)
	{
		List<DummyUser> list = new ArrayList<DummyUser>();
		String userName = "User";
		
		for(int i = 0; i < 25; i++)
		{
			DummyUser user = new DummyUser();
			user.setName(userName +  i);
			list.add(user);
		}
		System.out.println(list.size());
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();		
		
		for(int j = 0; j < list.size(); j++ )
		{
			session.save(list.get(j));
		}
		session.getTransaction().commit();
		session.close();

	}

}
