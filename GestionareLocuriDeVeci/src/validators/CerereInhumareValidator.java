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
		
		if(!cnpv.isValid(ci.getCnpConcesionar())){
			message += "CNP-ul nu este valid!";
		}
		
		if(message!="")
			throw new ValidatorException(message);
	}
}

