package validators;

import exceptions.ValidatorException;
import domain.CerereInhumare;

public class CerereInhumareValidator {
	private String message;
	private CNPValidator cnpv;
	public CerereInhumareValidator() {
		this.cnpv = new CNPValidator();
	}
	
	public void validate(CerereInhumare ci) throws ValidatorException{
		message = "";
		if(ci.getNrCerere() < 0){
			message += "Nr cererii nu poate fi negativ!";
		}
		if(ci.getStadiuSolutionare() == ""){
			message += "Campul stadiu solutionare nu poate fi gol!";
		}
		
		if(cnpv.isValid(ci.getCnpConcesionar()) == 1){
			message += "CNP-ul trebuie sa aiba 13 caractere!";
		}
		if(cnpv.isValid(ci.getCnpConcesionar()) == 2){
			message += "CNP-ul trebuie sa fie format doar din cifre!!";
		}
		if(cnpv.isValid(ci.getCnpConcesionar()) == 3){
			message += "CNP-ul trebuie sa inceapa cu una din cifrele 1, 2, 3, 4, 5, 6 sau 9!";
		}
		if(cnpv.isValid(ci.getCnpConcesionar()) == 4){
			message += "Data calculata din CNP nu este valida!";
		}
		if(cnpv.isValid(ci.getCnpConcesionar()) == 5){
			message += "CNP-ul nu a trecut testul de control!";
		}
		
		if(message!="")
			throw new ValidatorException(message);
	}
}

