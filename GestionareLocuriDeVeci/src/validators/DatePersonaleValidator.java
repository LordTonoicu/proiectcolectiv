package validators;

import exceptions.ValidatorException;
import domain.DatePersonale;

public class DatePersonaleValidator {
	private String message;
	private CNPValidator cnpv;
	public DatePersonaleValidator(){
		this.cnpv = new CNPValidator();
	}
	
	public void validate(DatePersonale dp) throws ValidatorException {
		message="";
		
		if(!cnpv.isValid(dp.getCnp())){
			message += "CNP-ul nu este valid!";
		}
		
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
