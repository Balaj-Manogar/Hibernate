package org.baali.test;

import org.baali.ksl.Constituency;
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
		tn.setName("Tamil Nadu");
		tn.setIsUnionTerritory(0);
		
		
		Constituency arni = new Constituency();
		arni.setcName("Arni");
		arni.setResultStatus(1);
		arni.setConsId(11);
		
		
		Constituency vellore = new Constituency();
		vellore.setcName("Vellore");
		vellore.setConsId(10);
		vellore.setResultStatus(1);
		
		
		tn.getConstituency().add(vellore);
		tn.getConstituency().add(arni);
		
		
		//tn.setSid(1);
		

		session.beginTransaction();
		session.save(tn);
		session.getTransaction().commit();
		session.close();

	}

}