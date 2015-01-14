package dto;

import domain.CerereInhumare;

public class CerereInhumareDTO {
	private ConcesionarDTO concesionarDTO;
	private CerereInhumare cerereInhumare;

	public CerereInhumareDTO() {
		super();
	}

	public CerereInhumareDTO(ConcesionarDTO concesionarDTO,
			CerereInhumare cerereInhumare) {
		super();
		this.concesionarDTO = concesionarDTO;
		this.cerereInhumare = cerereInhumare;
	}
	
	public ConcesionarDTO getConcesionarDTO() {
		return concesionarDTO;
	}

	public void setConcesionarDTO(ConcesionarDTO concesionarDTO) {
		this.concesionarDTO = concesionarDTO;
	}

	public CerereInhumare getCerereInhumare() {
		return cerereInhumare;
	}

	public void setCerereInhumare(CerereInhumare cerereInhumare) {
		this.cerereInhumare = cerereInhumare;
	}

}
