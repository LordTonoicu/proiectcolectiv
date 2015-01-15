package domain.registers;

import java.util.Date;

public class InregRegDecedatiFaraApartinatori {
	private String nume;
	private String prenume;
	private String cimitir;
	private String parcela;
	private String nrMormant;
	private Date dataInmormantare;
	private int nrAdeverintaInhumare;
	private int nrAdeverintaAsistenta;
	
	public InregRegDecedatiFaraApartinatori(String nume, String prenume,
			String cimitir, String parcela, String nrMormant,
			Date dataInmormantare, int nrAdeverintaInhumare,
			int nrAdeverintaAsistenta) {
		super();
		this.nume = nume;
		this.prenume = prenume;
		this.cimitir = cimitir;
		this.parcela = parcela;
		this.nrMormant = nrMormant;
		this.dataInmormantare = dataInmormantare;
		this.nrAdeverintaInhumare = nrAdeverintaInhumare;
		this.nrAdeverintaAsistenta = nrAdeverintaAsistenta;
	}

	public InregRegDecedatiFaraApartinatori() {
		// TODO Auto-generated constructor stub
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

	public String getNrMormant() {
		return nrMormant;
	}

	public void setNrMormant(String nrMormant) {
		this.nrMormant = nrMormant;
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

	public int getNrAdeverintaAsistenta() {
		return nrAdeverintaAsistenta;
	}

	public void setNrAdeverintaAsistenta(int nrAdeverintaAsistenta) {
		this.nrAdeverintaAsistenta = nrAdeverintaAsistenta;
	}
	
}
