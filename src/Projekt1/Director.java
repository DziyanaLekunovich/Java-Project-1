package Projekt1;

import java.time.LocalDate;

public class Director extends Teacher implements Interface{
	public Director(String n, String s, LocalDate d, int id, double salary, String sub) {
		super(n, s, d, id, salary, sub);
	}
	
	public void data() {
		System.out.println("Director: " + name + " " + surname + ", date of birth: " + dateOfBirth + ", id: " + id + ", salary: " + salary + ", " + (isActive ? "active" : "not active"));
	}
	
	public void changeSalary(Worker w, double s) {
		if (w instanceof Teacher || w instanceof ViceDirector) {
			w.setSalary(s);
		}
		else
			System.out.println("Director can change salary only of teacher or vice-director!");
	}
	
	public void dismiss(Worker w) {
		if (w instanceof Teacher || w instanceof ViceDirector) {
			w.setIsActive();
		}
		else
			System.out.println("Director can dismiss only teacher or vice-director!");
	}
	
}