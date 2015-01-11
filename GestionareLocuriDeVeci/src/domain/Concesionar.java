package domain;

public class Concesionar {

	private int idConcesionar;
	private String domiciliu;
	private int nrChitanta;
	private String cnpConcesionar;

	public Concesionar() {

	}
	
	public Concesionar(String domiciliu, int nrChitanta,
			String cnpConcesionar) {

		this.domiciliu = domiciliu;
		this.nrChitanta = nrChitanta;
		this.cnpConcesionar = cnpConcesionar;
	}
	
	public Concesionar(int idConcesionar, String domiciliu, int nrChitanta,
			String cnp) {

		this.idConcesionar = idConcesionar;
		this.domiciliu = domiciliu;
		this.nrChitanta = nrChitanta;
		this.cnpConcesionar = cnp;
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


	@Override
	public String toString() {
		return "Concesionar [domiciliu("
				+ domiciliu + ") nrChitanta(" + nrChitanta
				+ ") cnpConcesionar(" + cnpConcesionar + ")]";
	}
}
