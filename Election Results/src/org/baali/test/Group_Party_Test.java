package org.baali.test;

import org.baali.ksl.Group;
import org.baali.ksl.Party;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Group_Party_Test
{

	public static void main(String[] args)
	{
		
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		/* OBJECT INITIALISATION */
		Party party1 = new Party();
		party1.setName("Congress");
		
		Party party2 = new Party();
		party2.setName("DMK");
		
		Group group1  = new Group();
		
		group1.setName("UPA");
		group1.getParty().add(party1);
		group1.getParty().add(party2);
		
		party1.setGroup(group1);
		party2.setGroup(group1);
		
		
		
		/* DB OPERATION */
		session.beginTransaction();
		
		session.save(party1);
		session.save(party2);
		session.save(group1);
		
		session.getTransaction().commit();
		session.close();
		
		
		

	}

}
