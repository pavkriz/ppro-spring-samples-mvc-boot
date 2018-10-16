package cz.uhk.shop.web;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import cz.uhk.shop.domain.Kosik;
import cz.uhk.shop.domain.SimpleKosik;

/**
 * Pomocna trida slouzici jako predek pro kontrolery, ktere ocekavaji Kosik v session,
 * definuje, ze modelovy atribut "kosik" ma byt v session a obsahuje metodu, ktera v pripade
 * potreby kosik vyrobi.
 * @author krizpa1
 *
 */
@SessionAttributes("kosik")
public class KosikInSessionController {
	
	/**
	 * Vytvori novy kosik a vlozi ho do Model mapy 
	 * (ve finale do session, nebot kosik je SessionAttribute).
	 * Tuto metodu vola Spring MVC automaticky pro kazdy pozadavek v kontroleru 
	 * pokud kosik v session jeste neexistuje
	 * @return vytvoreny kosik
	 */
	@ModelAttribute("kosik")
	public Kosik vytvorKosik() {
		System.out.println("Vytvarim novy kosik v Session");
		return new SimpleKosik();
	}
}
