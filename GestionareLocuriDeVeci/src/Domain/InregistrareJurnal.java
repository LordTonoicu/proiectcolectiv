package Domain;

import java.sql.Timestamp;

public class InregistrareJurnal {

	private int nrInregistare;
	private Timestamp dataOra;
	private String detaliiModificare;

	public InregistrareJurnal() {

	}

	public InregistrareJurnal(int nrInregistrare, Timestamp dataOra,
			String detaliiModificare) {

		this.nrInregistare = nrInregistrare;
		this.dataOra = dataOra;
		this.detaliiModificare = detaliiModificare;
	}

	public int getNrInregistare() {
		return nrInregistare;
	}

	public void setNrInregistare(int nrInregistare) {
		this.nrInregistare = nrInregistare;
	}

	public Timestamp getDataOra() {
		return dataOra;
	}

	public void setDataOra(Timestamp dataOra) {
		this.dataOra = dataOra;
	}

	public String getDetaliiModificare() {
		return detaliiModificare;
	}

	public void setDetaliiModificare(String detaliiModificare) {
		this.detaliiModificare = detaliiModificare;
	}

	@Override
	public String toString() {
		return "InregistrareJurnal [nrInregistare=" + nrInregistare
				+ ", dataOra=" + dataOra + ", detaliiModificare="
				+ detaliiModificare + "]";
	}
}
