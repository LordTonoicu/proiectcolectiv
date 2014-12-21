package dto;

import domain.DatePersonale;
import domain.LocDeVeci;

public class LocDeVeciDTO {
	
	private LocDeVeci locDeVeci;
	private String denumireParcela;
	private DatePersonale datePersonaleDetinator;
	private DatePersonale datePersonaleInmormantant;
	//Eventual alte date necesare

	
	public LocDeVeci getLocDeVeci() {
		return locDeVeci;
	}
	public LocDeVeciDTO() {
		super();
	}
	public LocDeVeciDTO(LocDeVeci locDeVeci,
			String denumireParcela,
			DatePersonale datePersonaleDetinator,
			DatePersonale datePersonaleInmormantant) {
		super();
		this.locDeVeci = locDeVeci;
		this.denumireParcela = denumireParcela;
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
	public String getDenumireParcela() {
		return denumireParcela;
	}
	public void setDenumireParcela(String denumireParcela) {
		this.denumireParcela = denumireParcela;
	}
	
	
	//+Getters campuri obiecte continute; ex: nume detinator

}
