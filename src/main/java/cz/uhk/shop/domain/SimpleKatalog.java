/*
 * SimpleKatalog.java
 *
 * Created on 7. březen 2007, 14:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cz.uhk.shop.domain;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Primitivni trida implementujici katalog polozek
 * @author kozelto1, krizpa1
 */
@Service
public class SimpleKatalog implements Katalog {
    private List<Polozka> polozky = new ArrayList<>();
    
    /** Creates a new instance of SimpleKatalog */
    public SimpleKatalog() {
    }

    public List<Polozka> getPolozky() {
        return polozky;
    }

    public void pridej(Polozka p) {
        polozky.add(p);
        int maxId = 0;
        // vygenerovat nove id (bezne dela databaze)
        for (Polozka exp : polozky) {
        	if (exp.getId() > maxId) maxId = exp.getId(); 
        }
        p.setId(maxId + 1);
        Collections.sort(polozky,new Comparator<Polozka>() {

			public int compare(Polozka o1, Polozka o2) {
				return o1.getNazev().compareToIgnoreCase(o2.getNazev());
			}
        	
        });
    }

    public void odstran(Polozka p) {
        polozky.remove(p);
    }

    public Polozka getById(int id) {
        for(Polozka p : polozky) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

	public void setPolozky(List<Polozka> list) {
		this.polozky = list;
	}

	public void odstran(int id) {
		polozky.remove(getById(id));
	}
    
}
