package validators;

import exceptions.ValidatorException;
import Domain.InregistrareJurnal;

public class InregistrareJurnalValidator {
	private String message;
	
	public InregistrareJurnalValidator() {
		
	}	
	
	public void validate(InregistrareJurnal inregJurnal) throws ValidatorException {
		message="";
		if(inregJurnal.getDetaliiModificare() ==""){
			message += "Campul detalii modificare nu poate fi gol!";
		}
		if(message!="")
			throw new ValidatorException(message);
	}
	
	
}