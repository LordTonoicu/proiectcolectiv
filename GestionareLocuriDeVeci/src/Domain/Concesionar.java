package Domain;

public class Concesionar {

	private int idConcesionar;
	private String domiciliu;
	private int nrChitanta;
	private String cnpConcesionar;
	private int idLocDeVeci;

	public Concesionar() {

	}

	public Concesionar(int idConcesionar, String domiciliu, int nrChitanta,
			String cnpConcesionar, int idLocDeVeci) {

		this.idConcesionar = idConcesionar;
		this.domiciliu = domiciliu;
		this.nrChitanta = nrChitanta;
		this.cnpConcesionar = cnpConcesionar;
		this.idLocDeVeci = idLocDeVeci;
	}

	public int getIdConcesionar() {
		return idConcesionar;
	}

	public void setIdConcesionar(int idConcesionar) {
		this.idConcesionar = idConcesionar;
	}

	public String getDomiciliu() {
		return domiciliu;
	}

	public void setDomiciliu(String domiciliu) {
		this.domiciliu = domiciliu;
	}

	public int getNrChitanta() {
		return nrChitanta;
	}

	public void setNrChitanta(int nrChitanta) {
		this.nrChitanta = nrChitanta;
	}

	public String getCnpConcesionar() {
		return cnpConcesionar;
	}

	public void setCnpConcesionar(String cnpConcesionar) {
		this.cnpConcesionar = cnpConcesionar;
	}

	public int getIdLocDeVeci() {
		return idLocDeVeci;
	}

	public void setIdLocDeVeci(int idLocDeVeci) {
		this.idLocDeVeci = idLocDeVeci;
	}

	@Override
	public String toString() {
		return "Concesionar [idConcesionar=" + idConcesionar + ", domiciliu="
				+ domiciliu + ", nrChitanta=" + nrChitanta
				+ ", cnpConcesionar=" + cnpConcesionar + ", idLocDeVeci="
				+ idLocDeVeci + "]";
	}
}
