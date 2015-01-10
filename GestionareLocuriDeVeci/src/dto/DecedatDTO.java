package dto;

import domain.DatePersonale;
import domain.Decedat;

public class DecedatDTO {
	
	private Decedat decedat;
	private DatePersonale datePersonale;
	private Integer numarCimitir;
	
	public DecedatDTO(Decedat decedat, DatePersonale datePersonale, Integer numarCimitir) {
		super();
		this.decedat = decedat;
		this.datePersonale = datePersonale;
		this.numarCimitir = numarCimitir;
	}

	public DecedatDTO() {
		decedat = new Decedat();
		datePersonale = new DatePersonale();
	}
	
	public Integer getNumarCimitir() {
		return numarCimitir;
	}

	public void setNumarCimitir(Integer numarCimitir) {
		this.numarCimitir = numarCimitir;
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
