package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

public abstract class RadnjaTest {
	protected Radnja radnja;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testDodajGumu() {
		AutoGuma aGuma = new AutoGuma("Michelin Primacy 4", 17, 225, 50);
		radnja.dodajGumu(aGuma);
		
		assertEquals(1, radnja.vratiSveGume().size());
		assertEquals(aGuma, radnja.vratiSveGume().get(0));
	}
	@Test
	void testDodajGumuNull() {
		assertThrows(java.lang.NullPointerException.class, 
				() -> radnja.dodajGumu(null));
	}
	@Test
	void testDodajGumuImaUListi() {
		AutoGuma aGuma1 = new AutoGuma("Michelin Primacy 4", 17, 225, 50);
		radnja.dodajGumu(aGuma1);
		AutoGuma aGuma2 = new AutoGuma("Michelin Primacy 4", 17, 225, 50);
		assertThrows(java.lang.RuntimeException.class, 
				() -> radnja.dodajGumu(aGuma2));
	}
	@Test
	void testPronadjiGumu() {
		AutoGuma aGuma1 = new AutoGuma("Michelin Primacy 4", 17, 225, 50);
		radnja.dodajGumu(aGuma1);
		AutoGuma aGuma2 = new AutoGuma("Michelin Primacy 5", 14, 205, 70);
		radnja.dodajGumu(aGuma2);
		
		
		LinkedList<AutoGuma> rezultat = radnja.pronadjiGumu("Michelin Primacy 4");
		assertEquals(1, rezultat.size());
		
	}
	
	@Test
	void testPronadjiGumuNull() {
		assertEquals(null, radnja.pronadjiGumu(null));
	}
	@Test
	void testPronadjiGumuPrazna() {
		AutoGuma guma1 = new AutoGuma("Michelin Primacy 4", 17, 225, 50);
		radnja.dodajGumu(guma1);
		
		assertEquals(0,radnja.pronadjiGumu("Michelin").size());
	}
	
	@Test
	public void testPronadjiGumuIstaMarkaModel() {
		AutoGuma guma1 = new AutoGuma("Michelin Primacy 4", 17, 225, 50);
		radnja.dodajGumu(guma1);
		
		AutoGuma guma2 = new AutoGuma("Michelin Primacy 4", 14, 205, 70);
		radnja.dodajGumu(guma2);
		
		AutoGuma guma3 = new AutoGuma("Michelin Primacy 5", 14, 205, 70);		
		radnja.dodajGumu(guma3);
		
		AutoGuma guma4 = new AutoGuma("Michelin Primacy 6", 14, 205, 70);		
		radnja.dodajGumu(guma4);

		LinkedList<AutoGuma> gume = new LinkedList<>();
		gume = radnja.pronadjiGumu("Michelin Primacy 4");

		assertEquals(2, gume.size());
		assertTrue(gume.contains(guma1));
		

	}

}
