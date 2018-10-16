package cz.uhk.shop.web;

import java.text.DecimalFormat;

import cz.uhk.shop.domain.validace.PolozkaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cz.uhk.shop.domain.Katalog;
import cz.uhk.shop.domain.Polozka;

/**
 * Kontroler formulare pro zadavani, resp.editaci polozek katalogu
 * @author kozelto1, krizpa1
 *
 */
@Controller
@RequestMapping("/polozka.do")
public class PolozkaFormController {
	private Katalog katalog = null;
	private Validator polozkaValidator;
	 
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		//Nastaveni cutom editoru polozek formulare
		CustomNumberEditor ed = new CustomNumberEditor(
				Double.class,
				new DecimalFormat("#,##0.00"),
				true
		); 
		binder.registerCustomEditor(Double.class,"cena",ed);
		binder.registerCustomEditor(Double.class,"dph",ed);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	protected String onSubmit(@RequestParam(value="polId",required=false) Integer id, @ModelAttribute("polozka") Polozka polozka, BindingResult result) {
		//Provede se po odeslani formu
		polozkaValidator.validate(polozka, result);
		if (result.hasErrors()) {
			return "polozkaForm";
		}
		if (id!=null) {
			katalog.odstran(id);
		}
		katalog.pridej(polozka);
		return "redirect:/sprava.do";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	protected String form(@RequestParam(value="polId",required=false) Integer id, Model m) {
		//Priprava dat pro form, pokud je zadano id polozky, pak bude predvyplnena
		if (id!=null) {
			m.addAttribute("polozka", katalog.getById(id));
		} else {
			// pokud vytvarime novou polozku, tak do JSP predame novou instanci
			m.addAttribute("polozka", new Polozka());
		}
		return "polozkaForm";
	}

	public Katalog getKatalog() {
		return katalog;
	}

	@Autowired
	public void setKatalog(Katalog katalog) {
		this.katalog = katalog;
	}

	public Validator getPolozkaValidator() {
		return polozkaValidator;
	}
	
	@Autowired
	public void setPolozkaValidator(PolozkaValidator polozkaValidator) {
		this.polozkaValidator = polozkaValidator;
	}
}
