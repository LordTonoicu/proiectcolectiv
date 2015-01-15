package domain.registers;

import java.sql.Date;

public class InregRegAnualDeProgrInmormantari {
	private String numeDecedat;
	private String prenumeDecedat;
	private String religieDecedat;
	private String parcela;
	private Date dataInmormantarii;
	
	public InregRegAnualDeProgrInmormantari() {
		super();
	}
	public InregRegAnualDeProgrInmormantari(String numeDecedat,
			String prenumeDecedat, String religieDecedat, String parcela,
			Date dataInmormantarii) {
		super();
		this.numeDecedat = numeDecedat;
		this.prenumeDecedat = prenumeDecedat;
		this.religieDecedat = religieDecedat;
		this.parcela = parcela;
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
	public String getParcela() {
		return parcela;
	}
	public void setParcela(String parcela) {
		this.parcela = parcela;
	}
	public Date getDataInmormantarii() {
		return dataInmormantarii;
	}
	public void setDataInmormantarii(Date dataInmormantarii) {
		this.dataInmormantarii = dataInmormantarii;
	}
}
