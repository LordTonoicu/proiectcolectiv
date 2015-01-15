package domain.registers;

public class InregRegIndexAnualAlDecedatilor {
	
	private String numeDecedat;
	private String prenumeDecedat;
	private String cimitir;
	private String parcela;
	private Integer nrMormant;
	//Fotografia scanata a mormantului - path?
	
	public String getNumeDecedat() {
		return numeDecedat;
	}
	public void setNumeDecedat(String numeDecedat) {
		this.numeDecedat = numeDecedat;
	}
	public String getPrenumeDecedat() {
		return prenumeDecedat;
	}
	public void setPrenumeDecedat(String prenumeDecedat) {
		this.prenumeDecedat = prenumeDecedat;
	}
	public String getCimitir() {
		return cimitir;
	}
	public void setCimitir(String cimitir) {
		this.cimitir = cimitir;
	}
	public String getParcela() {
		return parcela;
	}
	public void setParcela(String parcela) {
		this.parcela = parcela;
	}
	public Integer getNrMormant() {
		return nrMormant;
	}
	public void setNrMormant(Integer nrMormant) {
		this.nrMormant = nrMormant;
	}
	public InregRegIndexAnualAlDecedatilor(String numeDecedat,
			String prenumeDecedat, String cimitir, String parcela,
			Integer nrMormant) {
		super();
		this.numeDecedat = numeDecedat;
		this.prenumeDecedat = prenumeDecedat;
		this.cimitir = cimitir;
		this.parcela = parcela;
		this.nrMormant = nrMormant;
	}
	
	public InregRegIndexAnualAlDecedatilor() {
		super();
	}
}
