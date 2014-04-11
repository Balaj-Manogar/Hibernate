package org.baali.test;

import org.baali.ksl.Constituency;
import org.baali.ksl.District;
import org.baali.ksl.States;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class State_Constituency_District_Test
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
		Constituency con1 = new Constituency();
		Constituency con2 = new Constituency();
		District dist1 = new District();
		District dist2 = new District();
		
		
		tn.setName("TN");
		tn.setIsUnionTerritory(0);		
		
		con1.setcName("Arni");
		con1.setResultStatus(1);		
		con1.setState(tn);			
		
		con2.setcName("Vellore");		
		con2.setResultStatus(1);
		con2.setState(tn);
		
		dist1.setName("Thiruvannamalai Dist");
		dist1.setState(tn);
		dist2.setName("Vellore Dist");
		dist2.setState(tn);
		
		tn.getConstituency().add(con2);
		tn.getConstituency().add(con1);
		
		tn.getDistrict().add(dist1);
		tn.getDistrict().add(dist2);
		
		
		//tn.setSid(1);
		

		session.beginTransaction();
		session.save(tn);
		
		session.save(con1);
		session.save(con2);
		
		session.save(dist1);
		session.save(dist2);
		
		session.getTransaction().commit();
		session.close();

	}

}