package validators;

import exceptions.ValidatorException;
import Domain.Parcela;

public class ParcelaValidator {
	private String message;
	
	public ParcelaValidator() {
		
	}
	
	public void validate(Parcela parcela) throws ValidatorException {
		message="";
		if(parcela.getDenumire()==""){
			message += "Campul denumire nu poate fi gol!";
		}
		if(parcela.getNrLocuri() < 0){
			message += "Nr de locuri nu poate fi negativ!";
		}
		if(message!="")
			throw new ValidatorException(message);
	}
}
