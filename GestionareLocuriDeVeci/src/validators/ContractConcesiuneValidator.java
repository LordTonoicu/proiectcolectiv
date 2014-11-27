package validators;

import exceptions.ValidatorException;
import Domain.ContractConcesiune;

public class ContractConcesiuneValidator {
	private String message;
	
	public ContractConcesiuneValidator() {
		
	}
	
	public void validate(ContractConcesiune cc) throws ValidatorException {
		message="";
		if(cc.getNrContract() < 0){
			message += "Nr contractului nu poate fi negativ";
		}
		//todo cnp-uri
		if(message!="")
			throw new ValidatorException(message);
	}
}