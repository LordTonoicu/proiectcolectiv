package domain;

import java.util.Date;

public class DecedatFaraApartinatori {

	private int idDecedat;
	private String cnpDecedat;
	private int nrAdeverintaDeInhumare;
	private Date dataInmormantarii;
	private int idLocDeVeci;
	private int nrAdeverintaAsistenta;

	public DecedatFaraApartinatori() {

	}
	
	public DecedatFaraApartinatori(int idDecedat, String cnpdecedat,
			int nrAdeverintaDeInhumare, Date dataInmormantarii,
			int idLocDeVeci, int nrAdeverintaAsistenta) {

		this.idDecedat = idDecedat;
		this.cnpDecedat = cnpdecedat;
		this.nrAdeverintaDeInhumare = nrAdeverintaDeInhumare;
		this.idLocDeVeci = idLocDeVeci;
		this.nrAdeverintaAsistenta = nrAdeverintaAsistenta;
	}
	
	public DecedatFaraApartinatori(String cnpdecedat,
			int nrAdeverintaDeInhumare, Date dataInmormantarii,
			int idLocDeVeci, int nrAdeverintaAsistenta) {

		this.cnpDecedat = cnpdecedat;
		this.nrAdeverintaDeInhumare = nrAdeverintaDeInhumare;
		this.idLocDeVeci = idLocDeVeci;
		this.nrAdeverintaAsistenta = nrAdeverintaAsistenta;
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

	public int getNrAdeverintaDeInhumare() {
		return nrAdeverintaDeInhumare;
	}

	public void setNrAdeverintaDeInhumare(int nrAdeverintaDeInhumare) {
		this.nrAdeverintaDeInhumare = nrAdeverintaDeInhumare;
	}

	public Date getDataInmormantarii() {
		return dataInmormantarii;
	}

	public void setDataInmormantarii(Date dataInmormantarii) {
		this.dataInmormantarii = dataInmormantarii;
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

	@Override
	public String toString() {
		return "DecedatFaraApartinatori [idDecedat=" + idDecedat
				+ ", cnpDecedat=" + cnpDecedat + ", nrAdeverintaDeInhumare="
				+ nrAdeverintaDeInhumare + ", dataInmormantarii="
				+ dataInmormantarii + ", idLocDeVeci=" + idLocDeVeci
				+ ", nrAdeverintaAsistenta=" + nrAdeverintaAsistenta + "]";
	}
}
