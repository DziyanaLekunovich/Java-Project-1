package Projekt1;

import java.time.LocalDate;

public class Pupil extends Person{
	int classInSchool;
	
	public Pupil(String n, String s, LocalDate d, int c) {
		super(n, s, d);
		this.classInSchool = c;
	}
	
	public void data() {
		System.out.println("Pupil: " + name + " " + surname + ", date of birth: " + dateOfBirth + ", class: " + classInSchool);
	}
}
