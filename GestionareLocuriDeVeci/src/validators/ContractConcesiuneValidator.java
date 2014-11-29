package validators;

import exceptions.ValidatorException;
import domain.ContractConcesiune;

public class ContractConcesiuneValidator {
	private String message;
	private CNPValidator cnpv;
	public ContractConcesiuneValidator() {
		this.cnpv = new CNPValidator();
	}
	
	public void validate(ContractConcesiune cc) throws ValidatorException {
		message="";
		if(cc.getNrContract() < 0){
			message += "Nr contractului nu poate fi negativ";
		}
		
		if(!cnpv.isValid(cc.getCnpConcesionar1()) || !cnpv.isValid(cc.getCnpConcesionar2())){
			message += "CNP-ul nu este valid!";
		}
		
		if(message!="")
			throw new ValidatorException(message);
	}
}