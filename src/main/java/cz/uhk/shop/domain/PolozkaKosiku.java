package cz.uhk.shop.domain;

/**
 * Položka nákupního košíku
 * @author kozelto1
 *
 */
public class PolozkaKosiku {
	private Polozka polozka;
	private int pocet;
	
	public PolozkaKosiku() {}
	
	public PolozkaKosiku(Polozka polozka, int pocet) {
		super();
		this.polozka = polozka;
		this.pocet = pocet;
	}

	/**
	 * @return pocet
	 */
	public int getPocet() {
		return pocet;
	}
	/**
	 * @param pocet pocet, který má být nastaven
	 */
	public void setPocet(int pocet) {
		this.pocet = pocet;
	}
	/**
	 * @return polozka
	 */
	public Polozka getPolozka() {
		return polozka;
	}
	/**
	 * @param polozka polozka, který má být nastaven
	 */
	public void setPolozka(Polozka polozka) {
		this.polozka = polozka;
	}
	
	public double getCena() {
		return pocet*polozka.getCena();
	}

	public double getCenaSDph() {
		return pocet*polozka.getCenaSDph();
	}
}
