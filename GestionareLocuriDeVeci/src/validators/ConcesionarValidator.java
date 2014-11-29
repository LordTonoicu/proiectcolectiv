package validators;

import exceptions.ValidatorException;
import domain.Concesionar;

public class ConcesionarValidator {
	private String message;
	private CNPValidator cnpv;
	public ConcesionarValidator() {
		this.cnpv = new CNPValidator();
	}
	
	public void validate(Concesionar c) throws ValidatorException {
		if(c.getDomiciliu() == ""){
			message += "Campul domiciliu nu poate fi gol!";
		}
		if(c.getNrChitanta() < 0) {
			message += "Nr chitantei nu poate fi negativ!";
		}
		
		if(!cnpv.isValid(c.getCnpConcesionar())){
			message += "CNP-ul nu este valid!";
		}
		
		if(message!="")
			throw new ValidatorException(message);
	}
}
