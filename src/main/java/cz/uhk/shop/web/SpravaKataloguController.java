package cz.uhk.shop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cz.uhk.shop.domain.Katalog;

/**
 * Kontroler spravy katalogu (priklad, jak rozlisit akce pomoci parametru v URL)
 * @author kozelto1, krizpa1
 *
 */
@Controller
@RequestMapping("/sprava.do")
public class SpravaKataloguController {
	Katalog katalog = null;

	/**
	 * Zobrazeni tabulky polozek s tlacitk pro editaci/mazani
	 */
	@RequestMapping(params="!akce")
	public ModelAndView show() throws Exception {
		return new ModelAndView("katalogSprava","katalog",katalog);
	}

	/**
	 * Smazani polozky
	 */
	@RequestMapping(params="akce=remove")
	public String remove(@RequestParam("polId") int id) {
		katalog.odstran(id);
		return "redirect:/sprava.do";
	}
	
	public Katalog getKatalog() {
		return katalog;
	}

	@Autowired
	public void setKatalog(Katalog katalog) {
		this.katalog = katalog;
	}
}
