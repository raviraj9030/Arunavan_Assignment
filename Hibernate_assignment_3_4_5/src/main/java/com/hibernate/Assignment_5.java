package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.model.Asset;
import com.model.Employee;
import com.util.HibernateUtil;

public class Assignment_5 {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		// insert(session);
		//read(session);
		//delete(session);
		update(session);

		session.getTransaction().commit();
	}
	
	private static void update(Session session) {
		Employee employee = session.get(Employee.class, 101);
		employee.setPassword("aaaaaa");
		session.saveOrUpdate(employee);
	}
	
	private static void delete(Session session) {
		Employee employee = session.get(Employee.class, 10);
		session.remove(employee);
	}


	private static void insert(Session session) {
		// Asset asset = new Asset(101, 111111, 44444, "Mobile", 1234, "Kolkata");
		Asset asset = new Asset(1010, 22222, 55555, "Laptop", 5678, "Dehli");
		// Employee employee = new Employee("ravi", 101, "ravi123", asset);
		Employee employee = new Employee("shinu", 10, "Shinu123", asset);
		session.save(asset);
		session.save(employee);

	}

	private static void read(Session session) {
		Asset a1 = session.get(Asset.class, 101);
		System.out.println(a1);

		Asset a2 = session.load(Asset.class, 1010);
		System.out.println(a2);

		// Max
		Query q1 = session.createQuery("select MAX(assrtPrice) from Asset");
		System.out.println(q1.list());

		// Order By
		Query q2 = session.createQuery("from Employee e Order by e.empId ASC");
		System.out.println(q2.list());

		// Average
		Query q3 = session.createQuery("select AVG(assrtPrice) from Asset");
		System.out.println(q3.list());

		// Count
		Query q4 = session.createQuery("select COUNT(*) from Employee");
		System.out.println(q4.list());

	}
}
