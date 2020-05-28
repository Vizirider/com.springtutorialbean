package com.springtutorialbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Person {
	
	private int id;
	private String name;
	private String speech = "default hello";
	private String date = "2020.05.21";
	private String taxId;
	private Address address;
	
	public static Person getInstance(int id, String name) {
		System.out.println("Creating Person using factory method.");
		return new Person(id, name);
	}
	
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void onCreate() {
		System.out.println("Person created: " + this);
	}
	
	public void onDestroy() {
		System.out.println("Person destroyed");
	}
	
	public void speak()
	{
		System.out.println("Hello person");
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}
	
	//@Autowired
	//@Value "#{randomText.getText()}")
	public void setSpeech(String speech) {
		this.speech = speech;
	}
	
	@Autowired
	// new T(Math).sin(5) operators like >, or, lt
	public void setDate(@Value("#{new java.util.Date().toString()}") String date) {
		this.date = date;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", speech=" + speech + ", date=" + date + ", taxId=" + taxId + ", address=" + address + "]";
	}

	
	
	
}
