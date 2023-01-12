package com.Employe.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//this class is created to acess the configurations 
public class Connection {
	public static Session getSession() {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Employee.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		return sessionFactory.openSession();
	}
}
