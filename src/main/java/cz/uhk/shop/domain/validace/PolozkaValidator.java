package cz.uhk.shop.domain.validace;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import cz.uhk.shop.domain.Polozka;

/**
 * Validator Polozky katalogu
 * @author kozelto1, krizpa1
 *
 */
@Component
public class PolozkaValidator implements Validator {

	@SuppressWarnings("unchecked")
	public boolean supports(Class clazz) {
		return Polozka.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Polozka p = (Polozka) target;
		
		if (p.getDph()<0 || p.getDph()>100) {
			errors.rejectValue("dph", "err.polozka.dph", "Mimo rozsah (0-100%)");
		}
		
	}

}
