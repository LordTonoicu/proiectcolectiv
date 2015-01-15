package domain;

import java.util.Date;

public class Decedat {

	private int idDecedat;
	private String cnpDecedat;
	private Date dataInmormantare;
	private int nrAdeverintaInhumare;
	private int idLocDeVeci;
	private boolean ePersonalitate;
	private String religie;

	public Decedat() {

	}

	public String getReligie() {
		return religie;
	}


	public void setReligie(String religie) {
		this.religie = religie;
	}

	public Decedat(int idDecedat, String cnpDecedat, Date dataInmormantare,
			int nrAdeverintaInhumare, int idLocDeVeci, boolean ePersonalitate,
			String religie) {

		this.idDecedat = idDecedat;
		this.cnpDecedat = cnpDecedat;
		this.dataInmormantare = dataInmormantare;
		this.nrAdeverintaInhumare = nrAdeverintaInhumare;
		this.idLocDeVeci = idLocDeVeci;
		this.ePersonalitate = ePersonalitate;
		this.religie = religie;
	}
	
	public Decedat(String cnpDecedat, Date dataInmormantare,
			int nrAdeverintaInhumare, int idLocDeVeci, boolean ePersonalitate) {

		this.cnpDecedat = cnpDecedat;
		this.dataInmormantare = dataInmormantare;
		this.nrAdeverintaInhumare = nrAdeverintaInhumare;
		this.idLocDeVeci = idLocDeVeci;
		this.ePersonalitate = ePersonalitate;
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

	public Date getDataInmormantare() {
		return dataInmormantare;
	}

	public void setDataInmormantare(Date dataInmormantare) {
		this.dataInmormantare = dataInmormantare;
	}

	public int getNrAdeverintaInhumare() {
		return nrAdeverintaInhumare;
	}

	public void setNrAdeverintaInhumare(int nrAdeverintaInhumare) {
		this.nrAdeverintaInhumare = nrAdeverintaInhumare;
	}

	public int getIdLocDeVeci() {
		return idLocDeVeci;
	}

	public void setIdLocDeVeci(int idLocDeVeci) {
		this.idLocDeVeci = idLocDeVeci;
	}

	public boolean isePersonalitate() {
		return ePersonalitate;
	}

	public void setePersonalitate(boolean ePersonalitate) {
		this.ePersonalitate = ePersonalitate;
	}

	@Override
	public String toString() {
		return "Decedat [cnp(" + cnpDecedat
				+ ") dataInmormantare(" + dataInmormantare
				+ ") nrAdeverintaInhumare(" + nrAdeverintaInhumare
				+ ") Personalitate("
				+ ePersonalitate + ")]";
	}
}
