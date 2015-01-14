package validators;

import exceptions.ValidatorException;
import domain.Concesionar;

public class ConcesionarValidator {
	private String message="";
	public ConcesionarValidator() {
	}
	
	public void validate(Concesionar c) throws ValidatorException {
		if(c.getDomiciliu() == ""){
			message += "Campul domiciliu nu poate fi gol!";
		}
		if(c.getNrChitanta() < 0) {
			message += "Nr chitantei nu poate fi negativ!";
		}		
		if(message!="")
			throw new ValidatorException(message);
	}
}
