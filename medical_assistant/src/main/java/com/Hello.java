package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Hello {
	public static void main(String[] args) {
			Configuration con=new Configuration().configure();
			ServiceRegistry sr=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
	        SessionFactory factory=con.buildSessionFactory(sr);
	        Session session=factory.openSession();
	        Transaction ts=session.beginTransaction();
	}
}
