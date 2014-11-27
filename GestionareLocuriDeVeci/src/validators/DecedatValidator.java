package validators;

import exceptions.ValidatorException;
import Domain.Decedat;

public class DecedatValidator {
	private String message;
	
	public DecedatValidator() {
		
	}
	
	public void validate(Decedat decedat) throws ValidatorException {
		message="";
		//todo cnp decedati
		if(decedat.getNrAdeverintaInhumare() < 0){
			message += "Nr adeverintei de inhumare nu poate fi negativ";
		}
		if(message!="")
			throw new ValidatorException(message);
	}
}
