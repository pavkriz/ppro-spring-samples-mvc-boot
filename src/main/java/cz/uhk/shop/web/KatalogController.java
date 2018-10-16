package cz.uhk.shop.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cz.uhk.shop.domain.Katalog;
import cz.uhk.shop.domain.Kosik;
import cz.uhk.shop.domain.PolozkaKosiku;

/**
 * Kontroler hlavni stranky katalogu
 * @author kozelto1, krizpa1
 *
 */
@Controller
public class KatalogController extends KosikInSessionController {
	private Katalog katalog = null;
	/**
	 * @return katalog
	 */
	public Katalog getKatalog() {
		return katalog;
	}
	/**
	 * @param katalog katalog, který má být nastaven (injektujeme pomoci anotaci)
	 */
	@Autowired
	public void setKatalog(Katalog katalog) {
		this.katalog = katalog;
	}
	
	/**
	 * Vlastni akce namapovana na danou URL, naplni Model pro JSP a urci logicke jmeno view
	 */
	@RequestMapping("/katalog.do")
	public ModelAndView zobrazit(@ModelAttribute("kosik") Kosik k) {
		ModelAndView model = new ModelAndView("katalog");
		model.addObject("polozky", katalog.getPolozky());	
		Map<Integer,PolozkaKosiku> mk = new HashMap<Integer, PolozkaKosiku>();
		if (k!=null) {		
			for (PolozkaKosiku p : k.getPolozky()) {
				mk.put(p.getPolozka().getId(), p);
			}
		}		
		model.addObject("mapKosik", mk);

		return model;
	}

}
