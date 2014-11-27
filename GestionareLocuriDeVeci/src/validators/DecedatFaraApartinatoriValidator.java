package validators;

import exceptions.ValidatorException;
import Domain.DecedatFaraApartinatori;

public class DecedatFaraApartinatoriValidator {
	private String message;
	
	public DecedatFaraApartinatoriValidator() {
		
	}
	
	public void validate(DecedatFaraApartinatori dfa) throws ValidatorException {
		message="";
		//todo luat la puricat cnp-ul
		if(dfa.getNrAdeverintaDeInhumare() < 0 ){
			message += "Nr adeverintei de inhumare nu poate fi negativ!";
		}
		if(dfa.getNrAdeverintaAsistenta() < 0) {
			message += "Nr adeverinta asistenta nu poate fi negativ!";
		}
		if(message!="")
			throw new ValidatorException(message);
	}
}

