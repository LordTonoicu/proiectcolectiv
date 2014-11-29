package validators;

import exceptions.ValidatorException;
import domain.DecedatFaraApartinatori;

public class DecedatFaraApartinatoriValidator {
	private String message;
	private CNPValidator cnpv;
	public DecedatFaraApartinatoriValidator() {
		this.cnpv = new CNPValidator();
	}
	
	public void validate(DecedatFaraApartinatori dfa) throws ValidatorException {
		message="";
	
		if(!cnpv.isValid(dfa.getCnpDecedat())){
			message += "CNP-ul nu este valid!";
		}
		
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

