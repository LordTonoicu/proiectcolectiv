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
		
		if(cnpv.isValid(cc.getCnpConcesionar1()) == 1){
			message += "CNP-ul apartinand Concesionar1 trebuie sa aiba 13 caractere!";
		}
		if(cnpv.isValid(cc.getCnpConcesionar1()) == 2){
			message += "CNP-ul apartinand Concesionar1 trebuie sa fie format doar din cifre!!";
		}
		if(cnpv.isValid(cc.getCnpConcesionar1()) == 3){
			message += "CNP-ul apartinand Concesionar1 trebuie sa inceapa cu una din cifrele 1, 2, 3, 4, 5, 6 sau 9!";
		}
		if(cnpv.isValid(cc.getCnpConcesionar1()) == 4){
			message += "Data calculata din CNP-ul apartinand Concesionar1 nu este valida!";
		}
		if(cnpv.isValid(cc.getCnpConcesionar1()) == 5){
			message += "CNP-ul apartinand Concesionar1 nu a trecut testul de control!";
		}
		
		if(cnpv.isValid(cc.getCnpConcesionar2()) == 1){
			message += "CNP-ul apartinand Concesionar2 trebuie sa aiba 13 caractere!";
		}
		if(cnpv.isValid(cc.getCnpConcesionar2()) == 2){
			message += "CNP-ul apartinand Concesionar2 trebuie sa fie format doar din cifre!!";
		}
		if(cnpv.isValid(cc.getCnpConcesionar2()) == 3){
			message += "CNP-ul apartinand Concesionar2 trebuie sa inceapa cu una din cifrele 1, 2, 3, 4, 5, 6 sau 9!";
		}
		if(cnpv.isValid(cc.getCnpConcesionar2()) == 4){
			message += "Data calculata din CNP-ul apartinand Concesionar2 nu este valida!";
		}
		if(cnpv.isValid(cc.getCnpConcesionar2()) == 5){
			message += "CNP-ul apartinand Concesionar2 nu a trecut testul de control!";
		}
		
		if(message!="")
			throw new ValidatorException(message);
	}
}