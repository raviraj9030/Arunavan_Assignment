package com.hibernate;

import java.sql.Date;

import javax.persistence.JoinColumn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Customer;
import com.model.Locker;
import com.util.HibernateUtil;
/*
Customer -------OnetoOne -----> Locker (we are not making bidirectional (See the arrow))
here Unidirectional relation exist -- bet customer and locker means 
U can say Customer has one locker (But u can't say locker have customer)

---------------------case 1
when u use @OneToOne -- in the Customer on the field of -- private Locker locker;
Here no any child and parent relation bet customer and locker that time need to save 
both object in the dB with the help of session

---------------------case 2
But when u use @OneToOne(cascade = CascadeType.ALL) -- in the Customer on the field of -- private Locker locker;
Customer is parent and locker is child -- and need to save only customer but remember
in customer do not forget to set the locker object

@JoinColumn(name="custLockerId") -- used in customer pojo to rename the column as given name
which is foreign key of customer and primary key for locker
 */
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
