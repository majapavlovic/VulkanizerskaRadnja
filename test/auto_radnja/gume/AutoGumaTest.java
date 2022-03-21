package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutoGumaTest {

	AutoGuma a;

	@BeforeEach
	void setUp() throws Exception {
		a = new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		a = null;
	}

	@Test
	void testAutoGuma() {
		assertNotNull(a);
	}

	@Test
	void testAutoGumaStringIntIntInt() {
		a = new AutoGuma("195/50ZR20", 20, 195, 80);

		assertNotNull(a);
		assertEquals("195/50ZR20", a.getMarkaModel());
		assertEquals(20, a.getPrecnik());
		assertEquals(195, a.getSirina());
		assertEquals(80, a.getVisina());
	}

	@Test
	void testSetMarkaModel() {
		a.setMarkaModel("195/50ZR20");

		assertEquals("195/50ZR20", a.getMarkaModel());
	}

	@Test
	void testSetMarkaModelNull() {
		assertThrows(java.lang.NullPointerException.class, () -> a.setMarkaModel(null));
	}

	@Test
	void testSetMarkaModelKratko() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> a.setMarkaModel("il"));
	}

	@Test
	void testSetPrecnik() {
		a.setPrecnik(20);

		assertEquals(20, a.getPrecnik());
	}

	@ParameterizedTest
	@CsvSource({ "12", "23" })
	void testSetPrecnikIzvanOpsega(int precnik) {
		assertThrows(java.lang.IllegalArgumentException.class, () -> a.setPrecnik(precnik));
	}

	@Test
	void testSetSirina() {
		a.setSirina(195);

		assertEquals(195, a.getSirina());
	}

	@ParameterizedTest
	@CsvSource({ "136", "356" })
	void testSetSirinaIzvanOpsega(int sirina) {
		assertThrows(java.lang.IllegalArgumentException.class, () -> a.setSirina(sirina));
	}

	@Test
	void testSetVisina() {
		a.setVisina(80);

		assertEquals(80, a.getVisina());
	}

	@ParameterizedTest
	@CsvSource({ "24", "96" })
	void testSetVisinaIzvanOpsega(int visina) {
		assertThrows(java.lang.IllegalArgumentException.class, () -> a.setVisina(visina));
	}

	@Test
	void testToString() {
		a = new AutoGuma("195/50ZR20", 30, 160, 80);
		
		String s = a.toString();
		assertTrue(s.contains("195/50ZR20"));
		assertTrue(s.contains("30"));
		assertTrue(s.contains("160"));
		assertTrue(s.contains("80"));


	}

	@ParameterizedTest
	@CsvSource ({
		" \"195/50ZR20\", 20, 195, 80, \"195/50ZR20\", 20, 195, 80, true",
		" \"195/50ZR20\", 20, 195, 80, \"197/50ZR20\", 20, 195, 80, false",
		" \"195/50ZR20\", 20, 195, 80, \"195/50ZR20\", 21, 195, 80, false",
		" \"195/50ZR20\", 20, 195, 80, \"195/50ZR20\", 20, 196, 80, false",
		" \"195/50ZR20\", 20, 195, 80, \"195/50ZR20\", 20, 195, 79, false",
		" \"195/50ZR20\", 20, 195, 80, \"197/50ZR20\", 21, 194, 79, false",
	})
	void testEqualsObject(String mm1, int p1, int s1, int v1, String mm2, int p2, int s2, int v2, boolean eq) {
		a = new AutoGuma(mm1,p1,s1,v1);
		AutoGuma a2 = new AutoGuma(mm2,p2,s2,v2);
		
		assertEquals(eq, a.equals(a2));
	}

}
