package domain.registers;

import java.util.Date;

public class InregRegCereriInhumare {
	private Date dataInregistrare;
	private int nrCerere;
	private String stadiuSolutionare;
	
	public InregRegCereriInhumare( Date dataInregistrare,
			int nrCerere, String stadiuSolutionare) {
		super();
		this.dataInregistrare = dataInregistrare;
		this.nrCerere = nrCerere;
		this.stadiuSolutionare = stadiuSolutionare;
	}

	public InregRegCereriInhumare() {

	}

	public Date getDataInregistrare() {
		return dataInregistrare;
	}

	public void setDataInregistrare(Date dataInregistrare) {
		this.dataInregistrare = dataInregistrare;
	}

	public int getNrCerere() {
		return nrCerere;
	}

	public void setNrCerere(int nrCerere) {
		this.nrCerere = nrCerere;
	}

	public String getStadiuSolutionare() {
		return stadiuSolutionare;
	}

	public void setStadiuSolutionare(String stadiuSolutionare) {
		this.stadiuSolutionare = stadiuSolutionare;
	}

}
