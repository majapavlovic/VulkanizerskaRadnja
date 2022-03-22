package auto_radnja;

import java.util.List;

import auto_radnja.gume.AutoGuma;
/**
 * Interfejs koji predstavlja Radnju
 * @author Maja Pavlovic
 *
 * @version 1.0
 */
public interface Radnja {
	
	
	/**
	 * Metoda koja dodaje novu AutoGumu u radnju
	 * @param a - AutoGuma koja se dodaje
	 * 
	 * @throws NullPointerException ako je uneta vrednost null
	 * @throws RuntimeException ako uneta guma vec postoji u listi
	 */
	void dodajGumu(AutoGuma a);
	
	/**
	 * Metoda koja pronalazi trazenu auto gumu
	 * @param markaModel String vrednost po kojoj se pretrazuje AutoGuma
	 * @return trazeni objekat AutoGuma 
	 */
	List<AutoGuma> pronadjiGumu(String markaModel);
	
	/**
	 * Metoda koja vraca listu svih auto guma u radnji
	 * @return Lista svih guma u radnji 
	 */
	List<AutoGuma> vratiSveGume();
}
