package validators;

import Domain.Cimitir;
import exceptions.ValidatorException;

public class CimitirValidator {
	private String message;
	
	public CimitirValidator() {
		
	}
	
	public void validate(Cimitir c) throws ValidatorException {
		message="";
		if(c.getDenumire() == ""){
			message += "Campul denumire nu poate fi gol!";
		}
		if(c.getAdresa() == ""){
			message += "Campul adresa nu poate fi gol!";
		}
		if(c.getNrLocuri() < 0){
			message += "Nr de locuri nu poate fi negativ!";
		}
		if(c.getNrParcele() <0 ){
			message += "Nr de parcele nu poate fi negativ!";
		}
		if(message!="")
			throw new ValidatorException(message);
	}
}
