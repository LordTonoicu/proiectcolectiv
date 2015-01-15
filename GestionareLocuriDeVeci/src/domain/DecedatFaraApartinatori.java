package domain;

import java.util.Date;

public class DecedatFaraApartinatori {

	private int idDecedat;
	private String cnpDecedat;
	private int nrAdeverintaInhumare;
	private Date dataInmormantare;
	private int idLocDeVeci;
	private int nrAdeverintaAsistenta;
	private String religie;
	
	public DecedatFaraApartinatori(int idDecedat, String cnpDecedat,
			int nrAdeverintaInhumare, Date dataInmormantare, int idLocDeVeci,
			int nrAdeverintaAsistenta, String religie) {
		super();
		this.idDecedat = idDecedat;
		this.cnpDecedat = cnpDecedat;
		this.nrAdeverintaInhumare = nrAdeverintaInhumare;
		this.dataInmormantare = dataInmormantare;
		this.idLocDeVeci = idLocDeVeci;
		this.nrAdeverintaAsistenta = nrAdeverintaAsistenta;
		this.religie = religie;
	}



	

	public int getIdDecedat() {
		return idDecedat;
	}



	public void setIdDecedat(int idDecedat) {
		this.idDecedat = idDecedat;
	}



	public String getCnpDecedat() {
		return cnpDecedat;
	}



	public void setCnpDecedat(String cnpDecedat) {
		this.cnpDecedat = cnpDecedat;
	}



	public int getNrAdeverintaInhumare() {
		return nrAdeverintaInhumare;
	}



	public void setNrAdeverintaInhumare(int nrAdeverintaDeInhumare) {
		this.nrAdeverintaInhumare = nrAdeverintaDeInhumare;
	}



	public Date getDataInmormantare() {
		return dataInmormantare;
	}



	public void setDataInmormantare(Date dataInmormantare) {
		this.dataInmormantare = dataInmormantare;
	}



	public int getIdLocDeVeci() {
		return idLocDeVeci;
	}



	public void setIdLocDeVeci(int idLocDeVeci) {
		this.idLocDeVeci = idLocDeVeci;
	}



	public int getNrAdeverintaAsistenta() {
		return nrAdeverintaAsistenta;
	}



	public void setNrAdeverintaAsistenta(int nrAdeverintaAsistenta) {
		this.nrAdeverintaAsistenta = nrAdeverintaAsistenta;
	}



	public String getReligie() {
		return religie;
	}



	public void setReligie(String religie) {
		this.religie = religie;
	}



	public DecedatFaraApartinatori() {

	}
	
	

	@Override
	public String toString() {
		return "DecedatFaraApartinatori [idDecedat=" + idDecedat
				+ ", cnpDecedat=" + cnpDecedat + ", nrAdeverintaDeInhumare="
				+ nrAdeverintaInhumare + ", dataInmormantarii="
				+ dataInmormantare + ", idLocDeVeci=" + idLocDeVeci
				+ ", nrAdeverintaAsistenta=" + nrAdeverintaAsistenta + "]"
				+ ", religie=" + religie+ "]";
	}   
}
