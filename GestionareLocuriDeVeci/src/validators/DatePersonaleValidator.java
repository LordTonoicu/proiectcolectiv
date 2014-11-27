package validators;

import exceptions.ValidatorException;
import Domain.DatePersonale;

public class DatePersonaleValidator {
	private String message;
	
	public DatePersonaleValidator(){
		
	}
	
	public void validate(DatePersonale dp) throws ValidatorException {
		message="";
		//todo cnp
		if(dp.getNume() == ""){
			message += "Campul nume nu poate fi gol!";
		}
		if(dp.getPrenume() == ""){
			message += "Campul prenume nu poate fi gol!";
		}
		if(message!="")
			throw new ValidatorException(message);
	}
}
