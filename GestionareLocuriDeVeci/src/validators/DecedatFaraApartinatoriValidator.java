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
	
		if(cnpv.isValid(dfa.getCnpDecedat()) == 1){
			message += "CNP-ul trebuie sa aiba 13 caractere!";
		}
		if(cnpv.isValid(dfa.getCnpDecedat()) == 2){
			message += "CNP-ul trebuie sa fie format doar din cifre!!";
		}
		if(cnpv.isValid(dfa.getCnpDecedat()) == 3){
			message += "CNP-ul trebuie sa inceapa cu una din cifrele 1, 2, 3, 4, 5, 6 sau 9!";
		}
		if(cnpv.isValid(dfa.getCnpDecedat()) == 4){
			message += "Data calculata din CNP nu este valida!";
		}
		if(cnpv.isValid(dfa.getCnpDecedat()) == 5){
			message += "CNP-ul nu a trecut testul de control!";
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

