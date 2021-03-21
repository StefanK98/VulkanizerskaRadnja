package auto_radnja;

import java.util.LinkedList;
import auto_radnja.gume.AutoGuma;

/**
 * Interfejs koji sadrzi metode za dodavanje i pronalazenje auto gume.
 * 
 * @author Stefan Kujovic
 * @version 0.1
 */
public interface Radnja {
	/**
	 * Dodavanje nove gume.
	 * @param a Objekat klase AutoGuma.
	 * 
	 * @throws java.lang.NullPointerException Ako auto guma ima null vrednost.
	 * @throws java.lang.RuntimeException Ako auto guma vec nalazi u listi.
	 */
	void dodajGumu(AutoGuma a);

	/**
	 * Pronalazenje gume uz pomoc marke i modela.
	 * 
	 * @param markaModel Marka i model gume kao String vrednost.
	 * 
	 * @return 
	 * <ul>	
	 * 		<li>Listu auto guma koji odgovaraju prosledjenoj vrednosti (marka i model auto gume).</li>
	 * 		<li>Null, ako je vrednost atributa markaModel null vrednost.</li>
	 * </ul>
	 * 
	 */
	LinkedList<AutoGuma> pronadjiGumu(String markaModel);
	/**
	 * Vraca listu svih auto guma.
	 * 
	 * @return 
	 * <ul>	
	 * 		<li>Listu auto guma </li>
	 * 		<li>Null, ako je lista null.</li>
	 * </ul>
	 * 
	 * @throws java.lang.RuntimeException Ako je lista prazna.
	 */
	LinkedList<AutoGuma> vratiSveGume();
}
