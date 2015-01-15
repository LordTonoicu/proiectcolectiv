package domain.registers;

import java.util.Date;

public class InregRegContracteConcesiune {
	private int nrCurent;
	private int nrContract;
	private Date dataEliberare;
	private String nume;
	private String prenume;
	private String adresa;
	public InregRegContracteConcesiune(int nrCurent, int nrContract,
			Date dataEliberare, String nume, String prenume, String adresa) {
		super();
		this.nrCurent = nrCurent;
		this.nrContract = nrContract;
		this.dataEliberare = dataEliberare;
		this.nume = nume;
		this.prenume = prenume;
		this.adresa = adresa;
	}
	public int getNrCurent() {
		return nrCurent;
	}
	public void setNrCurent(int nrCurent) {
		this.nrCurent = nrCurent;
	}
	public int getNrContract() {
		return nrContract;
	}
	public void setNrContract(int nrContract) {
		this.nrContract = nrContract;
	}
	public Date getDataEliberare() {
		return dataEliberare;
	}
	public void setDataEliberare(Date dataEliberare) {
		this.dataEliberare = dataEliberare;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getPrenume() {
		return prenume;
	}
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
}
