package validators;

import exceptions.ValidatorException;
import Domain.CerereInhumare;

public class CerereInhumareValidator {
	private String message;
	
	public CerereInhumareValidator() {
		
	}
	
	public void validate(CerereInhumare ci) throws ValidatorException{
		message = "";
		if(ci.getNrCerere() < 0){
			message += "Nr cererii nu poate fi negativ!";
		}
		if(ci.getStadiuSolutionare() == ""){
			message += "Campul stadiu solutionare nu poate fi gol!";
		}
		//todo cnp
		if(message!="")
			throw new ValidatorException(message);
	}
}

