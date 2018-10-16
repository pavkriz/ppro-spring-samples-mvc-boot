package cz.uhk.shop.domain;

import java.util.*;

/**
 * Implementace kosiku 
 * @author kozelto1
 *
 */
public class SimpleKosik implements Kosik {
	private List<PolozkaKosiku> polozky = new ArrayList<PolozkaKosiku>();
	
	public List<PolozkaKosiku> getPolozky() {
		return polozky;
	}

	public void odstran(Polozka polozka) {
		for (PolozkaKosiku p : polozky) {
			if (p.getPolozka().getId()==polozka.getId()) {
				polozky.remove(p);
			}
		}
	}

	public void update(Polozka polozka, int cnt) {
		for (PolozkaKosiku p : polozky) {
			if (p.getPolozka().getId()==polozka.getId()) {
				if (cnt == 0) {
					polozky.remove(p);
				} else {
					p.setPocet(cnt);
				}
				return;
			}
		}
		polozky.add(new PolozkaKosiku(polozka,cnt));
	}

	public void vysyp() {
		polozky.clear();
	}

	public double getCenaCelkem() {
		double cena = 0;
		for (PolozkaKosiku p : polozky) {
			cena += p.getCena();
		}
		return cena;
	}

	public double getCenaSDphCelkem() {
		double cena = 0;
		for (PolozkaKosiku p : polozky) {
			cena += p.getCenaSDph();
		}
		return cena;
	}

}
