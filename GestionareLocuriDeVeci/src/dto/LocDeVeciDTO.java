package dto;

import Domain.DatePersonale;
import Domain.LocDeVeci;

public class LocDeVeciDTO {
	
	private LocDeVeci locDeVeci;
	private DatePersonale datePersonaleDetinator;
	private DatePersonale datePersonaleInmormantant;
	//Eventual alte date necesare
	
	
	public LocDeVeci getLocDeVeci() {
		return locDeVeci;
	}
	public LocDeVeciDTO(LocDeVeci locDeVeci,
			DatePersonale datePersonaleDetinator,
			DatePersonale datePersonaleInmormantant) {
		super();
		this.locDeVeci = locDeVeci;
		this.datePersonaleDetinator = datePersonaleDetinator;
		this.datePersonaleInmormantant = datePersonaleInmormantant;
	}
	public void setLocDeVeci(LocDeVeci locDeVeci) {
		this.locDeVeci = locDeVeci;
	}
	public DatePersonale getDatePersonaleDetinator() {
		return datePersonaleDetinator;
	}
	public void setDatePersonaleDetinator(DatePersonale datePersonaleDetinator) {
		this.datePersonaleDetinator = datePersonaleDetinator;
	}
	public DatePersonale getDatePersonaleInmormantant() {
		return datePersonaleInmormantant;
	}
	public void setDatePersonaleInmormantant(DatePersonale datePersonaleInmormantant) {
		this.datePersonaleInmormantant = datePersonaleInmormantant;
	}
	
	//+Getters campuri obiecte continute; ex: nume detinator

}
