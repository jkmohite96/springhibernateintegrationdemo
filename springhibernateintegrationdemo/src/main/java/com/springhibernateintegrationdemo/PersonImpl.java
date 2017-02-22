package com.springhibernateintegrationdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonImpl {

	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public void save(Person p) {
		System.out.println(p.getCountry());
		System.out.println(p.getId());
		System.out.println(p.getName());
		
		p.setName("yyyyyX");
		p.setCountry("India...");
		
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(p);
		session.flush();
		tx.commit();
		session.close();
	}
	
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		PersonImpl personDAO = context.getBean(PersonImpl.class);
		personDAO.save((Person)context.getBean("person"));
	}
	
}
