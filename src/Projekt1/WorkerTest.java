package Projekt1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class WorkerTest {
	
	@Test
	void salaryTest1() {
		Teacher t = new Teacher("Bogdan","Ulan",LocalDate.of(1965,11,15),2,4000,"English");
		assertEquals(2756.96, t.salary());
	}
	
	@Test
	void salaryTest2() {
		Director d = new Director("Anna","Tarnowska",LocalDate.of(1960,12,31),1,10000,"English");
		assertEquals(6847.39, d.salary());
	}
	
	@Test
	void salaryTest3() {
		NonDidactive n = new NonDidactive("Stefan","Libera",LocalDate.of(1965,5,1),16,3400);	
		assertEquals(2347.81, n.salary());
	}
	
	@Test
	void salaryTest4() {
		ViceDirector vd = new ViceDirector("Maria","Groszek",LocalDate.of(1990,2,15),11,7000);
		assertEquals(4801.67, vd.salary());
	}
	
	@Test
	void salaryTest5() {
		Secretary s = new Secretary("Norbert","Hel",LocalDate.of(1985,1,31),12,3900);
		assertEquals(2688.43, s.salary());
	}
	
	@Test
	void salaryTest6() {
		ViceDirector vd = new ViceDirector("Maria","Groszek",LocalDate.of(1990,2,15),11,7000);
		NonDidactive n = new NonDidactive("Stefan","Libera",LocalDate.of(1965,5,1),16,3500);	
		vd.dismiss(n);
		assertEquals(-1, n.salary());
	}
}
