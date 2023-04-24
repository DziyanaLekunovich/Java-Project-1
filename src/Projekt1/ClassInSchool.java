package Projekt1;

public class ClassInSchool {
	private int number;
	private String[] listOfSubjects;
	
	public ClassInSchool(int n, String[] list) {
		this.number = n;
		this.listOfSubjects = list;
	}

	public int getNumber() {
		return number;
	}

	public String[] getListOfSubjects() {
		return listOfSubjects;
	}
}
