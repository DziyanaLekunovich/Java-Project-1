package Projekt1;

import java.time.LocalDate;

public abstract class Person {
	String name;
	String surname;
	LocalDate dateOfBirth;
	
	public Person(String n, String s, LocalDate d) {
		this.name = n;
		this.surname = s;
		this.dateOfBirth = d;
	}
	
	public abstract void data(); 
}
