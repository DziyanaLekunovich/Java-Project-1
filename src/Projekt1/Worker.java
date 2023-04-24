package Projekt1;

import java.time.LocalDate;

public abstract class Worker extends Person{
	int id;
	double salary;
	boolean isActive = true;
	
	public Worker(String n, String s, LocalDate d, int id, double salary) {
		super(n, s, d);
		this.id = id;
		this.salary = salary;
	}
	
	public abstract void data();
	
	public double salary() {
		if (isActive) {
			double s = salary;
			double e, r, c, z, p, result;
			e = 0.0976 * s;
			r = 0.015 *s ;
			c = 0.0245 * s;
			z = 0.09 * (s - e - r - c);
			p = 0.12 * (s - e - r - c - 250);
			p = Math.round(p);
			result = s - e - r - c - z - p;
			
			return Math.round(result * Math.pow(10, 2)) / Math.pow(10, 2);
		}
		return -1;
	}
	
	public void setSalary(double s) {
		salary = s;
	}
	
	public void setIsActive() {
		isActive = !isActive;
	}
	
	public String getSubject() {
		if (this instanceof Teacher)
			return this.getSubject();
		else
			return "";
	}
	
	public int getId() {
		return id;
	}
}
