package com.studentdata;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		// configuring hibernate
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();

		// to create table and storing values
		Transaction tr = s.beginTransaction();

		// creating a student objects to store values
		Student s1 = new Student(01, "Nandan", 23, "Java ");
		Student s2 = new Student(02, "sandeep", 22, ".net ");
		Student s3 = new Student(03, "manoj", 21, "python ");
		Student s4 = new Student(04, "rakesh", 24, "C++ ");
		s.save(s1);
		s.save(s2);
		s.save(s3);
		s.save(s4);

		System.out.println("Table created and data is saved..........");

//		// to retrive data and update data
//		Student s1 = s.get(Student.class, 1);
//		s1.setStudent_Name("Nandan.k");
//		s.update(s1);
//		tr.commit();
//		System.out.println("updated Data of " + s1);

//		// to delete data 
//		Student s2 = s.get(Student.class, 2);
//		s.delete(s2);

		tr.commit();
		s.save(s2);

	}
}
