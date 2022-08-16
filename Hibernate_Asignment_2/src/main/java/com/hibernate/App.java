package com.hibernate;

import java.sql.Date;

import javax.persistence.JoinColumn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Customer;
import com.model.Locker;
import com.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		Customer c = new Customer();
		c.setCustId(7005);
		c.setCustName("Shiva");
		c.setCustDOB(new Date(2003, 1, 5));
		c.setCustAdd("Delhi");
		c.setCustPhone("9900330022");

		Locker l = new Locker();
		l.setLockerId("loc105");
		l.setLockerType("large");
		l.setRent(1500);

		c.setLocker(l);

		
		//session.save(l); 
		System.out.println("Record inserted in Locker successfully");
		session.save(c); 
		System.out.println("Record inserted in Customer successfully");
		System.out.println("----------------------");
		Customer customer = session.get(Customer.class, 7003);
		
		System.out.println(customer);
		
		t.commit();

		session.close();

	}
}
