package validators;

import exceptions.ValidatorException;
import domain.Decedat;

public class DecedatValidator {
	private String message;
	private CNPValidator cnpv;
	public DecedatValidator() {
		this.cnpv = new CNPValidator();
	}
	
	public void validate(Decedat decedat) throws ValidatorException {
		message="";
		
		if(!cnpv.isValid(decedat.getCnpDecedat())){
			message += "CNP-ul nu este valid!";
		}
		
		if(decedat.getNrAdeverintaInhumare() < 0){
			message += "Nr adeverintei de inhumare nu poate fi negativ";
		}
		if(message!="")
			throw new ValidatorException(message);
	}
}
