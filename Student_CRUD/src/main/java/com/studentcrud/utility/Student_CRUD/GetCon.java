package com.studentcrud.utility.Student_CRUD;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class GetCon {

	private static SessionFactory sf;

	private static SessionFactory con() {

		Configuration cf = new Configuration();
		Properties prop = new Properties();

		prop.put(Environment.USER, "root");
		prop.put(Environment.PASS, "N@9738660226");
		prop.put(Environment.URL, "jdbc:mysql//localhost:3306/newdb");
		prop.put(Environment.HBM2DDL_AUTO, "create");
		prop.put(Environment.DIALECT, "MySQL8Dialect");
		prop.put(Environment.SHOW_SQL, "true");

		cf.setProperties(prop);

		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cf.getProperties()).build();

		sf = cf.buildSessionFactory();

		return sf;
	}

}
