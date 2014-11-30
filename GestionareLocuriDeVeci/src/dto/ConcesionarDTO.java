package dto;

import domain.Concesionar;
import domain.DatePersonale;

public class ConcesionarDTO {
	
    private Concesionar concesionar;
    private DatePersonale datePersonale;

    public ConcesionarDTO() {
		super();
	}
	public ConcesionarDTO(Concesionar concesionar, DatePersonale datePersonale) {
		super();
		this.concesionar = concesionar;
		this.datePersonale = datePersonale;
	}
	public Concesionar getConcesionar() {
		return concesionar;
	}
	public void setConcesionar(Concesionar concesionar) {
		this.concesionar = concesionar;
	}
	public DatePersonale getDatePersonale() {
		return datePersonale;
	}
	public void setDatePersonale(DatePersonale datePersonale) {
		this.datePersonale = datePersonale;
	}
}
