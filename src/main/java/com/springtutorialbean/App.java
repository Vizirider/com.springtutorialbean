package com.springtutorialbean;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args)
	{
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springtutorialbean/beans/beans.xml");
		
		//Person person = (Person)context.getBean("person");
		
		OffersDAO offersDao = (OffersDAO)context.getBean("offersDao");
		
		List<Offer> offers = offersDao.getOffers();
		
		for(Offer offer: offers) {
			System.out.println(offer);
		}
		
		//System.out.println(person);
		/*
		Address address2 = (Address)context.getBean("address2");
		System.out.println(address2);
		*/
		((ClassPathXmlApplicationContext)context).close();
	}
	
}
