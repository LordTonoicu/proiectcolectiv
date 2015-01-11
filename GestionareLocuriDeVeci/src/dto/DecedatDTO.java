package dto;

import domain.DatePersonale;
import domain.Decedat;

public class DecedatDTO {
	
	private Decedat decedat;
	private DatePersonale datePersonale;
	private Integer numarLocDeVeci;
	
	public DecedatDTO(Decedat decedat, DatePersonale datePersonale, Integer numarCimitir) {
		super();
		this.decedat = decedat;
		this.datePersonale = datePersonale;
		this.numarLocDeVeci = numarCimitir;
	}

	public DecedatDTO() {
		decedat = new Decedat();
		datePersonale = new DatePersonale();
	}
	
	public Integer getNumarLocDeVeci() {
		return numarLocDeVeci;
	}

	public void setNumarLocDeVeci(Integer numarLocDeVeci) {
		this.numarLocDeVeci = numarLocDeVeci;
	}

	public Decedat getDecedat() {
		return decedat;
	}

	public void setDecedat(Decedat decedat) {
		this.decedat = decedat;
	}

	public DatePersonale getDatePersonale() {
		return datePersonale;
	}

	public void setDatePersonale(DatePersonale datePersonale) {
		this.datePersonale = datePersonale;
	}
}
