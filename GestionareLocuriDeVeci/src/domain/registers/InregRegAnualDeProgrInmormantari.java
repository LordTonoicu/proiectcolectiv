package domain.registers;

import java.sql.Date;

public class InregRegAnualDeProgrInmormantari {
	private String numeDecedat;
	private String prenumeDecedat;
	private String religieDecedat;
	private String cimitir;
	private String parcela;
	private String nrLoc;
	private Date dataInmormantarii;
	public InregRegAnualDeProgrInmormantari(String numeDecedat,
			String prenumeDecedat, String religieDecedat, String cimitir,
			String parcela, String nrLoc, Date dataInmormantarii) {
		super();
		this.numeDecedat = numeDecedat;
		this.prenumeDecedat = prenumeDecedat;
		this.religieDecedat = religieDecedat;
		this.cimitir = cimitir;
		this.parcela = parcela;
		this.nrLoc = nrLoc;
		this.dataInmormantarii = dataInmormantarii;
	}
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
	public String getReligieDecedat() {
		return religieDecedat;
	}
	public void setReligieDecedat(String religieDecedat) {
		this.religieDecedat = religieDecedat;
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
	public String getNrLoc() {
		return nrLoc;
	}
	public void setNrLoc(String nrLoc) {
		this.nrLoc = nrLoc;
	}
	public Date getDataInmormantarii() {
		return dataInmormantarii;
	}
	public void setDataInmormantarii(Date dataInmormantarii) {
		this.dataInmormantarii = dataInmormantarii;
	}
	
	
}
