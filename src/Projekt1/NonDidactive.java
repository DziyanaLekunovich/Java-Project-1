package Projekt1;

import java.time.LocalDate;

public class NonDidactive extends Worker{
	public NonDidactive(String n, String s, LocalDate d, int id, double salary) {
		super(n, s, d, id, salary);
	}
	
	public void data() {
		System.out.println("Non-didactive-worker: " + name + " " + surname + ", date of birth: " + dateOfBirth + ", id: " + id + ", salary: " + salary + ", " + (isActive ? "active" : "not active"));
	}
	
	
}
