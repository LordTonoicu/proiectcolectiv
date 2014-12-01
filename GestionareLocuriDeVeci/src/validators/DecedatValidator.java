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
		
		if(cnpv.isValid(decedat.getCnpDecedat()) == 1){
			message += "CNP-ul trebuie sa aiba 13 caractere!";
		}
		if(cnpv.isValid(decedat.getCnpDecedat()) == 2){
			message += "CNP-ul trebuie sa fie format doar din cifre!!";
		}
		if(cnpv.isValid(decedat.getCnpDecedat()) == 3){
			message += "CNP-ul trebuie sa inceapa cu una din cifrele 1, 2, 3, 4, 5, 6 sau 9!";
		}
		if(cnpv.isValid(decedat.getCnpDecedat()) == 4){
			message += "Data calculata din CNP nu este valida!";
		}
		if(cnpv.isValid(decedat.getCnpDecedat()) == 5){
			message += "CNP-ul nu a trecut testul de control!";
		}
		
		if(decedat.getNrAdeverintaInhumare() < 0){
			message += "Nr adeverintei de inhumare nu poate fi negativ";
		}
		if(message!="")
			throw new ValidatorException(message);
	}
}
