package Domain;

import java.util.Date;

public class CerereInhumare {

	private int nrCerere;
	private Date dataInregistrare;
	private String stadiuSolutionare;
	private String cnpConcesionar;

	public CerereInhumare() {

	}

	public CerereInhumare(Date dataInregistrare,
			String stadiuSolutionare, String cnpConcesionar) {

		this.dataInregistrare = dataInregistrare;
		this.stadiuSolutionare = stadiuSolutionare;
		this.cnpConcesionar = cnpConcesionar;
	}

	public CerereInhumare(int nrCerere, Date dataInregistrare,
			String stadiuSolutionare, String cnpConcesionar) {

		this.nrCerere = nrCerere;
		this.dataInregistrare = dataInregistrare;
		this.stadiuSolutionare = stadiuSolutionare;
		this.cnpConcesionar = cnpConcesionar;
	}

	public int getNrCerere() {
		return nrCerere;
	}

	public void setNrCerere(int nrCerere) {
		this.nrCerere = nrCerere;
	}

	public Date getDataInregistrare() {
		return dataInregistrare;
	}

	public void setDataInregistrare(Date dataInregistrare) {
		this.dataInregistrare = dataInregistrare;
	}

	public String getStadiuSolutionare() {
		return stadiuSolutionare;
	}

	public void setStadiuSolutionare(String stadiuSolutionare) {
		this.stadiuSolutionare = stadiuSolutionare;
	}

	public String getCnpConcesionar() {
		return cnpConcesionar;
	}

	public void setCnpConcesionar(String cnpConcesionar) {
		this.cnpConcesionar = cnpConcesionar;
	}
}
