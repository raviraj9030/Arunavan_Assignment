package com.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.util.HibernateUtil;

public class Assgnment_3 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		/*
		 * Director d1 = new Director("D101", "Chris Columbus", 1958); Director d2 = new
		 * Director("D102", "Patric Read Johnson", 1958); Director d3 = new
		 * Director("D103", "Amir Khan", 1958); Director d4 = new Director("D104",
		 * "R. Balki", null);
		 * 
		 * Movie m1 = new Movie("M1001", "Home Alone", "English", 1990, 4767, d1); Movie
		 * m2 = new Movie("M1002", "Home Alone", "English", 1992, 3589, d1); Movie m3 =
		 * new Movie("M1003", "Baby's Day Out", "English", 1994, 1680, d2); Movie m4 =
		 * new Movie("M1004", "Taare Zameen Par", "Hindi", 2007, 1300, d3); Movie m5 =
		 * new Movie("M1005", "Paa", "Hindi", 2009, 4700, d4);
		 * 
		 * session.save(m1); session.save(m2); session.save(m3); session.save(m4);
		 * session.save(m5);
		 */

		// Display the details of the movies whose language matches the received value.
		String language = "English";
		String str1 = "from Movie m where m.language = :lan";
		Query q1 = session.createQuery(str1);
		q1.setString("lan", language);
		List list = q1.list();
		for (Object l : list) {
			// System.out.println(l.toString());
		}

		// Display the details of movies for the given director
		String str2 = "from Movie where director_directorID='D101'";
		Query q2 = session.createQuery(str2);
		List list2 = q2.list();
		for (Object l : list2) {
			//System.out.println(l.toString());
		}

		// Add records whose language is English to the new table 'Hollywood'. Use the
		// Session API's save() method.
		/*
		 * String str3 =
		 * "select movieId, movieName, language, releasedIn, revenueInDollars from Movie where language='English'"
		 * ; Query q3 = session.createQuery(str3); List<Object[]> list3 = q3.list();
		 * for(Object[] l : list3) { HollywoodMovie hm = new HollywoodMovie();
		 * hm.setMovieId((String) l[0]); hm.setMovieName((String) l[1]);
		 * hm.setLanguage((String) l[2]); hm.setReleasedIn((Integer) l[3]);
		 * hm.setRevenueInDollars((Integer) l[4]); //session.save(hm); }
		 */

		
		//Increment the revenue of the received movie by 100000 dollars
		String str4 = "update Movie set revenueInDollars = revenueInDollars + 2233 where movieId = :movieId";
		Query q4 = session.createQuery(str4);
		q4.setParameter("movieId", "M1001");
		//int result = q4.executeUpdate();
		
		
		//Delete the record corresponding to the movie name received.
		Query q5=session.createQuery("delete from Movie where movieId='M1005'");  
		//q5.executeUpdate();  
		
		//Retrieve the list of distinct languages available in the database.
		//Criteria c = session.createCriteria( Movie.class );
		//c.setProjection( Projections.distinct( Projections.property( "language")));
		//System.out.println(c.list());
		//or
		Query q6=session.createQuery("select DISTINCT(language) from Movie");
		List resultList = q6.getResultList();
		//System.out.println(resultList);
		
		Query q7 = session.createQuery("select m.movieName, m.director.directorName from Movie m");
		List<Object[]> list7 = q7.list();
		System.out.println("\nMovie Name -- \t\tDirector Name -- ");
		for(Object[] string : list7) {
			System.out.println(string[0]+"\t\t"+string[1]);
		}
		t.commit();
		session.close();
	}
}
