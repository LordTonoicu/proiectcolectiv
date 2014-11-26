package dto;

import Domain.DatePersonale;
import Domain.Decedat;

public class DecedatDTO {
	
	private Decedat decedat;
	private DatePersonale datePersonale;
	private int idParcela;
	
	public DecedatDTO(Decedat decedat, DatePersonale datePersonale,
			int idParcela) {
		super();
		this.decedat = decedat;
		this.datePersonale = datePersonale;
		this.idParcela = idParcela;
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

	public int getIdParcela() {
		return idParcela;
	}

	public void setIdParcela(int idParcela) {
		this.idParcela = idParcela;
	}
}
