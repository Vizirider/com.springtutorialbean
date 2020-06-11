package com.springtutorialbean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

public class App {
	
	public static void main(String[] args)
	{
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springtutorialbean/beans/beans.xml");
		
		//Person person = (Person)context.getBean("person");
		
		OffersDAO offersDao = (OffersDAO)context.getBean("offersDao");
		
		try {
			
			List<Offer> offersList = new ArrayList<Offer>();
			
			offersList.add(new Offer(1, "Vizirider", "vizirider@gmail.com", "Elegent web design"));
			
			int[] rvals = offersDao.create(offersList);
			
			for(int value: rvals)
			{
				System.out.println("Updated:" + value + "rows");
			}
			
			Offer offer1 = new Offer("kate", "kate@hobby.local", "coding is awesome");
			
			if(offersDao.create(offer1)) {
				System.out.println("Created offer object");
			}
			offersDao.delete(3);
			List<Offer> offers = offersDao.getOffers();
			
			for(Offer offer: offers) {
				System.out.println(offer);
			}
			
			Offer offer = offersDao.getOffersbyid(2);
			System.out.println("Should be john: " + offer);
			
		} catch (CannotGetJdbcConnectionException ex) {
			System.out.println("Cannot get database connection");
		}
		catch (DataAccessException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getClass());
		}
		

		//System.out.println(person);
		
		//Address address2 = (Address)context.getBean("address2");
		//System.out.println(address2);		

		
		((ClassPathXmlApplicationContext)context).close();
	}
	
}
