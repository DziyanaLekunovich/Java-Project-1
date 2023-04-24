package Projekt1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class TeacherTest {

	@Test
	void sameSubjectTeacherTest1() {
		Teacher t1 = new Teacher("Anna", "Kowalska", LocalDate.of(1986, 03, 25), 5, 3000, "Math");
		Teacher t2 = new Teacher("Maria", "Nehaj", LocalDate.of(1993, 01, 04), 6, 3200, "Math");
		assertEquals(true, t1.sameSubjectTeacher(t2));
	}
	
	@Test
	void sameSubjectTeacherTest2() {
		Teacher t1 = new Teacher("Anna", "Kowalska", LocalDate.of(1986, 03, 25), 5, 3000, "Math");
		Teacher t2 = new Teacher("Maria", "Nehaj", LocalDate.of(1993, 01, 04), 6, 3200, "English");
		assertEquals(false, t1.sameSubjectTeacher(t2));
	}
	
	@Test
	void canWorkInClassTest1() {
		Teacher t1 = new Teacher("Anna", "Kowalska", LocalDate.of(1986, 03, 25), 5, 3000, "Math");
		String[] subjects = {"Math", "Polish", "PE", "Music", "Biology"};
		ClassInSchool clas = new ClassInSchool(2, subjects);
		assertEquals(true, t1.canWorkInClass(clas));
	}
	
	@Test
	void canWorkInClassTest2() {
		Teacher t1 = new Teacher("Anna", "Kowalska", LocalDate.of(1986, 03, 25), 5, 3000, "Math");
		String[] subjects = {"Polish", "PE", "Math", "Music", "Biology"};
		ClassInSchool clas = new ClassInSchool(2, subjects);
		assertEquals(true, t1.canWorkInClass(clas));
	}
	
	@Test
	void canWorkInClassTest3() {
		Teacher t1 = new Teacher("Anna", "Kowalska", LocalDate.of(1986, 03, 25), 5, 3000, "Math");
		String[] subjects = {"Polish", "PE", "Music", "Biology", "Math"};
		ClassInSchool clas = new ClassInSchool(2, subjects);
		assertEquals(true, t1.canWorkInClass(clas));
	}
	
	@Test
	void canWorkInClassTest4() {
		Teacher t1 = new Teacher("Anna", "Kowalska", LocalDate.of(1986, 03, 25), 5, 3000, "English");
		String[] subjects = {"Math", "Polish", "PE", "Music", "Biology"};
		ClassInSchool clas = new ClassInSchool(2, subjects);
		assertEquals(false, t1.canWorkInClass(clas));
	}

}
