package dto;

import domain.DatePersonale;
import domain.Decedat;
import domain.DecedatFaraApartinatori;

public class DecedatFaraApartinatoriDTO {
	
	private DecedatFaraApartinatori decedat;
	private DatePersonale datePersonale;
	private Integer numarLocDeVeci;
	
	public DecedatFaraApartinatoriDTO(DecedatFaraApartinatori decedat, DatePersonale datePersonale, Integer numarCimitir) {
		super();
		this.decedat = decedat;
		this.datePersonale = datePersonale;
		this.numarLocDeVeci = numarCimitir;
	}

	public DecedatFaraApartinatoriDTO() {
		decedat = new DecedatFaraApartinatori();
		datePersonale = new DatePersonale();
	}
	
	public Integer getNumarLocDeVeci() {
		return numarLocDeVeci;
	}

	public void setNumarLocDeVeci(Integer numarLocDeVeci) {
		this.numarLocDeVeci = numarLocDeVeci;
	}

	public DecedatFaraApartinatori getDecedat() {
		return decedat;
	}

	public void setDecedat(DecedatFaraApartinatori decedat) {
		this.decedat = decedat;
	}

	public DatePersonale getDatePersonale() {
		return datePersonale;
	}

	public void setDatePersonale(DatePersonale datePersonale) {
		this.datePersonale = datePersonale;
	}
}
