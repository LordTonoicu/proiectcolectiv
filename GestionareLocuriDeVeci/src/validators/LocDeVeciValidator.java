package validators;

import exceptions.ValidatorException;
import Domain.LocDeVeci;

public class LocDeVeciValidator {
	private String message;
	
	public LocDeVeciValidator() {
		
	}
	
	public void validate(LocDeVeci ldv) throws ValidatorException {
		message="";
		if(ldv.getSuprafata() < 0){
			message += "Suprafata nu poate fi negativa!";
		}
		if(ldv.getNumar() < 0) {
			message += "Numarul nu poate fi negativ!";
		}
		if(message!="")
			throw new ValidatorException(message);
	}

}