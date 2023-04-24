package Projekt1;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class Secretary extends NonDidactive{
	public Secretary(String n, String s, LocalDate d, int id, double salary) {
		super(n, s, d, id, salary);
	}
	
	public void data() {
		System.out.println("Secretary: " + name + " " + surname + ", date of birth: " + dateOfBirth + ", id: " + id + ", salary: " + salary + ", " + (isActive ? "active" : "not active"));
	}
	
	public void findDirector(Worker[] workers) {
		for (int i = 0; i < workers.length; i++) {
			if (workers[i] instanceof Director) {
				workers[i].data();
				break;
			}
		}
	}
	
	public Director findDirector2(Worker[] workers) {
		for (int i = 0; i < workers.length; i++) {
			if (workers[i] instanceof Director) {
				return (Director) workers[i];
			}
		}
		return null;
	}
	
	public void findViceDirector(Worker[] workers) {
		for (int i = 0; i < workers.length; i++) {
			if (workers[i] instanceof ViceDirector) {
				workers[i].data();
				break;
			}
		}
	}
	
	public ViceDirector findViceDirector2(Worker[] workers) {
		for (int i = 0; i < workers.length; i++) {
			if (workers[i] instanceof ViceDirector) {
				return (ViceDirector) workers[i];
			}
		}
		return null;
	}
	
	public void findTeacher(Worker[] workers, String sub) {
		for (int i = 0; i < workers.length; i++) {
			if (workers[i] instanceof Teacher) {
				if (workers[i].getSubject().equals(sub)) {
					workers[i].data();
					break;
				}
			}
		}
	}
	
	public void findWorker(Worker[] workers, int id) {
		for(int i = 0; i < workers.length; i++) {
			if (workers[i].getId() == id) {
				workers[i].data();
				break;
			}
		}
	}
	
	public Worker findWorker2(Worker[] workers, int id) {
		for(int i = 0; i < workers.length; i++) {
			if (workers[i].getId() == id) {
				return workers[i];
			}
		}
		return null;
	}
	
	public Teacher findWorker3(Worker[] workers, int id) {
		for(int i = 0; i < workers.length; i++) {
			if (workers[i].getId() == id) {
				return (Teacher) workers[i];
			}
		}
		return null;
	}
	
	public boolean findTeacher2(Worker[] workers, String sub) {
		for (int i = 0; i < workers.length; i++) {
			if (workers[i] instanceof Teacher) {
				if (workers[i].getSubject().equals(sub)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void teachersForClass(Worker[] workers, ClassInSchool c) {
		String[] subjects = new String[c.getListOfSubjects().length];
		for (int i = 0; i < c.getListOfSubjects().length; i++) {
			if (!this.findTeacher2(workers, c.getListOfSubjects()[i]))
				subjects[i] = c.getListOfSubjects()[i];		
		}
		boolean isEmpty = true;
		for(int i = 0; i < subjects.length; i++) {
			if(subjects[i] != null) {
				isEmpty = false;
				break;
			}
		}
		if(isEmpty) {
			System.out.println("The are teachers for all subjects of class(" + c.getNumber() + ")");
		}
		else {
			System.out.println("No teacher of class(" + c.getNumber() + ") for subject(s): ");
			for (int i = 0; i < subjects.length;i++) {
				if (subjects[i] != null)
					System.out.println(subjects[i]);
			}
		}
	}
	
	public void registratePupil() {
		Scanner scan = new Scanner(System.in);
		
		String nameP, surnameP;
		
		try {
			System.out.println("Enter name of pupil:");
			nameP = scan.nextLine();
			for(int i = 0; i < nameP.length(); i++) {
				if (Character.isDigit(nameP.charAt(i)))
					throw new WrongFormatException();
			}
		}
		catch(WrongFormatException e) {
			System.err.println("Name contains digit");
			return;
		}
		
		
		try {
			System.out.println("Enter surname of pupil:");
			surnameP = scan.nextLine();
			for(int i = 0; i < surnameP.length(); i++) {
				if (Character.isDigit(surnameP.charAt(i)))
					throw new WrongFormatException();
			}
		}
		catch(WrongFormatException e) {
			System.err.println("Surname contains digit");
			return;
		}
		
		
		int year, month,day;
		while(true) {
			try {
				System.out.println("Enter year of your birth");
				year = scan.nextInt();
				if (! (year > 1922 && year < 2022))
					throw new WrongFormatException();
				break;
			}
			catch(WrongFormatException e) {
				System.err.println("Wrong year of birth number");
				return;
			}
		}
		
		while(true) {
			try {
				System.out.println("Enter month of your birth");
				month = scan.nextInt();
				if (! (month > 0 && month < 13))
					throw new WrongFormatException();
				break;
			}
			catch(WrongFormatException e) {
				System.err.println("Wrong month of birth number");
				return;
			}
		}
		
		Month m = Month.of(month);
			
		while(true) {
			try {
				System.out.println("Enter day of your birth");
				day = scan.nextInt();
				if (! (day > 0 && day < m.maxLength()))
					throw new WrongFormatException();
				break;
			}
			catch(WrongFormatException e) {
				System.err.println("Wrong day of birth number");
				return;
			}
		}
		
		LocalDate bd = LocalDate.of(year, month, day);
		
		int c;
		try {
			c = 2008 - bd.getYear();
			if (c < 1 || c > 4)
				throw new WrongFormatException();
			Pupil p = new Pupil(nameP, surnameP, bd, c);
			p.data();
		}
		catch(WrongFormatException e) {
			System.err.println("Year of birth out of range 2004-2007");
			return;
		}
	}
	
	public void work(Worker[] workers, ClassInSchool[] classes) {
		while(true) {
			System.out.println("a.print worker");
			System.out.println("b.print salary");
			System.out.println("c.change salary");
			System.out.println("d.fire worker");
			System.out.println("e.can teacher work in class");
			System.out.println("f.can teachers teach the same subject");
			System.out.println("g.print report about missing teachers");
			System.out.println("h.register pupil");
			System.out.println("i.end");
			Scanner scan1 = new Scanner(System.in);
			String letter;
			letter = scan1.nextLine();
			switch(letter) {
			case "a" -> {
				System.out.println("Enter id of worker: ");
				int id = scan1.nextInt();
				this.findWorker(workers, id);
			}
			case "b" -> {
				System.out.println("Enter id of worker: ");
				int id = scan1.nextInt();
				if (this.findWorker2(workers, id).salary() != -1)
					System.out.println("Worker(" + id + ") has salary: " + this.findWorker2(workers, id).salary());
				else
					System.out.println("Worker(" + id + ") is not active");
			}
			case "c" -> {
				System.out.println("Enter id of worker: ");
				int id = scan1.nextInt();
				System.out.println("Enter new salary: ");
				double pensja = scan1.nextDouble();
				if (this.findWorker2(workers, id) instanceof Teacher || this.findWorker2(workers, id) instanceof ViceDirector) {
					this.findDirector2(workers).changeSalary(this.findWorker2(workers, id), pensja);
				}
				else if (this.findWorker2(workers, id) instanceof NonDidactive) {
					this.findViceDirector2(workers).changeSalary(this.findWorker2(workers, id), pensja);
				}
			}
			case "d" -> {
				System.out.println("Enter id of worker: ");
				int id = scan1.nextInt();
				if (this.findWorker2(workers, id) instanceof Teacher || this.findWorker2(workers, id) instanceof ViceDirector) {
					this.findDirector2(workers).dismiss(this.findWorker2(workers, id));
				}
				else if (this.findWorker2(workers, id) instanceof NonDidactive) {
					this.findViceDirector2(workers).dismiss(this.findWorker2(workers, id));;
				}
			}
			case "e" -> {
				System.out.println("Enter id of teacher: ");
				int id = scan1.nextInt();
				System.out.println("Enter number of class: ");
				int klasa = scan1.nextInt();
				if(this.findWorker3(workers, id).canWorkInClass(classes[klasa - 1]))
					System.out.println("Teacher(" + id + ") can teach in class(" + klasa + ")");
				else
					System.out.println("Teacher(" + id + ") can't teach in class(" + klasa + ")");
			}
			case "f" -> {
				System.out.println("Enter id of first teacher: ");
				int id1 = scan1.nextInt();
				System.out.println("Enter id of second teacher: ");
				int id2 = scan1.nextInt();
				if (this.findWorker3(workers, id1).sameSubjectTeacher(this.findWorker3(workers, id2)))
					System.out.println("Both teachers teach the same subject");
				else
					System.out.println("Tecaher(" + id1 + ") and teacher(" + id2 + ") teach different subjects");
			}
			case "g" -> {
				for (int i = 0; i < classes.length; i++) {
					this.teachersForClass(workers, classes[i]);
				}
			}
			case "h" -> {
				this.registratePupil();
				
			}
			case "i" -> {
				scan1.close();
				return;
			}
			}
		}
	}
}