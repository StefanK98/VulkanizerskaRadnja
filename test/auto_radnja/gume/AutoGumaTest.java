package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutoGumaTest {
	
	AutoGuma aGuma;
	
	@BeforeEach
	void setUp() throws Exception {
		aGuma=new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		aGuma=null;
	}

	@Test
	void testAutoGuma() {
		aGuma=new AutoGuma();
		assertNotNull(aGuma);
	}

	@Test
	void testAutoGumaStringIntIntInt() {
		aGuma=new AutoGuma("Michelin Primacy 4", 17, 225, 50);
		assertNotNull(aGuma);
	}

	@Test
	void testSetMarkaModel() {
		aGuma.setMarkaModel("Michelin CrossClimate");
		assertEquals("Michelin CrossClimate", aGuma.getMarkaModel());
	}
	@Test
	void testSetMarkaModelNull() {
		assertThrows(java.lang.NullPointerException.class, 
				()-> aGuma.setMarkaModel(null));
	}
	@Test
	void testSetMarkaModelManje3Karaktera() {
		assertThrows(java.lang.RuntimeException.class, 
				()-> aGuma.setMarkaModel("M"));
	}
	
	@ParameterizedTest
	@CsvSource({
			"15","16","17"
	})
	void testSetPrecnik(int precnik) {
		aGuma.setPrecnik(precnik);
		assertEquals(precnik, aGuma.getPrecnik());
	}
	
	@Test
	void testSetPrecnikIzvan() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> aGuma.setPrecnik(11));
		
	}
	
	@ParameterizedTest
	@CsvSource({
		"145","195","305"
})
	void testSetSirina(int sirina) {
		aGuma.setSirina(sirina);
		assertEquals(sirina, aGuma.getSirina());
	}
	@Test
	void testSetSirinaIzvan() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> aGuma.setSirina(400)); 
	}
	@ParameterizedTest
	@CsvSource({
		"35", "70", "85"
	})
	void testSetVisina(int visina) {
		aGuma.setVisina(visina);
		assertEquals(visina, aGuma.getVisina());
	}

	@Test
	void testSetVisinaIzvanOpsega() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> aGuma.setVisina(100));
	}
	
	void testToString() {
		AutoGuma autoGuma=new AutoGuma("Michelin Primacy 4", 17, 225, 50);
		String s=autoGuma.toString();
		assertTrue(s.contains("Michelin Primacy 4"));
		assertEquals(17, autoGuma.getPrecnik());
		assertEquals(225, autoGuma.getSirina());
		assertEquals(17, autoGuma.getVisina());
	}

	@ParameterizedTest
	@CsvSource({
		"Michelin Primacy 4, 17, 225, 50,Michelin Primacy 4, 17, 225, 50,true",
		"Michelin Primacy 4, 17, 225, 50,Michelin Primacy 5, 17, 225, 50,false",
		"Michelin Primacy 4, 17, 225, 50,Michelin Primacy 4, 17, 225, 35,false",
		"Michelin Primacy 4, 17, 225, 50,Michelin Primacy 5, 18, 225, 50,false",
	})
	void testEqualsObject(String markaModel1,int precnik1,int sirina1,int visina1,
						String markaModel2,int precnik2,int sirina2,int visina2,boolean equals){
		
		AutoGuma autoGuma1=new AutoGuma(markaModel1, precnik1, sirina1, visina1);
		AutoGuma autoGuma2=new AutoGuma(markaModel2, precnik2, sirina2, visina2);
		
		assertEquals(equals, autoGuma1.equals(autoGuma2));
	}

}
