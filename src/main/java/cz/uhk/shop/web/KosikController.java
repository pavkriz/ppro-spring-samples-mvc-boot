package cz.uhk.shop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import cz.uhk.shop.domain.Kosik;
import cz.uhk.shop.domain.Polozka;
import cz.uhk.shop.domain.ShopManager;

/**
 * MultiAction Controller katalogu. Dle parametru requestu "akce" bud update mnozstvi
 * v kosiku, nebo zobrazuje obsah kosiku
 * @author kozelto1, krizpa1
 *
 */
@Controller
@RequestMapping("/kosik.do")
public class KosikController extends KosikInSessionController {
	private ShopManager shopManager;	

	/**
	 * Update mnozstvi v kosiku
	 * @param id id polozky, ktera se aktualizuje
	 * @param cnt pocet ks, kolik ma byt v kosiku
	 * @return view
	 */
	@RequestMapping(params="akce=update")
	public String update(@RequestParam(value="polId") Integer id, @RequestParam("cnt") int cnt, @ModelAttribute("kosik") Kosik k) {
		Polozka p = shopManager.getKatalog().getById(id);
		k.update(p, cnt);
		return "redirect:/katalog.do";
	}

	/**
	 * Zobrazeni kosiku (zaroven defaultni akce, pokud neni pritomen parametr "akce")
	 * @return view
	 */
	@RequestMapping(params="!akce")
	public String show() {
		return "kosik";
	}
	
	/**
	 * Vyprazdneni kosiku
	 */
	@RequestMapping(params="akce=clear")
	public String clear(@ModelAttribute("kosik") Kosik k) {
		k.vysyp();
		return "kosik";
	}
	
	
	/**
	 * @return shopManager
	 */
	public ShopManager getShopManager() {
		return shopManager;
	}
	/**
	 * @param shopManager shopManager, který má být nastaven
	 */
	@Autowired
	public void setShopManager(ShopManager shopManager) {
		this.shopManager = shopManager;
	}
}
