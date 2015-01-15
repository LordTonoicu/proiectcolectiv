package domain.registers;

import java.util.Date;

public class InregRegCereriInhumare {
	public InregRegCereriInhumare(int nrCurent, Date dataInregistrare,
			int nrInfocet, String stadiuSolutionare) {
		super();
		this.nrCurent = nrCurent;
		this.dataInregistrare = dataInregistrare;
		this.nrInfocet = nrInfocet;
		this.stadiuSolutionare = stadiuSolutionare;
	}
	//TODO: generat in DAO. pls, sa nu ne chinuim prea mult
	private int nrCurent;
	private Date dataInregistrare;
	private int nrInfocet;
	private String stadiuSolutionare;
	public int getNrCurent() {
		return nrCurent;
	}
	public void setNrCurent(int nrCurent) {
		this.nrCurent = nrCurent;
	}
	public Date getDataInregistrare() {
		return dataInregistrare;
	}
	public void setDataInregistrare(Date dataInregistrare) {
		this.dataInregistrare = dataInregistrare;
	}
	public int getNrInfocet() {
		return nrInfocet;
	}
	public void setNrInfocet(int nrInfocet) {
		this.nrInfocet = nrInfocet;
	}
	public String getStadiuSolutionare() {
		return stadiuSolutionare;
	}
	public void setStadiuSolutionare(String stadiuSolutionare) {
		this.stadiuSolutionare = stadiuSolutionare;
	}
	
}
