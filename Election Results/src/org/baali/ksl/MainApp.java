package org.baali.ksl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MainApp
{// this class include all objects and stores in db
	public static void main(String[] args)
	{
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		
		/* Object initialization properties */
		Candidate can1 = new Candidate();
		can1.setGender("male");
		can1.setName("Balaji");
		
		Constituency constituency = new Constituency();
		constituency.setcName("Arani");
		constituency.getCandidate().add(can1);
		
		Party party = new Party();
		party.setName("IPP");
		party.getCandidate().add(can1);
		
		Group group = new Group();
		group.setName("IPG");
		group.getParty().add(party);
		
		party.setGroup(group);
		
		District district = new District();
		district.setName("Thiruvannamalai District");
		district.getConstituency().add(constituency);
		
		States state = new States();
		state.setName("Tamil Nadu");
		state.setIsUnionTerritory(0);
		state.getConstituency().add(constituency);
		state.getDistrict().add(district);
		
		district.setState(state);
		constituency.setDistrict(district);
		constituency.setState(state);
		
		can1.setParty(party);
		can1.setConstituency(constituency);
		
		/* DB operations */
		session.beginTransaction();		
		session.save(district);
		session.save(can1);
		session.save(constituency);
		session.save(state);		
		session.save(party);
		session.save(group);		
		
		session.getTransaction().commit();
		session.close();
		
		
		
		
	}
}
