package Projekt1;

import java.time.LocalDate;

public class MainSchool {
	public static void main(String args[]) {
		Worker[] staff = getStaff();
		ClassInSchool[] classes = getClasses();
		Secretary s = getSecretary(staff);
		if(s!=null)
			s.work(staff, classes);
	}

	private static Secretary getSecretary(Worker[] staff) {
		for(int i=0; i<staff.length; i++)
			if(staff[i] instanceof Secretary)
				return (Secretary) staff[i];
		return null;
	}

	private static ClassInSchool[] getClasses() {
		String[] s1= {"English","Polish","Math","PE","Art"};
		String[] s2= {"English","Polish","Math","PE","History"};
		String[] s3= {"English","Polish","Math","PE","Music","Geography"};
		String[] s4= {"English","Polish","Math","PE","Chemistry"};		
		ClassInSchool c1 = new ClassInSchool(1,s1); 
		ClassInSchool c2 = new ClassInSchool(2,s2); 
		ClassInSchool c3 = new ClassInSchool(3,s3); 
		ClassInSchool c4 = new ClassInSchool(4,s4);
		ClassInSchool[] classes = {c1,c2,c3,c4};
		return classes;
	}

	private static Worker[] getStaff() {
		Director d = new Director("Anna","Tarnowska",LocalDate.of(1960,12,31),1,10000,"English");
		Teacher t1 = new Teacher("Bogdan","Ulan",LocalDate.of(1965,11,15),2,4000,"English");
		Teacher t2 = new Teacher("Danuta","Wibig",LocalDate.of(1970,10,1),3,3000,"Polish");
		Teacher t3 = new Teacher("Edward","Zakrzewski",LocalDate.of(1975,9,1),4,3500,"PE"); 
		Teacher t4 = new Teacher("Filipa","Ambroziak",LocalDate.of(1980,8,15),5,4500,"Music");
		Teacher t5 = new Teacher("Gustaw","Bartoszek",LocalDate.of(1985,7,31),6,5000,"History");
		Teacher t6 = new Teacher("Halina","Chojenska",LocalDate.of(1990,6,30),7,4500,"PE");
		Teacher t7 = new Teacher("Ignacy","Dalek",LocalDate.of(1995,5,15),8,4000,"Math");
		Teacher t8 = new Teacher("Janina","Eksinska",LocalDate.of(2000,4,1),9,3500,"Biology");
		Teacher t9 = new Teacher("Karol","Fabian",LocalDate.of(1995,3,1),10,3000,"Chemistry");
		ViceDirector vd = new ViceDirector("Maria","Groszek",LocalDate.of(1990,2,15),11,7000);
		Secretary s = new Secretary("Norbert","Hel",LocalDate.of(1985,1,31),12,3500);
		NonDidactive n1 = new NonDidactive("Olga","Inuma",LocalDate.of(1980,2,29),13,2000);
		NonDidactive n2 = new NonDidactive("Piotr","Jagodzinski",LocalDate.of(1975,3,15),14,5000);
		NonDidactive n3 = new NonDidactive("Renata","Kowalska",LocalDate.of(1970,4,1),15,4000);
		NonDidactive n4 = new NonDidactive("Stefan","Libera",LocalDate.of(1965,5,1),16,3500);
		Worker[] staff= {d,t1,t2,t3,t4,t5,t6,t7,t8,t9,vd,s,n1,n2,n3,n4};
		return staff;
	}

}