package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

public abstract class RadnjaTest {

	protected Radnja radnja;

	@Test
	void testDodajGumu() {
		AutoGuma a = new AutoGuma("195/50ZR20", 20, 195, 80);

		radnja.dodajGumu(a);

		assertEquals(1, radnja.vratiSveGume().size());
		assertEquals(a, radnja.vratiSveGume().get(0));
	}

	@Test
	void testDodajGumuNull() {
		assertThrows(java.lang.NullPointerException.class, () -> radnja.dodajGumu(null));
	}

	@Test
	void testDodajGumuDuplikat() {
		AutoGuma a = new AutoGuma("195/50ZR20", 20, 195, 80);
		AutoGuma a1 = new AutoGuma("195/50ZR20", 20, 195, 80);

		radnja.dodajGumu(a);
		assertThrows(java.lang.RuntimeException.class, () -> radnja.dodajGumu(a1));
	}

	@Test
	void testPronadjiGumu() {
		AutoGuma a1 = new AutoGuma();
		a1.setMarkaModel("195/50ZR20");

		radnja.dodajGumu(a1);

		List<AutoGuma> pom = radnja.pronadjiGumu(a1.getMarkaModel());
		assertTrue(pom.contains(a1));
	}

	@Test
	void testPronadjiGumuNull() {
		assertEquals(null, radnja.pronadjiGumu(null));
	}
	
	@Test
	void testPronadjiGumuNijedna() {
		AutoGuma a1 = new AutoGuma();
		a1.setMarkaModel("195/50ZR20");
		AutoGuma a2 = new AutoGuma();
		a2.setMarkaModel("195/65HJI0");
		
		radnja.dodajGumu(a1);
		
		assertEquals(0, radnja.pronadjiGumu(a2.getMarkaModel()).size());
	}
	
	@Test
	void testPronadjiGumuViseGuma() {
		AutoGuma a1 = new AutoGuma("195/50ZR20", 20, 195, 80);
		AutoGuma a2 = new AutoGuma("195/50ZR20", 19, 190, 77);
		AutoGuma a3 = new AutoGuma("195/50ZR20", 20, 160, 75);
		
		radnja.dodajGumu(a1);
		radnja.dodajGumu(a2);
		radnja.dodajGumu(a3);
		
		List<AutoGuma> pom = radnja.pronadjiGumu("195/50ZR20");
		
		assertEquals(3, pom.size());
		assertTrue(pom.contains(a1));
		assertTrue(pom.contains(a2));
		assertTrue(pom.contains(a3));
		
	}


	@Test
	void testVratiSveGume() {
		AutoGuma a1 = new AutoGuma("195/50ZR20", 20, 195, 80);
		AutoGuma a2 = new AutoGuma("195/50ZR20", 19, 190, 77);
		AutoGuma a3 = new AutoGuma("195/50ZR20", 20, 160, 75);
		
		radnja.dodajGumu(a1);
		radnja.dodajGumu(a2);
		radnja.dodajGumu(a3);
				
		assertEquals(3, radnja.vratiSveGume().size());
	}

}
