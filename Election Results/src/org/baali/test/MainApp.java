package org.baali.test;

import org.baali.ksl.States;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MainApp
{

	public static void main(String[] args)
	{

		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();

		States tn = new States();
		tn.setName("Karnataka");
		tn.setSid(1);
		tn.setIsUnionTerritory(0);

		session.beginTransaction();
		session.save(tn);
		session.getTransaction().commit();
		session.close();

	}

}