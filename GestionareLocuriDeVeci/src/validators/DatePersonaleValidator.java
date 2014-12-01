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
		
		if(cnpv.isValid(dp.getCnp()) == 1){
			message += "CNP-ul trebuie sa aiba 13 caractere!";
		}
		if(cnpv.isValid(dp.getCnp()) == 2){
			message += "CNP-ul trebuie sa fie format doar din cifre!!";
		}
		if(cnpv.isValid(dp.getCnp()) == 3){
			message += "CNP-ul trebuie sa inceapa cu una din cifrele 1, 2, 3, 4, 5, 6 sau 9!";
		}
		if(cnpv.isValid(dp.getCnp()) == 4){
			message += "Data calculata din CNP nu este valida!";
		}
		if(cnpv.isValid(dp.getCnp()) == 5){
			message += "CNP-ul nu a trecut testul de control!";
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
