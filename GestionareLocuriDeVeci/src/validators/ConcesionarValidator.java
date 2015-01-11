package validators;

import exceptions.ValidatorException;
import domain.Concesionar;

public class ConcesionarValidator {
	private String message="";
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
		
		if(cnpv.isValid(c.getCnpConcesionar()) == 1){
			message += "CNP-ul trebuie sa aiba 13 caractere!";
		}
		if(cnpv.isValid(c.getCnpConcesionar()) == 2){
			message += "CNP-ul trebuie sa fie format doar din cifre!!";
		}
		if(cnpv.isValid(c.getCnpConcesionar()) == 3){
			message += "CNP-ul trebuie sa inceapa cu una din cifrele 1, 2, 3, 4, 5, 6 sau 9!";
		}
		if(cnpv.isValid(c.getCnpConcesionar()) == 4){
			message += "Data calculata din CNP nu este valida!";
		}
		if(cnpv.isValid(c.getCnpConcesionar()) == 5){
			message += "CNP-ul nu a trecut testul de control!";
		}
		
		if(message!="")
			throw new ValidatorException(message);
	}
}
