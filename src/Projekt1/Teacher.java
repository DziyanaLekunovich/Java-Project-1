package Projekt1;

import java.time.LocalDate;

public class Teacher extends Worker{
	String subject;
	
	public Teacher(String n, String s, LocalDate d, int id, double salary, String sub) {
		super(n, s, d, id, salary);
		this.subject = sub;
	}
	
	public void data() {
		System.out.println("Teacher: " + name + " " + surname + ", date of birth: " + dateOfBirth + ", id: " + id + ", salary: " + salary + ", subject: " + this.subject + ", " + (isActive ? "active" : "not active"));
	}
	
	public String getSubject() {
		return subject;
	}
	
	public int getId() {
		return id;
	}
	
	public boolean sameSubjectTeacher(Teacher t) {
		if (subject.equals(t.getSubject()))
			return true;
		return false;
	}
	
	public boolean canWorkInClass(ClassInSchool c) {
		boolean is = false;
		for(int i = 0; i < c.getListOfSubjects().length; i++) {
			if (subject.equals(c.getListOfSubjects()[i])) {
				is = true;
				break;
			}
		}
		if (is)
			return true;
		return false;
		}
}
