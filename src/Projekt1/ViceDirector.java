package Projekt1;

import java.time.LocalDate;

public class ViceDirector extends NonDidactive implements Interface{
	public ViceDirector(String n, String s, LocalDate d, int id, double salary) {
		super(n, s, d, id, salary);
	}
	
	public void data() {
		System.out.println("ViceDirector: " + name + " " + surname + ", date of birth: " + dateOfBirth + ", id: " + id + ", salary: " + salary + ", " + (isActive ? "active" : "not active"));
	}
	
	public void changeSalary(Worker w, double s) {
		if (w instanceof NonDidactive ) {
			w.setSalary(s);
		}
		else
			System.out.println("Vice-director can change salary only of non-didactive worker!");
	}
	
	public void dismiss(Worker w) {
		if (w instanceof NonDidactive ) {
			w.setIsActive();
		}
		else
			System.out.println("Vice-director can dismiss only non-didactive worker!");
	}
}