package cz.uhk.shop.domain;

import java.util.*;

/**
 * Rozhrani nakupniho kosiku
 * @author kozelto1
 *
 */
public interface Kosik {
	/**
	 * Updatuje nebo pridava polozku v zadanem mnozstvi v kosiku
	 * @param p polozka zbozi
	 * @param cnt mnozstvi, 0 ... odstrani
	 */
	void update(Polozka p, int cnt);
	/**
	 * Odstranuje polozku z kosiku
	 * @param p polozk ak odstraneni
	 */
	void odstran(Polozka p);
	/**
	 * Vysype cely obsah kosiku
	 */
	void vysyp();
	/**
	 * Vraci seznam vsech polozek v kosiku Polozka -> pocet ks
	 * @return seznam polozek
	 */
	List<PolozkaKosiku> getPolozky();
	
	/**
	 * Vypocita a vrati cenu bez DPH celkem za kosik
	 * @return cena
	 */
	double getCenaCelkem();
	/**
	 * Vypocita a vrati cenu s DPH celkem za kosik
	 * @return cena
	 */
	double getCenaSDphCelkem();
}
