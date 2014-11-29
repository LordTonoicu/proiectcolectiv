package dto;

import domain.DatePersonale;
import domain.Decedat;

public class DecedatDTO {
	
	private Decedat decedat;
	private DatePersonale datePersonale;
	
	public DecedatDTO(Decedat decedat, DatePersonale datePersonale) {
		super();
		this.decedat = decedat;
		this.datePersonale = datePersonale;
	}

	public DecedatDTO() {
		super();
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
