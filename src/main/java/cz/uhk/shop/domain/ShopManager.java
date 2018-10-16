package cz.uhk.shop.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Fasada eShopu - centralni trida aplikacni logiky
 * @author kozelto1, krizpa1
 *
 */
@Service
public class ShopManager {
	private Katalog katalog;
	
	public Katalog getKatalog() {
		return katalog;
	}

	@Autowired
	public void setKatalog(Katalog katalog) {
		this.katalog = katalog;
	}
	
}
